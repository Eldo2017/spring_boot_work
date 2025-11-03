create table jpapaging (
	id number primary key,
	name varchar2(20),
	email varchar2(50)
);

create sequence jpapaging_seq nocache;

insert into jpapaging values(jpapaging_seq.nextval, 'user01', 'user01@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user02', 'user02@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user03', 'user03@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user04', 'user04@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user05', 'user05@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user06', 'user06@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user07', 'user07@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user08', 'user08@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user09', 'user09@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user10', 'user10@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user11', 'user11@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user12', 'user12@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user13', 'user13@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user14', 'user14@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user15', 'user15@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user16', 'user16@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user17', 'user17@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user18', 'user18@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user19', 'user19@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user20', 'user20@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user21', 'user21@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user22', 'user22@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user23', 'user23@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user24', 'user24@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user25', 'user25@tjoeun.com');
insert into jpapaging values(jpapaging_seq.nextval, 'user26', 'user26@tjoeun.com');
commit;