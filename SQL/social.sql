create database social

use social

create table t_user(
userID int primary key,
username  varchar(20) not null unique, 
password varchar(20) not null,
birthday datetime,
background varchar(100),
u_picture varchar(100),
petname varchar(20) default('这个人很懒'),
college varchar(20),
email varchar(100),
phone varchar(20),
registerTime datetime
)
insert t_user values(100,'admin','123','2017-10-01',null,null,'狗子','社会大学','123@qq.com','888888','2016-10-01')

insert t_user values(101,'jack','123','2017-10-02',null,null,'杰克','社会大学','123@qq.com','222222','2016-10-02')
insert t_user values(102,'lily','123','2017-10-03',null,null,'莉莉','社会大学','123@qq.com','333333','2016-10-03')
insert t_user values(103,'michael','123','2017-10-04',null,null,'迈克尔','社会大学','123@qq.com','444444','2016-10-04')
insert t_user values(104,'sara','123','2017-10-05',null,null,'莎拉','社会大学','123@qq.com','555555','2017-05-05')
insert t_user values(105,'jack1','123','2017-10-02',null,null,'杰克','社会大学','123@qq.com','222222','2017-05-02')
insert t_user values(106,'lily1','123','2017-10-03',null,null,'莉莉','社会大学','123@qq.com','333333','2017-05-03')
insert t_user values(107,'michael1','123','2017-10-04',null,null,'迈克尔','社会大学','123@qq.com','444444','2017-05-04')
insert t_user values(108,'sara1','123','2017-10-05',null,null,'莎拉','社会大学','123@qq.com','555555','2017-05-05')
insert t_user values(109,'jack2','123','2017-10-02',null,null,'杰克','社会大学','123@qq.com','222222','2017-05-02')
insert t_user values(110,'lily2','123','2017-10-03',null,null,'莉莉','社会大学','123@qq.com','333333','2017-05-03')
insert t_user values(111,'michael2','123','2017-10-04',null,null,'迈克尔','社会大学','123@qq.com','444444','2017-05-04')
insert t_user values(112,'sara2','123','2017-10-05',null,null,'莎拉','社会大学','123@qq.com','555555','2017-05-05')

 --朋友列表
create table t_friends(		
userID int ,
friendID int ,
friends_add_time datetime,
primary key(userID,friendID),
constraint cs_frienduserid foreign key(userID)references t_user(userID),
constraint cs_friendfriendid foreign key(friendID)references t_user(userID)
)


select * from t_user  

select * from t_friends

select * from blog_list

select * from notice

insert blog_list values(100,1,'2017-05-015','article1 article1',null)
insert blog_list values(100,2,'2017-05-015','article2 article2',null)
insert blog_list values(100,3,'2017-05-015','article3 article3',null)
insert blog_list values(100,4,'2017-05-015','article4 article4',null)
insert blog_list values(100,5,'2017-05-015','article5 article5',null)
insert blog_list values(100,6,'2017-05-015','article6 article6',null)
insert blog_list values(100,7,'2017-05-015','article7 article7',null)
insert blog_list values(100,8,'2017-05-015','article8 article8',null)
insert blog_list values(100,9,'2017-05-015','article9 article9',null)
insert blog_list values(100,10,'2017-05-015','article10 article10',null)

--博文列表
create table blog_list(
userID int ,	--博文作者
blogID int  primary key(blogID),--博文ID
blog_time datetime ,--博文编写时间
content text,	--博文内容
blogcommentID int,	--博文评论ID
constraint cs_blog foreign key(userID) references t_user(userID),
)

--博文评论列表
create table blog_comment(
blogcommentID int primary key,
userID int,
blogID int,
comment_detail nvarchar(500),
comment_time date ,
constraint cs_bloguser foreign key(userID) references t_user(userID),
constraint cs_blogcomment foreign key(blogID) references blog_list(blogID)
)

create table act_list(
userID int ,
actID int ,
act_time date primary key(actID),
url varchar(100),
constraint cs_act foreign key(userID) references t_user(userID)
)
select *from act_list
create table act_comment(
actcommentID int primary key,
userID int,
actID int,
comment_detail nvarchar(500),
comment_time date,
constraint cs_actuser foreign key(userID) references t_user(userID),
constraint cs_accomm foreign key(actID) references act_list(actID)
)
--alter table blog_list drop constraint cs_bcomm

--alter table blog_comment add constraint cs_bcomm foreign key(blogcommentID) references blog_list(blogcommentID)

--通知表
create table notice(
noticeID int primary key, --通知ID
senderID int,	--发送人ID
recipientID int,	--接收人ID
noticeType int,	--通知类型
noticeContent nvarchar(500),	--通知内容
noticeState bit,	--通知已读情况
noticeTime datetime,	--通知时间
constraint cs_noticeuserid foreign key(senderID) references t_user(userID),
constraint cs_noticeuser foreign key(recipientID) references t_user(userID),
)


drop table t_user
drop table t_friends
drop table act_comment
drop table act_list

drop table blog_list
drop table blog_comment

drop table notice