create database quan_li_ban_hang;
create table customer(
	id int primary key,
    `name` varchar(255),
    age int
);
create table `order`(
	id int primary key,
    customer_id int not null,
    foreign key(customer_id) references customer(id),
    `date` date,
    total_price int
);
create table product(
	id int primary key,
    `name` varchar(255),
    price int
);
create table order_detail(
	order_id int,
    product_id int ,
	foreign key(order_id) references  `order`(id),
    foreign key(product_id) references product(id),
    qty int,
    primary key(order_id,product_id)
);
