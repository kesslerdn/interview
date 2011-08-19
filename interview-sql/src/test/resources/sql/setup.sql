drop table Person if exists;
create table Person (Id bigint Not Null Auto_Increment, FirstName varchar(50), LastName varchar(50), Primary Key(Id));

insert into Person (FirstName, LastName) values ('andy', 'anderson');
insert into Person (FirstName, LastName) values ('bob', 'bobberson');
insert into Person (FirstName, LastName) values ('fred', 'fredrickson');
insert into Person (FirstName, LastName) values ('carry', 'carlson');
insert into Person (FirstName, LastName) values ('david', 'davidson');
insert into Person (FirstName, LastName) values ('erin', 'ericson');
insert into Person (FirstName, LastName) values ('greg', 'grossman');
insert into Person (FirstName, LastName) values ('harry', 'hanover');