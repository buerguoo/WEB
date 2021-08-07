#先做一个测试版本
drop schema if exists personalweb;
create schema personalweb;
use personalweb;
#下面是实体表

create table User(
	`user_id` int,	#用户id
    `username` varchar(16),#用户名
    `password` varchar(16),#密码
    `email` varchar(16),#邮箱
    `avatar` varchar(32),#头像路径
    `label` varchar(16),#标签
    `sex` int ,			#性别,0女,1男
    primary key(`user_id`));	
    
insert into User
	value(0,'admin','123456','123@163.com','./res/avatar/1.jpg','很细',0);
	
create table Article(
	`article_id` int,	#文章id
    `articleName` char(32),#文章名
    `label` char(32),#标签
    `viewCount` int,#浏览次数
    `commentCount` int,#评论次数
    `content` text,
	`posttime` TIMESTAMP,
    primary key(`article_id`));
insert into Article
	values(0,'我去宁波实习','日记',0,0,'我******，感觉身体被掏空！','2021-8-7 10:01:01'),
	(1,'我去武汉隔离','日记',0,0,'我******，感觉身体被灌满！','2021-8-7 10:01:01'),
	(2,'我去网上冲浪','日记',0,0,'我******，感觉身体变硬了！','2021-8-7 10:01:01');

    
#留言
create table Message(
	`message_id` int primary key,
    `userId` int ,
    `content` text,
    `posttime` timestamp);
insert into Message
	value(0,0,'这个是那个伞兵做的','2021-8-7 10:01:01');
#喜欢收藏    
create table likeCollect(
	`userId` int,
    `artId` int,
    `type` int, #01:喜欢，10:收藏,11:喜欢加收藏，00:其他
    primary key (`userId`,`artId`,`type`)
    );
insert into likeCollect
	value(0,0,3);
    
create table Comment(
    `comment_id` int primary key,
	`artId` int,
    `userId` int,
    `pid` int,
	`leaveId` int,
	`leavePid` int,
	`content` text,
    `posttime` timestamp);
  insert into comment   values
    (0,0,0,0,0,0,'哟，几天不见这么拉了','2021-8-7 10:01:01'),
    (1,0,0,0,0,0,'哟，几天不见这么拉了','2021-8-7 10:01:01'),
    (2,1,0,0,0,0,'哟，几天不见这么拉了','2021-8-7 10:01:01'),
    (3,2,0,0,0,0,'哟，几天不见这么拉了','2021-8-7 10:01:01'),
    (4,2,0,0,0,0,'哟，几天不见这么拉了','2021-8-7 10:01:01'),
    (5,2,0,0,0,0,'哟，几天不见这么拉了','2021-8-7 10:01:01'),
	(6,2,0,0,0,0,'哟，几天不见这么拉了','2021-8-7 10:01:01')

    
    
    #create table Album(
#	id_al int,
#   owner_al char(32),
#   createTime_al date);

#create table Photo(
#	id_ph int,
#   name_ph char(16),
#  	path_ph char(64),
# 	album_ph int);

    

    

    