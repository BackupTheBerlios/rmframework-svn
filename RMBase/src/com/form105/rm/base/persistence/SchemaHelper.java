package com.form105.rm.base.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.connection.ConnectionProviderFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.mapping.Table;
import org.hibernate.pretty.DDLFormatter;
import org.hibernate.tool.hbm2ddl.DatabaseMetadata;
import org.hibernate.util.JDBCExceptionReporter;

public class SchemaHelper {

    private static Logger logger = Logger.getLogger(SchemaHelper.class);
    private static final String HIBERNATE_CFG_XML = "/hibernate.cfg.xml";
    private AnnotationConfiguration cfg = new AnnotationConfiguration();
    private Properties props = new Properties();
    private Dialect dialect;
    private ConnectionProvider connectionProvider;
    private Connection connection;
    private ArrayList<Exception> exceptions = new ArrayList<Exception>();

    public SchemaHelper(String schema) {
        cfg.configure(HIBERNATE_CFG_XML);
        // need this for drop Table (IMPORTANT)
        if (schema != null) {
            cfg.setProperty(Environment.DEFAULT_SCHEMA, schema);
        }
        dialect = Dialect.getDialect(cfg.getProperties());
        props.putAll(dialect.getDefaultProperties());
        props.putAll(cfg.getProperties());

        // need this for update table (IMPORTANT)
        if (schema != null) {
            props.put(Environment.DEFAULT_SCHEMA, schema);
        }
        initialize(props);
    }

    public SchemaHelper() {
        this(null);
    }

    /**
     * Initializes the hibernate configuration and creates the sql statements to
     * drop and create tables.
     */
    private void initialize(Properties props) {
        exceptions = new ArrayList<Exception>();
        connectionProvider = ConnectionProviderFactory.newConnectionProvider(props);

    }

    /**
     * Initializes the connection based on the properties
     * 
     * @param needsAutoCommit
     * @return The conneciton
     * @throws SQLException
     */
    public Connection prepare(boolean needsAutoCommit) throws SQLException {
        connectionProvider = ConnectionProviderFactory.newConnectionProvider(props);
        connection = connectionProvider.getConnection();
        if (needsAutoCommit && !connection.getAutoCommit()) {
            connection.commit();
            connection.setAutoCommit(true);
        }
        return connection;
    }

    /**
     * Drop all tables that are reflected through the configuration. The schema
     * is set by the constructor.
     * 
     */
    public void dropSchema() {

        Connection connection = null;
        Statement stmt = null;

        exceptions.clear();
        try {

            DatabaseMetadata meta;
            try {
                logger.info("fetching database metadata");
                connection = prepare(true);
                stmt = connection.createStatement();
            } catch (SQLException sqle) {
                exceptions.add(sqle);
                logger.error("could not get database metadata", sqle);
                throw sqle;
            }

            logger.info("updating schema");

            String[] dropSQL = cfg.generateDropSchemaScript(dialect);
            for (int j = 0; j < dropSQL.length; j++) {

                final String sql = dropSQL[j];
                try {
                    logger.info("Drop Table: " + sql);
                    stmt.executeUpdate(sql);
                } catch (SQLException e) {
                    exceptions.add(e);
                    logger.error("Unsuccessful: " + sql);
                    logger.error(e.getMessage());
                }
            }

            logger.info("schema update complete");

        } catch (Exception e) {
            exceptions.add(e);
            logger.error("could not complete schema update", e);
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();
                }
                release();
            } catch (Exception e) {
                exceptions.add(e);
                logger.error("Error closing connection", e);
            }

        }
    }

    public void updateSchema() {
        Connection connection = null;
        Statement stmt = null;

        exceptions.clear();
        try {

            DatabaseMetadata meta;
            try {
                logger.info("fetching database metadata");
                connection = prepare(true);
                meta = new DatabaseMetadata(connection, dialect);
                stmt = connection.createStatement();
            } catch (SQLException sqle) {
                exceptions.add(sqle);
                logger.error("could not get database metadata", sqle);
                throw sqle;
            }

            logger.info("updating schema");

            String[] createSQL = cfg.generateSchemaUpdateScript(dialect, meta);
            for (int j = 0; j < createSQL.length; j++) {

                final String sql = createSQL[j];
                try {
                    stmt.executeUpdate(sql);
                } catch (SQLException e) {
                    exceptions.add(e);
                    logger.error("Unsuccessful: " + sql);
                    logger.error(e.getMessage());
                }
            }
            logger.info("schema update complete");

        } catch (Exception e) {
            exceptions.add(e);
            logger.error("could not complete schema update", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                release();
            } catch (Exception e) {
                exceptions.add(e);
                logger.error("Error closing connection", e);
            }
        }
    }

    /**
     * Checks the tables of hibernate configuration. If the tables exist, the
     * result will be reported to the DatabaseTable.
     * 
     * @return List of DatabaseTable
     * @throws SQLException
     */
    public List<DatabaseTable> checkTable() {

        ArrayList<DatabaseTable> dbTables = new ArrayList<DatabaseTable>();

        Connection connection = null;
        Statement stmt = null;

        exceptions.clear();

        try {
            connection = prepare(true);
            Statement statement = connection.createStatement();

            try {

                DatabaseMetadata meta;
                try {
                    logger.info("fetching database metadata");
                    connection = prepare(true);
                    meta = new DatabaseMetadata(connection, dialect);
                    stmt = connection.createStatement();
                } catch (SQLException sqle) {
                    exceptions.add(sqle);
                    logger.error("could not get database metadata", sqle);
                    throw sqle;
                }

                logger.info("updating schema");

                List<String> tableList = getTables();
                logger.info("Number of tables: " + tableList.size());
                for (String tableName : getTables()) {

                    DatabaseTable table = new DatabaseTable();
                    String schemaName = cfg.getProperty(Environment.DEFAULT_SCHEMA);
                    String sql = "select count(*) from " + schemaName + "." + tableName;
                    try {
                        table.setTableName(schemaName + "." + tableName);
                        table.setExists(statement.execute(sql));
                        dbTables.add(table);
                    } catch (SQLException e) {
                        exceptions.add(e);
                        table.setExists(false);
                        dbTables.add(table);
                        logger.error("Unsuccessful: " + sql);
                        logger.error(e.getMessage());
                    }
                }
                logger.info("Checking table complete");

            } catch (Exception e) {
                exceptions.add(e);
                logger.error("could not complete querying tables", e);
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    release();
                } catch (Exception e) {
                    exceptions.add(e);
                    logger.error("Error closing connection", e);
                }
            }

        } catch (Exception sEx) {

            logger.error(sEx, sEx);
        } finally {
            try {
                release();
            } catch (SQLException sEx) {
                logger.error(sEx, sEx);
            }
        }
        return dbTables;
    }

    private void release() throws SQLException {
        if (connection != null) {
            try {
                JDBCExceptionReporter.logAndClearWarnings(connection);
                connectionProvider.closeConnection(connection);
            } finally {
                connectionProvider.close();
            }
        }
        connection = null;
    }

    private String format(String sql) {
        return new DDLFormatter(sql).format();
    }

    public List<String> getTables() {
        ArrayList<String> list = new ArrayList<String>();
        Iterator iter = cfg.getTableMappings();
        while (iter.hasNext()) {
            Table table = (Table) iter.next();
            list.add(table.getName());
        }
        return list;

    }
}
