create database ho_khau;
create table hokhau(
	maHk varchar(255) primary key,
    tenChuHo varchar(255),
    ngaylap date,
    diaChi varchar(255)
);
create table thanhvien(
	cmnd varchar(255) primary key,
    ten varchar(255),
    ngSinh date,
    maHk varchar(255),
    foreign key (maHk) references hokhau(maHk)
);
insert into hokhau values 
('HK-001','Nguyen Van A','1990-11-11','ĐN'),
('HK-002','Nguyen Van B','1990-12-15','QN'),
('HK-003','Nguyen Van C','1995-11-11','QT'),
('HK-004','Nguyen Van D','1994-11-11','QB'),
('HK-005','Nguyen Van E','1991-11-11','Hue'),
('HK-006','Nguyen Van F','1992-11-11','HN');

insert into thanhvien  values
('111111111','Nguyen Van A', '1888-11-11','HK-001'),
('111111112','Nguyen Van AAA', '1888-11-11','HK-001'),
('111111113','Nguyen Van Â', '1888-11-11','HK-001'),
('111111114','Nguyen Van B', '1888-11-11','HK-002'),
('111111115','Nguyen Van Ban', '1888-11-11','HK-002'),
('111111116','Nguyen Van Bo', '1888-11-11','HK-002'),
('111111117','Nguyen Van C', '1888-11-11','HK-003'),
('111111118','Nguyen Van Co', '1888-11-11','HK-003'),
('111111119','Nguyen Van Cat', '1888-11-11','HK-003'),
('1111111110','Nguyen Van D', '1888-11-11','HK-004'),
('1111111111','Nguyen Van Duy', '1888-11-11','HK-004'),
('1111111112','Nguyen Van Dy', '1888-11-11','HK-004'),
('1111111113','Nguyen Van E', '1888-11-11','HK-005'),
('1111111114','Nguyen Van Em', '1888-11-11','HK-005'),
('1111111115','Nguyen Van En', '1888-11-11','HK-005'),
('1111111116','Nguyen Van F', '1888-11-11','HK-006'),
('1111111117','Nguyen Van Fhi', '1888-11-11','HK-006'),
('1111111118','Nguyen Van Fha', '1888-11-11','HK-006'),
('1111111119','Nguyen Van Fa', '1888-11-11','HK-006');

select hk.maHk, tenChuHo,ngaylap,diaChi,count(tv.maHk) as sl from hokhau hk
join thanhvien tv on hk.maHk=tv.maHk
where hk.maHk like 'hk-006'
group by tv.maHk;


select maHk,count(*) as sl from thanhvien
group by maHk;

select *from thanhvien where maHk like 'hk-001';

-- tìm kiếm
select hk.maHk, tenChuHo,ngaylap,diaChi,count(tv.maHk) as sl from hokhau hk
join thanhvien tv on hk.maHk=tv.maHk
where hk.diaChi like '%Q%'
group by tv.maHk;

