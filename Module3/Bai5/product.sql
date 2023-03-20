create database product;
use product;

create table products(
	id int AUTO_INCREMENT PRIMARY KEY,
    `code` varchar(50),
    `name` nvarchar(255),
    price int,
    amount int,
    `description` nvarchar(255),
    `status` tinyint   
);
insert into products
values(1,"sp_1","bút chì 2B",3000,50,"bút chì 2B",1),
		(2,"sp_2","bút bi thiên long",5000,50,"bút bi thiên long",1),
		(3,"sp_3","sách tiếng việt lớp 5",20000,25,"sách tiếng việt lớp 5",1),
		(4,"sp_4","sách toán lớp 5",30000,25,"sách toán lớp 5",1),
		(5,"sp_5","sách tin học lớp 5",20000,25,"sách tin học lớp 5",1),
		(6,"sp_6","bút xóa",10000,25,"bút xóa",1),
		(7,"sp_7","thước kẻ",5000,25,"thước kẻ",1),
		(8,"sp_8","ba lô",200000,25,"ba lô",1),
		(9,"sp_9","hộp đựng dụng cụ",15000,25,"hộp đựng dụng cụ",1),
		(10,"sp_10","compa",10000,25,"compa",1);
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create index indexCode on products(`code`);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index indexName_Price on products(`name`,price);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM products WHERE `code` = 'sp_6';
EXPLAIN SELECT `name`,price FROM products WHERE `name` = 'ba lô' and price=200000;
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view thong_tin
as
select `code`,`name`,price,`status` from products;
select * from thong_tin;
-- sửa view
update thong_tin
set price =10000
where `name`="bút chì 2B";
-- xóa view
drop view thong_tin;
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product

DELIMITER &&
CREATE PROCEDURE all_products()
BEGIN
  SELECT * FROM products;
END &&
DELIMITER ;

call all_products();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER &&
CREATE PROCEDURE add_products()
BEGIN
  insert into products(`code`,`name`,price,amount,`description`,`status`)
  values("sp_11","sách âm nhạc lớp 5",20000,25,"sách âm nhạc lớp 5",1);
END &&
DELIMITER ;

call add_products();
call all_products();

-- Tạo store procedure sửa thông tin sản phẩm theo id

DELIMITER &&
CREATE PROCEDURE update_products(in  i int)
BEGIN
  update products
  set `code`= "sp_12",
		`name`=" sp sửa",
		price= 100000,
		amount=25,
		`description`="sản phẩm mới sửa",
		`status`= 1
  where id = i;
END &&
DELIMITER ;

call update_products(3);
call all_products();

-- xóa sản phẩm theo id

DELIMITER &&
CREATE PROCEDURE delete_products(in  i int)
BEGIN
  delete from products
  where id = i;
END &&
DELIMITER ;

call delete_products(2);
call all_products();