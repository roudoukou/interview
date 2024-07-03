-- 创建数据库
CREATE DATABASE IF NOT EXISTS `spring-cache`
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

-- 使用数据库
USE `spring-cache`;

-- 创建用户表
CREATE TABLE `User` (
                        `id` INT NOT NULL,
                        `name` VARCHAR(255) NOT NULL,
                        `sex` VARCHAR(255) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 插入模拟数据
INSERT INTO `User` (`id`, `name`, `sex`) VALUES (1, 'zhangsan', '男');
INSERT INTO `User` (`id`, `name`, `sex`) VALUES (2, 'lisi', '男');
INSERT INTO `User` (`id`, `name`, `sex`) VALUES (3, 'wangwu', '男');
INSERT INTO `User` (`id`, `name`, `sex`) VALUES (4, 'zhaoliu', '女');
INSERT INTO `User` (`id`, `name`, `sex`) VALUES (5, 'sunqi', '女');
