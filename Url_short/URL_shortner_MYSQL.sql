CREATE DATABASE `ur` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `url_sh` (
  `url_id` varchar(20) NOT NULL,
  `url` longtext NOT NULL,
  `add_date` varchar(45) NOT NULL,
  PRIMARY KEY (`url_id`),
  UNIQUE KEY `url_id_UNIQUE` (`url_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
