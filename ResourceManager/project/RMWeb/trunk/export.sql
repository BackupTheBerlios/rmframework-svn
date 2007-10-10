
    alter table categoryww_categoryww 
        drop constraint FK6AFE8EDFD69D4837;

    alter table categoryww_categoryww 
        drop constraint FK6AFE8EDFA8A8FEF6;

    drop table SystemUser;

    drop table categoryww;

    drop table categoryww_categoryww;

    create table SystemUser (
        id integer not null,
        name varchar(255),
        primary key (id)
    );

    create table categoryww (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table categoryww_categoryww (
        categoryww_id bigint not null,
        children_id bigint not null,
        primary key (categoryww_id, children_id),
        unique (children_id)
    );

    alter table categoryww_categoryww 
        add constraint FK6AFE8EDFD69D4837 
        foreign key (categoryww_id) 
        references categoryww;

    alter table categoryww_categoryww 
        add constraint FK6AFE8EDFA8A8FEF6 
        foreign key (children_id) 
        references categoryww;
