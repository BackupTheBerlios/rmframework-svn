
    alter table ABSTRACTCATEGORY 
        drop constraint FKFACF4B2078D9F2A7;

    alter table ABSTRACTCATEGORY 
        drop constraint FKFACF4B203D834D87;

    alter table CATEGORY 
        drop constraint FK31A8ACFED480F0D9;

    drop table ABSTRACTCATEGORY;

    drop table CATEGORY;

    drop table hibernate_unique_key;

    create table ABSTRACTCATEGORY (
        OID bigint not null,
        name varchar(40),
        PARENT bigint,
        CHILDREN integer,
        primary key (OID)
    );

    create table CATEGORY (
        CATEGORY_ID bigint not null,
        TESTNAME varchar(255),
        primary key (CATEGORY_ID)
    );

    create index fk_parent_category on ABSTRACTCATEGORY (PARENT);

    alter table ABSTRACTCATEGORY 
        add constraint FKFACF4B2078D9F2A7 
        foreign key (OID) 
        references ABSTRACTCATEGORY;

    alter table ABSTRACTCATEGORY 
        add constraint FKFACF4B203D834D87 
        foreign key (PARENT) 
        references ABSTRACTCATEGORY;

    alter table CATEGORY 
        add constraint FK31A8ACFED480F0D9 
        foreign key (CATEGORY_ID) 
        references ABSTRACTCATEGORY;

    create table hibernate_unique_key (
         next_hi integer 
    );

    insert into hibernate_unique_key values ( 0 );
