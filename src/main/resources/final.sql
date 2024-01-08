use finalassignment;

drop table student;
create table student
(
    id   bigint primary key,
    name char(64) not null,
    sex  int      not null,
    age  int      not null,
    dep  int      not null,
    constraint case1 foreign key (dep) references department (id) on delete cascade
);

INSERT INTO student (id, name, sex, age, dep)
VALUES (20211160001, '张磊', 1, 20, 1),
       (20211160002, '李莉', 0, 21, 2),
       (20211160003, '王刚', 1, 22, 3),
       (20211160004, '赵雪', 0, 20, 4),
       (20211160005, '孙涛', 1, 21, 5),
       (20211160006, '周燕', 0, 23, 6),
       (20211160007, '吴昊', 1, 20, 7),
       (20211160008, '郑璇', 0, 22, 8),
       (20211160009, '陈鑫', 1, 23, 9),
       (20211160010, '刘璐', 0, 21, 10),
       (20211120001, '张天', 1, 22, 1),
       (20211120002, '李晶', 0, 23, 2),
       (20211120003, '王宇', 1, 24, 3),
       (20211120004, '赵月', 0, 23, 4),
       (20211120005, '孙雷', 1, 24, 5),
       (20211120006, '周静', 0, 25, 6),
       (20211120007, '吴磊', 1, 23, 7),
       (20211120008, '郑瑾', 0, 24, 8),
       (20211120009, '陈昊', 1, 25, 9),
       (20211120011, '刘阳', 0, 24, 5),
       (20211120010, '张晓', 1, 23, 6),
       (20211120140, '刘鑫', 0, 25, 7);


create table department
(
    id   int primary key,
    name char(64) not null
);

INSERT INTO department (id, name)
VALUES (1, '信息学院'),
       (2, '软件学院'),
       (3, '法学院'),
       (4, '经济学院'),
       (5, '管理学院'),
       (6, '文学学院'),
       (7, '艺术学院'),
       (8, '理工学院'),
       (9, '医学院'),
       (10, '农学院');


create table course
(
    id      int primary key auto_increment,
    name    char(64) not null,
    teacher char(32) not null,
    credit  float    not null
);

INSERT INTO course (name, teacher, credit)
VALUES ('计算机网络', '张三', 3.5),
       ('操作系统', '李四', 4.0),
       ('数据结构', '王五', 4.5),
       ('数据库原理', '赵六', 3.0),
       ('编译原理', '陈七', 4.5),
       ('离散数学', '孙八', 3.5),
       ('软件工程', '周九', 4.0),
       ('计算机组成原理', '吴十', 4.5),
       ('网络协议工程', '郑十一', 3.0),
       ('信息安全导论', '钱十二', 4.5),
       ('计算机图形学', '杨十三', 3.5),
       ('算法分析', '黄十四', 4.0),
       ('软件测试技术', '钟十五', 4.5),
       ('数字信号处理', '刘十六', 3.0),
       ('通信原理', '王十七', 4.5),
       ('信号与系统', '陈十八', 3.5),
       ('电子电路设计', '孙十九', 4.0),
       ('概率论与数理统计', '郑二十', 4.5);

drop table sc;
create table sc
(
    sid bigint not null,
    cid int    not null,
    pts float  not null default 60.0,
    primary key (sid,cid),
    constraint sc1 foreign key (sid) references student (id) on delete cascade,
    constraint sc2 foreign key (cid) references course (id) on delete cascade
);

INSERT INTO sc (sid, cid, pts)
VALUES (20211120001, 1, 85.5),
       (20211160001, 2, 78.0),
       (20211160001, 3, 92.5),
       (20211160001, 4, 68.5),
       (20211160001, 5, 88.5),
       (20211160002, 6, 76.5),
       (20211160002, 7, 69.5),
       (20211160002, 8, 94.5),
       (20211160003, 9, 88.5),
       (20211160003, 10, 74.5),
       (20211160003, 11, 89.5),
       (20211160004, 19, 89.5);

create table userinfo(
    uid char(32) primary key ,
    password char(32) not null
);


insert into userinfo
values ('admin','123456');


