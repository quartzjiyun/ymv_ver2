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
alter table member add(file_path varchar(200));
alter table member drop(file_path);
drop table member
delete from member
--JJH-time_posted,hit 추가
create table board(
	board_no number primary key,
	board_type varchar2(50) not null,
	title varchar2(50) not null,
	writer varchar2(50) not null,
	content clob not null,
	member_no number not null
	constraint fk_member_no_4 references member(member_no),
	time_posted date not null,
	hit number default 0
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

--JJH-recruit ver2 name(fk),time_posted,hit 추가
create table recruit(
	recruit_no number primary key,
	title varchar2(50) not null,
	field varchar2(100) not null,
	location varchar2(100) not null,
	age varchar2(100) not null,
	start_date date not null,
	end_date date not null,
	content clob not null,
	member_no number constraint fk_member_no_7 references member(member_no),
	time_posted date not null,
	hit number default 0
	)
	drop table member
drop sequence recruit_no_seq;
create sequence qna_no_seq;
create sequence qna_no_seq
	delete from member
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
	member_no number not null, 
	constraint fk_recruit_no foreign key(recruit_no) references recruit,
	constraint fk_member_no_6 foreign key(member_no) references member,
	motivate varchar(3000),
	constraint pk_voluntary_service_applicate primary key(recruit_no,member_no)
)
delete from voluntary_service_applicate
select * from voluntary_service_applicate;
--JJH-time_posted,hit 추가
create table QnA_board(
qna_no number primary key,
title varchar2(50) not null,
writer varchar2(50) not null,
content clob not null,
ref varchar2(50) not null,
restep varchar2(50) not null,
relevel varchar2(50) not null,
member_no number not null
constraint fk_member_no_3 references member(member_no),
time_posted date not null,
hit number default 0
)
delete from QNA_BOARD
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
	file_path varchar(200) not null
)
drop table picture 
-- voluntary_applicant_ok
create table voluntary_applicant_ok(
	recruit_no number not null,
	member_no number not null
	constraint fk_recruit_no_1 references recruit(recruit_no)
	constraint fk_member_no_1 references member(member_no),
	primary key(recruit_no,member_no)
)
select * from voluntary_applicant_ok
-- voluntary_applicant 
create table voluntary_applicant(
	recruit_no number not null,
	member_no number not null constraint fk_recruit_no_2 references recruit(recruit_no)	constraint fk_member_no_2 references member(member_no),
	motivate varchar(3000),
	primary key(recruit_no,member_no)
)
drop table voluntary_applicant_ok
select * from voluntary_applicant
--JJH table 수정하고 insert중 해당 부분 재수정
create sequence ymv_seq;
 drop sequence ymv_seq;
