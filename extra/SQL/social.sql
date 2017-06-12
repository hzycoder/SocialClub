create database social

use social

create table t_user(
userID int primary key,
username  varchar(20) not null unique, 
password varchar(20) not null,
birthday datetime,
background varchar(100),
u_picture varchar(100),
petname varchar(20) default('����˺���'),
college varchar(20),
email varchar(100),
phone varchar(20),
registerTime datetime
)

insert t_user values(100,'admin','123','2017-10-01',null,null,'����','����ѧ','123@qq.com','888888','2016-10-01')

insert t_user values(101,'jack','123','2017-10-02',null,null,'�ܿ�','����ѧ','123@qq.com','222222','2016-10-02')
insert t_user values(102,'lily','123','2017-10-03',null,null,'����','����ѧ','123@qq.com','333333','2016-10-03')
insert t_user values(103,'michael','123','2017-10-04',null,null,'���˶�','����ѧ','123@qq.com','444444','2016-10-04')
insert t_user values(104,'sara','123','2017-10-05',null,null,'ɯ��','����ѧ','123@qq.com','555555','2017-05-05')
insert t_user values(105,'jack1','123','2017-10-02',null,null,'�ܿ�','����ѧ','123@qq.com','222222','2017-05-02')
insert t_user values(106,'lily1','123','2017-10-03',null,null,'����','����ѧ','123@qq.com','333333','2017-05-03')
insert t_user values(107,'michael1','123','2017-10-04',null,null,'���˶�','����ѧ','123@qq.com','444444','2017-05-04')
insert t_user values(108,'sara1','123','2017-10-05',null,null,'ɯ��','����ѧ','123@qq.com','555555','2017-05-05')
insert t_user values(109,'jack2','123','2017-10-02',null,null,'�ܿ�','����ѧ','123@qq.com','222222','2017-05-02')
insert t_user values(110,'lily2','123','2017-10-03',null,null,'����','����ѧ','123@qq.com','333333','2017-05-03')
insert t_user values(111,'michael2','123','2017-10-04',null,null,'���˶�','����ѧ','123@qq.com','444444','2017-05-04')
insert t_user values(112,'sara2','123','2017-10-05',null,null,'ɯ��','����ѧ','123@qq.com','555555','2017-05-05')


 --�����б�
create table t_friends(		
userID int ,
friendID int ,
friends_add_time datetime,
primary key(userID,friendID),
constraint cs_frienduserid foreign key(userID)references t_user(userID),
constraint cs_friendfriendid foreign key(friendID)references t_user(userID)
)


select u_picture from t_user where userID=102

select * from t_user
select * from t_friends

select * from t_friends where userID=101
select * from t_friends where friendID=101
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



insert blog_list values(101,15,'2017-05-015','jackarticle1 article1',null)
insert blog_list values(101,16,'2017-05-015','jackrticle2 article2',null)
insert blog_list values(101,13,'2017-05-015','jackarticle3 article3',null)
insert blog_list values(101,14,'2017-05-015','jackarticle4 article4',null)

--�����б�
create table blog_list(
userID int ,	--��������
blogID int  primary key(blogID),--����ID
blog_time datetime ,--���ı�дʱ��
content text,	--��������
blogcommentID int,	--��������ID
constraint cs_blog foreign key(userID) references t_user(userID),
)
delete from blog_list where userID=101

--���������б�
create table blog_comment(
blogcommentID int primary key,
userID int,
blogID int,
comment_detail nvarchar(500),
comment_time datetime ,
constraint cs_bloguser foreign key(userID) references t_user(userID),
constraint cs_blogcomment foreign key(blogID) references blog_list(blogID)
)
delete from blog_comment where blogID=17
select * from blog_comment


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

--֪ͨ��
create table notice(
noticeID int primary key, --֪ͨID
senderID int,	--������ID
recipientID int,	--������ID
noticeType int,	--֪ͨ����
noticeContent nvarchar(500),	--֪ͨ����
noticeState bit,	--֪ͨ�Ѷ����
noticeTime datetime,	--֪ͨʱ��
constraint cs_noticeuserid foreign key(senderID) references t_user(userID),
constraint cs_noticeuser foreign key(recipientID) references t_user(userID),
)

delete from blog_comment where blogID=17

update notice set noticeState=0 where noticeID=2
select * from notice

create table board(
messageID int primary key,--������ϢID
userID int,	--��������
speakID int,			--������ID
message_detail varchar(500),--��������
message_time datetime,		--����ʱ��
constraint cs_board foreign key(userID) references t_user(userID),
)
select * from board
delete from board where userID=100

create table messageShow(
messageID int primary key,--������ϢID
u_picture varchar(100),	--������ͷ��
username  varchar(20) not null unique, 
speakID int,			--������ID
message_detail varchar(500),--��������
message_time datetime,		--����ʱ��
constraint cs_message foreign key(speakID) references t_user(userID),
)
select * from messageShow 




drop table t_user
drop table t_friends
drop table act_comment
drop table act_list

drop table blog_list
drop table blog_comment
drop table board
drop table notice
drop table messageShow

