create table movie (id bigint not null auto_increment, category varchar(255) not null, created_date datetime not null, director varchar(255) not null, title varchar(255) not null, updated_date datetime not null, shelf_id bigint, primary key (id));
create table shelf (id bigint not null auto_increment, created_date datetime not null, location varchar(255) not null, updated_date datetime not null, primary key (id));
alter table movie add constraint FKrt777bw0dy89i2kr6io07j6ow foreign key (shelf_id) references shelf (id);
