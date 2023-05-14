DELIMITER $$
CREATE PROCEDURE search_all()
begin
	select *
    from user;
end; $$
DELIMITER ;

call search_all();
-- -----
DELIMITER $$
CREATE PROCEDURE update_user(in id_user int, in st_name varchar(255), in st_email varchar(255), in st_country varchar(255))
begin
	update user 
    set `name`=st_name,email=st_email,country=st_country
    where id=id_user;
end; $$
DELIMITER ;
call update_user(11,"chung","ben123@gmail.com","Thái Lan");
-- -----
DELIMITER $$
CREATE PROCEDURE delete_user(in id_user int)
begin
	delete from user 
    where id=id_user;
end; $$
DELIMITER ;
call delete_user(11);