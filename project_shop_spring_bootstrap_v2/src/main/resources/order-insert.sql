insert into orders(no,description,orderdate,price,userid) values (orders_no_SEQ.nextval,'비글외1종',sysdate-2,1050000,'guard1');
insert into orderitem(no,qty,orderno,productno) values(orderitem_no_SEQ.nextval,1,orders_no_SEQ.currval,1);
insert into orderitem(no,qty,orderno,productno) values(orderitem_no_SEQ.nextval,1,orders_no_SEQ.currval,2);

insert into orders(no,description,orderdate,price,userid) values (orders_no_SEQ.nextval,'퍼그외0종',sysdate-1,400000,'guard1');
insert into orderitem(no,qty,orderno,productno) values(orderitem_no_SEQ.nextval,1,orders_no_SEQ.currval,3);

insert into orders(no,description,orderdate,price,userid) values (orders_no_SEQ.nextval,'페키니즈외1종',sysdate,1450000,'guard1');
insert into orderitem(no,qty,orderno,productno) values(orderitem_no_SEQ.nextval,1,orders_no_SEQ.currval,4);
insert into orderitem(no,qty,orderno,productno) values(orderitem_no_SEQ.nextval,2,orders_no_SEQ.currval,2);


insert into orders(no,description,orderdate,price,userid) values (orders_no_SEQ.nextval,'달마시안외0종',sysdate-1,500000,'guard2');
insert into orderitem(no,qty,orderno,productno) values(orderitem_no_SEQ.nextval,1,orders_no_SEQ.currval,2);


insert into orders(no,description,orderdate,price,userid) values (orders_no_SEQ.nextval,'비글외1종',sysdate,1000000,'guard2');
insert into orderitem(no,qty,orderno,productno) values(orderitem_no_SEQ.nextval,1,orders_no_SEQ.currval,2);
insert into orderitem(no,qty,orderno,productno) values(orderitem_no_SEQ.nextval,1,orders_no_SEQ.currval,4);
