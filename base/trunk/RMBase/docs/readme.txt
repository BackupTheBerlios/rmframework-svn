added to .classpath:
<classpathentry kind="src" path="target/generated-sources/xmlbeans" including="**/*.java"/>

install RMxmlHelper to local maven repository:
mvn install:install-file
  -Dfile=<path-to-file>
  -DgroupId=<group-id>
  -DartifactId=<artifact-id>
  -Dversion=<version>
  -Dpackaging=<packaging>
  -DgeneratePom=true

Where: <path-to-file>  the path to the file to load
       <group-id>      the group that the file should be registered under
       <artifact-id>   the artifact name for the file
       <version>       the version of the file
       <packaging>     the packaging of the file e.g. jar
       
       -Dfile="/Users/heikok/development/workspace/RMdbIntegration/lib/sljc.jar" 
       -DgroupId=FileMaker -DartifactId=sequelinkFileMaker 
       -Dversion=5.05 
       -Dpackaging=jar 
       -DgeneratePOM=true
