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