select * from  blog_list
update blog_list set content='��ʮ���Ů��|_z!5)���ߣ��Ͷ�����
��������ʮ���Ů�ˡ�ʵ�����ǲ�ͬʱ�䷢���������ƪ����ϡ���һ���֡������ʧ�󡷣�ԭ������Լ�ᡷ��д��һ�˶�����ĩ��һ�����������һ�����������ʮһ�գ�����Ӱ���ܿ����������е�Ƭ�ϣ���������һƳ����ͬ��ʮһ�¡���̡��ܿ��ַ�������һƬ�ϣ��������ص����һ�μ��ġ�����Լ�ᡷ��ȫ�ģ���һ����һ�����ʮ������ʮ��һ���ڡ������硷��־�Ϸ���һ����һ��һ�¶�ʮ���պ���ʮ�գ���������־�������ο����˶�ƪС˵���������������ֱ�����Ϊ���ƻ󡷺͡����贬��������ϲ�Ϊ��ƪ�ĵ��岿�֡�һ����һ�����¶�ʮ���գ�����־�ֿ����˶�ƪС˵���ϵ۵�ּ�⡷�����Ϊ��ƪ�ĵ��Ĳ��֡��������֡�ʱ����ʮ�꡷��ԭ��������ʮ���Ů�ˡ�����һ�����������¶�ʮ�����ڡ�������־���Ϸ���

����һ�����������£����ţ������������ٰ桶˽���������ʱ���������ˡ�Լ�ᡷ������ʮ���Ů�ˡ��������������������ϵ۵�ּ�⡷��ƪ�⣬����������Ϊ���������һ����ƪ�����Ϊ��ƪ�ĵ������֡��ڡ������������У���ԭ�е��������䣨���ƻ󡷺͡����贬�������⣬�ֲ�������д������֮���ġ���ѵ��������һ�濪ʼ���Ͷ������Ѿ��������⼸����ƪ�ϳ�һ����ƪ���������ţ������ε����壬�ڳ���˵�����������飬������Ϊ�ⲿ��ƪ������һ�����⣺��Ů�������Ӱ����

����һ�������꣬��Ъ�������ݵڶ����ذ桶˽����������������ڡ�ͬһ�����¡��ı����£���ǰ�������ƪ���������޸Ĳ�������һ�𣬲��ڡ������ʧ�󡷺͡���ʮ���Ů�ˡ�֮�䣬��������Ϊ�ڶ����ֵġ�����ĵ׵�ʹ�ࡷ��

����һ�������������������ٰ桶˽���������ʱ�����߶ԡ�ͬһ�����¡������������޸Ĳ��䣬��ͼʹ�������ָ����νӺ�ͳһ��

����һ���Ķ���ʮһ�£���ƪ�����ګ�桶�˼�ϲ�硷ʮ��������������ͳһ���������µ����˹��������ܱ����Ϊ����ʮ���Ů�ˡ�����һ���֡�Լ�ᡷ��Ϊ�������ʧ�󡷣�ԭ��Ϊ����ʮ���Ů�ˡ��ĵ������ָ�Ϊ��ʱ����ʮ�꡷���������֡������Ϊ��һ�������ĸ�׵����꡷��������ƪԭ�еĶ������һ��ȡ����

��������дŮ�Բ�ͬ����׶ε�������ƪ�ν���һ������������Ϊ�����ƶ�����Ʒ��Ů�Ե�һ�������ֱ���Ĳõ���������Ȼ����ϸ�������²���©������������ǰ��Ҳ�Ĳ�ͳһ����������һ���������������˵����������˵�ᴩ����ɡ�ͬһ�����¡���������������������һ�����󣬶���һ��˼�룬���˼���װ��Խ�ǲ�ͬ��Խ��˵�����ߵ���ͼ����

�����Ͷ�����һֱ��Ϊ����ͥ�����Ļ��������ԲƲ����ŵ�Ϊ�ܸ˵Ļ����ƶ�ǡ���ƻ���ͥ���������˽�����ĸ�Դ�������ܺ�����ı���Ů�ӣ�����ͨ��Ů���˹�����֮�ڣ������ֻ����ƶ������ǿ�ҵĿ��ߣ������������ǺϷ�����������

����һ��������а������������Ů��һ�����ϻ����ļ�����ί����һ������������⡢����������Ƶ����ˣ��Ӵ˱����ڲ��ҵ���Ԩ��������������׵�Լ����Ҫô�����̿�س䵱ū����ʱ�����ٱ�������Σ�գ�Ҫô���ڻ���Ѱ���Ҹ����������������Ů��Ǵ�����ǵĶ����Ҹ���������ɼ�ͥ����Ů�ļ����Һ��Լ�������ʹ�ࡣ' where blogID=1

select u_picture from t_user where userID=100
select username,u_picture,friends_add_time from t_user a ,t_friends b where b.userID = 100 and a.userID = b.friendID

select messageID u_picture,username,speakID,message_detail,message_time from t_user a,board b where  b.userID=100 and speakID=a.userID
select messageID,u_picture,username,speakID,message_detail,message_time from t_user a,board b where  b.userID=100 and speakID=a.userID
select * from board


select COUNT(*) from t_friends where userID=100

select content from blog_list where blogID=18

delete from blog_list where blogID=19