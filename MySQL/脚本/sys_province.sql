# Host: sh-cdb-p41j1s69.sql.tencentcdb.com:63129  (Version: 5.6.28-cdb2016-log)
# Date: 2018-05-29 10:41:34
# Generator: MySQL-Front 5.3  (Build 5.20)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "sys_province"
#

DROP TABLE IF EXISTS `sys_province`;
CREATE TABLE `sys_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(30) NOT NULL COMMENT '省份名称',
  `province_short_name` varchar(30) DEFAULT '',
  `sort` int(11) DEFAULT '0' COMMENT '顺序',
  `valid` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=650001 DEFAULT CHARSET=utf8 COMMENT='SY_省份';

#
# Data for table "sys_province"
#

INSERT INTO `sys_province` VALUES (110000,'北京','北京',2,b'1'),(120000,'天津','天津',27,b'1'),(130000,'河北省','河北',11,b'1'),(140000,'山西省','山西',23,b'1'),(150000,'内蒙古自治区','内蒙古',19,b'1'),(210000,'辽宁省','辽宁',18,b'1'),(220000,'吉林省','吉林',15,b'1'),(230000,'黑龙江省','黑龙江',12,b'1'),(310000,'上海','上海',25,b'1'),(320000,'江苏省','江苏',16,b'1'),(330000,'浙江省','浙江',31,b'1'),(340000,'安徽省','安徽',1,b'1'),(350000,'福建省','福建',4,b'1'),(360000,'江西省','江西',17,b'1'),(370000,'山东省','山东',22,b'1'),(410000,'河南省','河南',10,b'1'),(420000,'湖北省','湖北',13,b'1'),(430000,'湖南省','湖南',14,b'1'),(440000,'广东省','广东',6,b'1'),(450000,'广西壮族自治区','广西',7,b'1'),(460000,'海南省','海南',9,b'1'),(500000,'重庆','重庆',3,b'1'),(510000,'四川省','四川',26,b'1'),(520000,'贵州省','贵州',8,b'1'),(530000,'云南省','云南',30,b'1'),(540000,'西藏自治区','西藏',28,b'1'),(610000,'陕西省','陕西',24,b'1'),(620000,'甘肃省','甘肃',5,b'1'),(630000,'青海省','青海',21,b'1'),(640000,'宁夏回族自治区','宁夏',20,b'1'),(650000,'新疆维吾尔自治区','新疆',29,b'1');
