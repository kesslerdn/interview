drop table Person if exists;
create table Person (Id bigint identity, FirstName varchar, LastName varchar);

drop table Address if exists;
create table Address (Id bigint identity, Street varchar, City varchar, State varchar, Zip varchar);

drop table Person_Address if exists;
create table Person_Address (Person_Id bigint, Address_Id bigint)