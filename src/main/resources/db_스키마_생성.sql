  create table group_common_code (
       id bigint not null auto_increment,
        mod_date datetime(6),
        reg_date datetime(6),
        code_name varchar(255),
        code_value varchar(255),
        primary key (id)
    ) engine=InnoDB;



    create table common_code (
       id bigint not null auto_increment,
        mod_date datetime(6),
        reg_date datetime(6),
        code_name varchar(255),
        code_value varchar(255),
        group_common_code_id bigint,
        primary key (id)
    ) engine=InnoDB;

     alter table common_code
         add constraint FKa8220q54810tpef671coq97de
         foreign key (group_common_code_id)
         references group_common_code (id);
