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
	values(1,'我去宁波实习','日记',0,0,'感觉身体被掏空','2021-8-7 10:01:01'),
	(2,'我去武汉隔离','日记',0,0,'已经无法呼吸','2021-8-7 10:01:01'),
	(3,'我去网上冲浪','技术',0,0,'风好大，我好冷','2021-8-7 10:01:01'),
	(4,'我去楼顶吹风','新得',0,0,'<h1>风好大</h1><br><h2>我好冷</h2>','2021-8-7 10:01:01');

    
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
	(6,2,0,0,0,0,'哟，几天不见这么拉了','2021-8-7 10:01:01');

    
  CREATE TABLE `personalweb`.`likecount` (
  `id` INT NOT NULL DEFAULT 0,
  `likeCount` INT NULL DEFAULT 100,
  PRIMARY KEY (`id`));


    

    

    