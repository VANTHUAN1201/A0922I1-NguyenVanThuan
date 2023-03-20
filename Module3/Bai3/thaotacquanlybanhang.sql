use quan_li_ban_hang;
insert into customer
values ( 1,'Minh Quan',10),
		(2,'Ngoc Oanh',20),
		( 3,'Hong Ha',50);

insert into `order`(id, customer_id, date)
values (1,1,'2006-03-21');
insert into `order`(id, customer_id, date)
values	(2,2,'2006-03-23');
insert into `order`(id, customer_id, date)
values (3,1,'2006-03-16');

insert into product
values(1,'May Giat',3),
		(2,'Tu Lanh',5),
		(3,'Dieu Hoa',7),
		(4,'Quat',1),
		(5,'Bep Dien',2);
        
insert into order_detail
values(1,1,3),
		(1,3,7),
		(1,4,2),
		(2,1,1),
		(3,1,8),
		(2,5,4),
		(2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
 select id,`date`,total_price
 from `order`;
 
 -- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.id,c.name,p.name
from customer c,`order` o,order_detail od,product p
where c.id=o.customer_id and o.id=od.order_id and od.product_id=p.id;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select *
from customer c
where c.name not in
(select c.name
from customer c,`order` o,order_detail od,product p
where c.id=o.customer_id and o.id=od.order_id and od.product_id=p.id
);
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
select o.id,o.date,sum(od.qty*p.price) as total_price
from `order` o,order_detail od,product p
where o.id=od.order_id and od.product_id=p.id
group by o.id;












	