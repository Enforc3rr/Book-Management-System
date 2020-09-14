create database BMT ;
use BMT ;

create table user(
id int auto_increment primary key,
name varchar(64) ,
userName varchar(64) unique  ,
mobileNumber varchar(64) ,
address varchar(64) ,
email varchar(64) ,
password varchar(64) 
);
create table books(
id int auto_increment primary key ,
bookName varchar(64) unique ,
authorName varchar(64),
genre varchar(64),
yearOfPublication varchar(64) ,
description text(64) 
);
create table temp(
id int ,
tempUserName varchar(64)
);
create table admin(
adminUserName varchar(64),
adminPassword varchar(64)
);
