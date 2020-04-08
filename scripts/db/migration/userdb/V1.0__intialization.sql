

# Create Database
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS db_user DEFAULT CHARACTER SET = utf8mb4;

# Dump of table pe_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pe_user`;

CREATE TABLE `pe_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '用户密码',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IX_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


# Dump of table pe_teacher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pe_teacher`;

CREATE TABLE `pe_teacher` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `user_id` int(11) NOT NULL COMMENT '用户身份标识',
  `intro` varchar(512) DEFAULT NULL COMMENT '介绍',
  `stars` int(11) DEFAULT NULL COMMENT '星星数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IX_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';


# Config
# ------------------------------------------------------------
INSERT INTO `pe_user` (`username`, `password`, `real_name`, `mobile`, `email`)
VALUES
	('user', 'e10adc3949ba59abbe56e057f20f883e', 'user', '13901001000','user@example.com'),
	('zhangsan', 'e10adc3949ba59abbe56e057f20f883e', 'zhangsan', '13901001000','sanzhang@example.com'),
	('lisi', 'e10adc3949ba59abbe56e057f20f883e', 'lisi', '13901001000','sili@example.com');

INSERT INTO `pe_teacher` (`user_id`, `intro`, `stars`)
VALUES
	((SELECT id FROM pe_user WHERE username = 'zhangsan'), '语文老师', 100),
	((SELECT id FROM pe_user WHERE username = 'lisi'), '体育老师', 543);
