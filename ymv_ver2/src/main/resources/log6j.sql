-- member
create table member(
	member_no number primary key,
	id varchar2(50) not null,
	password varchar2(50) not null,
	name varchar2(50) not null,
	address varchar2(50) not null,
	identity_no varchar2(50) not null,
	mail_address varchar2(50) not null,
	member_type varchar2(10) not null
)

drop table member
-- board
drop table board
create table board(
	board_no number primary key,
	board_type varchar2(50) not null,
	title varchar2(50) not null,
	writer varchar2(50) not null,
	content clob not null,
	member_no number not null
	constraint fk_member_no_4 references member(member_no)
)
select * from board
drop table board
-- statistics
create table statistics(
	age number,
	field varchar(50),
	applicate_count number not null,
	primary key(age,field)
)
select * from STATISTICS
drop table statistics

--recruit
create table recruit(
	recruit_no number primary key,
	title varchar2(50) not null,
	field varchar2(100) not null,
	location varchar2(100) not null,
	age varchar2(100) not null,
	start_date date not null,
	end_date date not null
	)
	
drop table recruit

drop table scheduler

create table scheduler(
member_no number primary key constraint fk_member_no_5 references member(member_no),
field varchar(50) not null,
location varchar(50) not null,
start_date date not null,
end_date date not null
)

drop table QnA_board

create table voluntary_service_applicate(
recruit_no number not null,
member_no number not null
constraint fk_recruit_no references recruit(recruit_no)
constraint fk_member_no_6 references member(member_no),
primary key(recruit_no,member_no)
)

select * from QnA_board;

create table QnA_board(
qna_no number primary key,
title varchar2(50) not null,
writer varchar2(50) not null,
content clob not null,
ref varchar2(50) not null,
restep varchar2(50) not null,
relevel varchar2(50) not null,
member_no number not null
constraint fk_member_no_3 references member(member_no)
)
--comment
drop table ymv_comment
create table ymv_comment(
	comment_no number primary key,
	writer varchar2(50) not null,
	content varchar2(1000) not null,
	time_posted date not null,
	board_no number not null
	constraint fk_board_no references board(board_no)
)
select * from ymv_comment
--picture
create table picture(
	picture_no number primary key,
	picture_name varchar2(50) not null,
	board_no number not null
)

-- voluntary_applicant_ok
create table voluntary_applicant_ok(
	recruit_no number not null,
	member_no number not null
	constraint fk_recruit_no_1 references recruit(recruit_no)
	constraint fk_member_no_1 references member(member_no),
	primary key(recruit_no,member_no)
)
select * from voluntary_applicant
-- voluntary_applicant 
create table voluntary_applicant(
	recruit_no number not null,
	member_no number not null
	constraint fk_recruit_no_2 references recruit(recruit_no)
	constraint fk_member_no_2 references member(member_no),
	primary key(recruit_no,member_no)
)

select * from board
create table board(
	board_no number primary key,
	board_type varchar2(50) not null,
	title varchar2(50) not null,
	writer varchar2(50) not null,
	content clob not null,
	member_no number not null
	constraint fk_member_no_4 references member(member_no)
)

create sequence ymv_seq;
 drop sequence ymv_seq;
select * from MEMBER;
select * from board;
insert into member values(1,'java','1234','임영학','판교','890716','qhackp@naver.com','normal');
insert into member values(2,'java1','1234','백지영','판교','960102','qorwldud@naver.com','normal');
insert into member values(3,'qwerty','1234','장지윤','수원','931004','quartzjiyun@naver.com','company');
insert into member values(4,'kosta','1234','박병준','서울','900227','byungjunpark@naver.com','company');
insert into BOARD(board_no,board_type,title,writer,content,member_no) values(ymv_seq.nextval,'review','테스트','임영학','가나다라','1');
insert into BOARD(board_no,board_type,title,writer,content,member_no) values(ymv_seq.nextval,'review','테스트','임영학','가나다라','1');
insert into statistics(age, field, applicate_count) values(20,'환경',1);
insert into statistics(age, field, applicate_count) values(30,'환경',2);
insert into RECRUIT(recruit_no, title, field, location, age, start_date, end_date) values(1,'봉사글?','환경','판교',20,to_date('2015-06-09 12:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-09 15:00','YYYY-MM-DD HH24:MI'));
insert into RECRUIT(recruit_no, title, field, location, age, start_date, end_date) values(2,'봉사글?','환경','판교',20,to_date('2015-06-09 12:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-09 15:00','YYYY-MM-DD HH24:MI'));
insert into SCHEDULER(member_no, field, location, start_date, end_date) values(1, '환경', '판교', to_date('2015-06-09 12:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-09 15:00','YYYY-MM-DD HH24:MI'));
insert into SCHEDULER(member_no, field, location, start_date, end_date) values(2, '환경', '판교', to_date('2015-06-09 12:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-09 15:00','YYYY-MM-DD HH24:MI'));
insert into VOLUNTARY_SERVICE_APPLICATE(recruit_no, member_no) values(1, 1);
insert into VOLUNTARY_SERVICE_APPLICATE(recruit_no, member_no) values(2, 2);
insert into QNA_BOARD(qna_no, title, writer, content, ref, restep, relevel, member_no) values(1, 'qna게시판?', '임영학', '내용어쩌구저쩌구1', 1, 0, 1, 1);
insert into QNA_BOARD(qna_no, title, writer, content, ref, restep, relevel, member_no) values(2, 'qna게시판?', '임영학', '내용어쩌구저쩌구2', 2, 0, 1, 1);
insert into YMV_COMMENT(comment_no, writer, content, time_posted, board_no) values(ymv_seq.nextval,'임영학','하고있습니다1',sysdate,1);
insert into YMV_COMMENT(comment_no, writer, content, time_posted, board_no) values(ymv_seq.nextval,'임영학','하고있습니다2',sysdate,2);
select * from PICTURE;

insert into PICTURE(picture_no, picture_name, board_no) values(ymv_seq.nextval,'봉사사진1',1);
insert into PICTURE(picture_no, picture_name, board_no) values(ymv_seq.nextval,'봉사사진2',2);
insert into VOLUNTARY_APPLICANT_OK(recruit_no, member_no) values(1,1);
insert into VOLUNTARY_APPLICANT_OK(recruit_no, member_no) values(1,2);
insert into VOLUNTARY_APPLICANT(recruit_no, member_no) values(1,1);
insert into VOLUNTARY_APPLICANT(recruit_no, member_no) values(1,2);





select * from board where board_no=1