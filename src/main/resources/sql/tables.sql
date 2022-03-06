DROP TABLE IF EXISTS `t_user_0`;
CREATE TABLE `t_user_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(32) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '倪名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
DROP TABLE IF EXISTS `t_user_1`;
CREATE TABLE `t_user_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(32) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '倪名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `t_user_2`;
CREATE TABLE `t_user_2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(32) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '倪名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `t_user_3`;
CREATE TABLE `t_user_3` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(32) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '倪名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `t_user_4`;
CREATE TABLE `t_user_4` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(32) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '倪名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `price` decimal(10, 2) NULL,
  `sign_time` varchar(20) NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `price` decimal(10, 2) NULL,
  `sign_time` varchar(20) NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_order_2`;
CREATE TABLE `t_order_2`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `price` decimal(10, 2) NULL,
  `sign_time` varchar(20) NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_order_3`;
CREATE TABLE `t_order_3`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `price` decimal(10, 2) NULL,
  `sign_time` varchar(20) NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_order_4`;
CREATE TABLE `t_order_4`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `price` decimal(10, 2) NULL,
  `sign_time` varchar(20) NULL,
  PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `t_order_item_0`;
CREATE TABLE `t_order_item_0`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `order_id` bigint(20) NULL,
  `item_name` varchar(100) not null,
  `price` decimal(10, 2) NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_order_item_1`;
CREATE TABLE `t_order_item_1`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `order_id` bigint(20) NULL,
  `item_name` varchar(100) not null,
  `price` decimal(10, 2) NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_order_item_2`;
CREATE TABLE `t_order_item_2`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `order_id` bigint(20) NULL,
  `item_name` varchar(100) not null,
  `price` decimal(10, 2) NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_order_item_3`;
CREATE TABLE `t_order_item_3`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `order_id` bigint(20) NULL,
  `item_name` varchar(100) not null,
  `price` decimal(10, 2) NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_order_item_4`;
CREATE TABLE `t_order_item_4`  (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NULL,
  `order_id` bigint(20) NULL,
  `item_name` varchar(100) not null,
  `price` decimal(10, 2) NULL,
  PRIMARY KEY (`id`)
);