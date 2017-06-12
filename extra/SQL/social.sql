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

--博文列表
create table blog_list(
userID int ,	--博文作者
blogID int  primary key(blogID),--博文ID
blog_time datetime ,--博文编写时间
content text,	--博文内容
blogcommentID int,	--博文评论ID
constraint cs_blog foreign key(userID) references t_user(userID),
)
delete from blog_list where userID=101

--博文评论列表
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

delete from blog_comment where blogID=17

update notice set noticeState=0 where noticeID=2
select * from notice

create table board(
messageID int primary key,--留言信息ID
userID int,	--被留言人
speakID int,			--留言人ID
message_detail varchar(500),--留言内容
message_time datetime,		--留言时间
constraint cs_board foreign key(userID) references t_user(userID),
)
select * from board
delete from board where userID=100

create table messageShow(
messageID int primary key,--留言信息ID
u_picture varchar(100),	--留言人头像
username  varchar(20) not null unique, 
speakID int,			--留言人ID
message_detail varchar(500),--留言内容
message_time datetime,		--留言时间
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
update blog_list set content='三十岁的女人|_z!5)作者：巴尔扎克
　　《三十岁的女人》实际上是不同时间发表的六个短篇的组合。第一部分《最初的失误》，原题名《约会》，写于一八二九年末至一八三〇年初。一八三〇年二月十一日，《侧影》周刊登载了其中的片断：《都兰的一瞥》，同年十一月《讽刺》周刊又发表了另一片断：《拿破仑的最后一次检阅》。《约会》的全文，于一八三一年九月十五日至十月一日在《两世界》杂志上发表。一八三一年一月二十三日和三十日，《巴黎杂志》分两次刊登了短篇小说《两次相遇》，分别题名为《蛊惑》和《巴黎船长》，后合并为本篇的第五部分。一八三一年三月二十七日，该杂志又刊登了短篇小说《上帝的旨意》，后成为本篇的第四部分。第三部分《时年三十岁》，原题名《三十岁的女人》，于一八三二年四月二十九日在《巴黎杂志》上发表。

　　一八三二年五月，玛门－德洛奈书屋再版《私人生活场景》时，除收入了《约会》、《三十岁的女人》、《两次相遇》、《上帝的旨意》等篇外，还增加了题为《赎罪》的另一个短篇，后成为本篇的第六部分。在《两次相遇》中，除原有的两个段落（《蛊惑》和《巴黎船长》）外，又补充了描写爱伦娜之死的《教训》。从这一版开始，巴尔扎克已经在酝酿将这几个短篇合成一部长篇，并以玛门－德洛奈的名义，在出版说明中提出此项建议，甚至已为这部长篇设想了一个标题：《女性生活剪影》。

　　一八三四年，贝歇夫人书屋第二次重版《私人生活场景》。作者在《同一个故事》的标题下，将前述五个短篇作了若干修改补充后归在一起，并在《最初的失误》和《三十岁的女人》之间，插入了作为第二部分的《埋藏心底的痛苦》。

　　一八三七年威尔代书屋再版《私人生活场景》时，作者对《同一个故事》又作了若干修改补充，力图使六个部分更加衔接和统一。

　　一八四二年十一月，本篇收入菲讷版《人间喜剧》十六卷本第三卷，作者统一了六个故事的主人公姓名，总标题改为《三十岁的女人》，第一部分《约会》改为《最初的失误》，原题为《三十岁的女人》的第三部分改为《时年三十岁》，第六部分《赎罪》改为《一个有罪的母亲的晚年》。各个短篇原有的段落标题一律取消。

　　将描写女性不同生活阶段的六个短篇衔接在一起，用来表现作为婚姻制度牺牲品的女性的一生，这种别出心裁的做法，当然会在细节上留下不少漏洞，人物形象前后也颇不统一，但作者在一八三四年版序言中说明：“可以说贯穿在组成《同一个故事》的六个场景里的人物，不是一个形象，而是一个思想，这个思想的装束越是不同，越能说明作者的意图。”

　　巴尔扎克一直认为，家庭是社会的基础，而以财产、门第为杠杆的婚姻制度恰是破坏家庭、造成种种私生活悲剧的根源，其中受害最深的便是女子，作者通过女主人公朱丽之口，对这种婚姻制度提出了强烈的控诉：“婚姻不过是合法的卖淫！”

　　一个天真无邪、活泼愉快的少女，一旦套上婚姻的枷锁，委身于一个对她毫不理解、和她毫不相称的男人，从此便陷于不幸的深渊。她们受社会礼俗的约束，要么含悲忍苦地充当奴隶，时刻面临被遗弃的危险；要么因在婚外寻求幸福而遭受社会乃至子女的谴责。她们的短暂幸福，往往造成家庭、子女的极大不幸和自己终生的痛苦。' where blogID=1

select u_picture from t_user where userID=100
select username,u_picture,friends_add_time from t_user a ,t_friends b where b.userID = 100 and a.userID = b.friendID

select messageID u_picture,username,speakID,message_detail,message_time from t_user a,board b where  b.userID=100 and speakID=a.userID
select messageID,u_picture,username,speakID,message_detail,message_time from t_user a,board b where  b.userID=100 and speakID=a.userID
select * from board


select COUNT(*) from t_friends where userID=100

select content from blog_list where blogID=18

delete from blog_list where blogID=19