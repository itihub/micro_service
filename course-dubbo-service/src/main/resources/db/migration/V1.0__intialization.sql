
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


# Config
# ------------------------------------------------------------
INSERT INTO `pe_course` (`title`, `description`)
VALUES
	('语文', '中华文化'),
	('数学', '探索数学的奥妙'),
	('体育', '强身健体');

