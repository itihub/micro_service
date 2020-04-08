
# Create Database
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS db_course DEFAULT CHARACTER SET = utf8mb4;


# Dump of table pe_course
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pe_course`;

CREATE TABLE `pe_course` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `title` varchar(32) NOT NULL COMMENT '课程标题',
  `description` varchar(255) NOT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

# Dump of table pr_user_course
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pr_user_course`;

CREATE TABLE `pr_user_course` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `user_id` int(10) NOT NULL COMMENT '用户唯一标识',
  `course_id` int(10) NOT NULL COMMENT '课程唯一标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IX_UNIQUE_KEY` (`user_id`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户课程关系表';


# Config
# ------------------------------------------------------------
INSERT INTO `pe_course` (`title`, `description`)
VALUES
	('语文', '中华文化'),
	('数学', '探索数学的奥妙'),
	('体育', '强身健体');

INSERT INTO `pr_user_course` (`user_id`, `course_id`)
VALUES
	(2, 2),
	(3, 1),
	(2, 3);
