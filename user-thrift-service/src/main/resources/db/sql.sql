
-- 创建数据库
CREATE DATABASE db_user;

-- 用户表
CREATE TABLE `pe_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(255) NOT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;