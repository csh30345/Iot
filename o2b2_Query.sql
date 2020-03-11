drop database o2b2;

create database o2b2;

show databases;

use o2b2;

-- 회원정보(profile)테이블------------------------------------------------------
create table profile(
	SerialNum int(30) primary key,
    phoneNum varchar(30) not null,
    password1 varchar(30) not null
);
desc profile;

-- 테이블 속성 변경 
ALTER table profile modify phonenum varchar(30);
ALTER TABLE profile modify serialnum int (30);

-- 데이터 삽입
insert into profile(serialnum, phonenum, password1) values(1,'01012345671','asd1231');
insert into profile(serialnum, phonenum, password1) values(2,'01012345672','asd1232');
insert into profile(serialnum, phonenum, password1) values(3,'01012345673','asd1233');

-- order by xxx asc (오름차순 정렬)
select * from profile order by serialnum asc;
-- 시리얼 번호로 원하는 값 찾기
select * from profile where serialnum=3;
-- 데이터 삭제
delete from profile  where password1 = 'asd4567';

alter table profile auto_increment=1;
set @count =0;
update profile set serialnum = @count:=count+1; 

drop table realstudytime;

-- 실제 공부시간(RealStudyTime) 테이블-------------------------------------------------------
create table RealStudyTime(
	SerialNum int(30) not null,
    foreign key(SerialNum) references profile(SerialNum) on delete cascade on update cascade,
    studytime int(30) not null,
    date date not null,
    subject int(10) not null
);
desc RealStudyTime;

-- 테이블속성변경 
ALTER table RealStudyTime modify SerialNum int not null;
alter table  realstudytime add constraint profile foreign key (Serialnum) references profile(Serialnum) on delete cascade;

-- 실제 학습시간 데이터 넣기( serialNum 칼럼은 profile 테이블에 존재하는 값을 넣어야 한다.
insert into RealStudyTime(serialNum, studytime, date, subject) values(1,1,'2020-01-02',3);
insert into RealStudyTime(serialNum, studytime, date, subject) values(2,2,'2020-01-02',2);
insert into RealStudyTime(serialNum, studytime, date, subject) values(3,3,'2020-01-02',1);

select * from realstudytime order by serialnum asc;

delete from realstudytime where studytime=3;

drop table ScheduleStudyTime;

-- 스케줄 공부시간(ScheduleStudyTime) 테이블-------------------------------------------------
create table ScheduleStudyTime(
	SerialNum int(30) not null,
    foreign key(SerialNum) references profile(SerialNum) on delete cascade on update cascade,
    studytime int(30) not null,
    date date not null,
    subject int(10) not null
);
desc ScheduleStudyTime;

alter table schedulestudytime add constraint profile foreign key (serialnum) references profile(serialnum) on delete cascade;

-- 스케쥴 공부시간 데이터 삽입
insert into schedulestudytime(serialnum, studytime, date, subject) values(1,3,'2020-01-02',1);
insert into schedulestudytime(serialnum, studytime, date, subject) values(2,2,'2020-01-02',2);
insert into schedulestudytime(serialnum, studytime, date, subject) values(3,1,'2020-01-02',3);

select *from scheduleStudytime order by serialnum asc;

















