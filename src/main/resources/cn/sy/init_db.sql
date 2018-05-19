CREATE DATABASE `ds` /*!40100 COLLATE 'utf8_general_ci' */;
CREATE DATABASE `ds_0` /*!40100 COLLATE 'utf8_general_ci' */;
CREATE DATABASE `ds_1` /*!40100 COLLATE 'utf8_general_ci' */;


drop table `s_system_log`;
CREATE TABLE `s_system_log` (
	`ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`ACCOUNT` VARCHAR(100) NULL DEFAULT NULL,
	`OPERATION` VARCHAR(255) NOT NULL,
	`OPERATION_DETAIL` TEXT NULL,
	`OPERATION_TIME` DATETIME NULL DEFAULT NULL,
	`TOKEN` VARCHAR(40) NULL DEFAULT NULL,
	`IP_ADDRESS` VARCHAR(40) NULL DEFAULT NULL,
	PRIMARY KEY (`ID`)
)
;

-- insert into s_system_log(OPERATION) values('/test');
-- select * from s_system_log;

create table t_user (
  user_id int not null,
  user_name varchar(255) not null,
  primary key (user_id)
);

create table t_order_0 (
  order_id int not null,
  user_id  int not null,
  user_name varchar(255),
  primary key (order_id)
);

create table t_order_1 (
  order_id int not null,
  user_id  int not null,
  user_name varchar(255),
  primary key (order_id)
);

