create database student_management;
create table Class(
	id int primary key,
	name varchar(255)
);
create table Teacher(
	id int primary key,
    name varchar(255),
    age int,
    country varchar(255)
);