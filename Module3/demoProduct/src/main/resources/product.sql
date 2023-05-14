create database demo_product;
use demo_product;
create table category(
	id_category int primary key,
    category_name varchar(255)
);

create table product(
	id int auto_increment primary key,
    `name` varchar(255),
    price int,
    amount int,
    id_category int,
    foreign key (id_category) references category(id_category)
);
select id,`name`,price,amount,c.category_name 
from product p
join category c on p.id_category=c.id_category;