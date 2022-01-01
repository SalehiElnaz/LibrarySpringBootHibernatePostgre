insert into "CentralLib".book (id,author,"book_Title")values(103,'{Something Wild}','{Hanna Halperin}');

insert into "CentralLib".member (member_id,member_name,"password") values (500,'{Elnaz}','{12345}');
insert into "CentralLib".member (member_id,member_name,"password") values (501,'{Sara}','{12345}');
insert into "CentralLib".member (member_id,member_name,"password") values (502,'{Mina}','{12345}');

insert into "CentralLib".borrow (borrow_id,book_id,member_id,start_date,returned_date)
values(600,102,500,'2021-03-11','2021-03-15');
insert into "CentralLib".borrow (borrow_id,book_id,member_id,start_date,returned_date)
values(601,103,501,'2021-04-11','2021-04-15');
insert into "CentralLib".borrow (borrow_id,book_id,member_id,start_date,returned_date)
values(603,102,501,'2021-03-11','2021-03-15');
insert into "CentralLib".borrow (borrow_id,book_id,member_id,start_date,returned_date)
values(604,102,502,'2021-04-11','2021-04-15');