select * from MEMBER;
select * from board;
insert into member values(1,'java','1234','임영학','판교','890716','qhackp@naver.com','normal');
insert into member values(2,'java1','1234','백지영','판교','960102','qorwldud@naver.com','normal');
insert into member values(3,'qwerty','1234','장지윤','수원','931004','quartzjiyun@naver.com','company');
insert into member values(4,'kosta','1234','박병준','서울','900227','byungjunpark@naver.com','company');
insert into BOARD(board_no,board_type,title,writer,content,member_no,time_posted) 
values(ymv_seq.nextval,'notice','테스트','임영학','가나다라','1',sysdate,0);
insert into BOARD(board_no,board_type,title,writer,content,member_no,time_posted) values(ymv_seq.nextval,'review','테스트','임영학','가나다라','1',sysdate);
insert into statistics(age, field, applicate_count) values(20,'환경',1);
insert into statistics(age, field, applicate_count) values(30,'환경',2);
insert into RECRUIT(recruit_no, title, field, location, age, start_date, end_date,content,member_no,time_posted) values(1,'봉사글?','환경','판교',20,to_date('2015-06-09 12:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-09 15:00','YYYY-MM-DD HH24:MI'),'내용입니다',1,sysdate);
insert into RECRUIT(recruit_no, title, field, location, age, start_date, end_date,content,member_no,time_posted) values(2,'봉사글?','환경','판교',20,to_date('2015-06-09 12:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-09 15:00','YYYY-MM-DD HH24:MI'),'내용씁니다',2,sysdate);
insert into SCHEDULER(member_no, field, location, start_date, end_date) values(1, '환경', '판교', to_date('2015-06-09 12:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-09 15:00','YYYY-MM-DD HH24:MI'));
insert into SCHEDULER(member_no, field, location, start_date, end_date) values(2, '환경', '판교', to_date('2015-06-09 12:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-09 15:00','YYYY-MM-DD HH24:MI'));
insert into VOLUNTARY_SERVICE_APPLICATE(recruit_no, member_no) values(1, 1);
insert into VOLUNTARY_SERVICE_APPLICATE(recruit_no, member_no) values(2, 2);
insert into QNA_BOARD(qna_no, title, writer, content, ref, restep, relevel, member_no,time_posted) values(1, 'qna게시판?', '임영학', '내용어쩌구저쩌구1', 1, 0, 1, 1,sysdate);
insert into QNA_BOARD(qna_no, title, writer, content, ref, restep, relevel, member_no,time_posted) values(2, 'qna게시판?', '임영학', '내용어쩌구저쩌구2', 2, 0, 1, 1,sysdate);
insert into YMV_COMMENT(comment_no, writer, content, time_posted, board_no) values(ymv_seq.nextval,'임영학','하고있습니다1',sysdate,1);
insert into YMV_COMMENT(comment_no, writer, content, time_posted, board_no) values(ymv_seq.nextval,'임영학','하고있습니다2',sysdate,2);
select * from PICTURE;
--여기까지했음
insert into PICTURE(picture_no, file_name) values(144,'[144]20140819081945_496821_478_269.png');
insert into PICTURE(picture_no, file_name) values(ymv_seq.nextval,'봉사사진2',2);
insert into VOLUNTARY_APPLICANT_OK(recruit_no, member_no) values(1,1);
insert into VOLUNTARY_APPLICANT_OK(recruit_no, member_no) values(1,2);
insert into VOLUNTARY_APPLICANT(recruit_no, member_no) values(1,1);
insert into VOLUNTARY_APPLICANT(recruit_no, member_no) values(1,2);

--지영이가 한거 
--field
drop table field
create table field(
   field varchar2(100) not null
)

delete from field
select * from field
insert into field values('노인');
insert into field values('아동');
insert into field values('장애');
insert into field values('동물');
insert into field values('환경');


--location
drop table location
create table location(
   location varchar2(100) not null
)


delete from location
select * from location
insert into location values('강원도');
insert into location values('경기도');
insert into location values('충청도');
insert into location values('경상도');
insert into location values('전라도');
insert into location values('제주도');
insert into location values('서울');
insert into location values('부산');




select * from board where board_no=1

select * from PICTURE

select boardNo, title, writer, content, memberNo, timePosted, hit from(select boardNo, title, writer, content, memberNo, timePosted, hit, CEIL(rownum/5) AS page from(select board_no as boardNo, title, writer, content, member_no as memberNo, time_posted as timePosted, hit from board where board_type='review' order by boardNo desc)) where page=1
select boardNo, title, writer, content, memberNo, timePosted, hit from(select board_no as boardNo, title, writer, content, member_no as memberNo, time_posted as timePosted, hit, CEIL(rownum/5) AS page from board where board_type='notice' order by board_no desc) where page=#{value}

select boardNo, title, writer, content, memberNo, timePosted, hit from(select boardNo, title, writer, content, memberNo, timePosted, hit, CEIL(rownum/5) AS page from(select board_no as boardNo, title, writer, content, member_no as memberNo, time_posted as timePosted, hit from board where board_type='notice' order by boardNo desc)) where page=1
