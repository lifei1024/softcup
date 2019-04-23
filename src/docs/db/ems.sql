/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.7.11-log : Database - ems
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`ems` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `ems`;

/*Table structure for table `base_company` */

CREATE TABLE `base_company` (
  `compid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `compname` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '公司名称',
  `contacts` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `comptel` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `industry` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '行业',
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`compid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_company` */

insert  into `base_company`(`compid`,`compname`,`contacts`,`comptel`,`industry`,`address`) values (1,'周口港','盛明春','133445566','水运','周口市沙河南岸');
insert  into `base_company`(`compid`,`compname`,`contacts`,`comptel`,`industry`,`address`) values (2,'漯河港','史安杰','17890929876','水运','黑龙潭镇政府东面');
insert  into `base_company`(`compid`,`compname`,`contacts`,`comptel`,`industry`,`address`) values (3,'日照港','蒋科磊','13654578219','水运','上海路');
insert  into `base_company`(`compid`,`compname`,`contacts`,`comptel`,`industry`,`address`) values (10,'上海港2','田淞丹','13896963545','水运','长江入海口处');

/*Table structure for table `base_device` */

CREATE TABLE `base_device` (
  `devid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `devname` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `typeid` int(11) DEFAULT NULL COMMENT '设备类别',
  `devdate` date DEFAULT NULL COMMENT '投入时间',
  `devuser` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '责任人',
  `compid` int(11) DEFAULT NULL COMMENT '所属企业',
  PRIMARY KEY (`devid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_device` */

/*Table structure for table `base_devtype` */

CREATE TABLE `base_devtype` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别ID',
  `typename` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_devtype` */

insert  into `base_devtype`(`typeid`,`typename`) values (1,'斗轮机');
insert  into `base_devtype`(`typeid`,`typename`) values (2,'装船机');
insert  into `base_devtype`(`typeid`,`typename`) values (3,'皮带机');

/*Table structure for table `base_flow` */

CREATE TABLE `base_flow` (
  `flowid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `flowname` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '流程名称',
  `dljid` int(11) DEFAULT NULL COMMENT '斗轮机',
  `zcjid` int(11) DEFAULT NULL COMMENT '装船机',
  `pdjid` int(11) DEFAULT NULL COMMENT '皮带机',
  `compid` int(11) DEFAULT NULL COMMENT '所属企业',
  PRIMARY KEY (`flowid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_flow` */

/*Table structure for table `base_user` */

CREATE TABLE `base_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cname` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `username` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `telno` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `email` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `compid` int(11) DEFAULT NULL COMMENT '所属企业',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `base_user` */

insert  into `base_user`(`userid`,`cname`,`username`,`password`,`telno`,`email`,`sex`,`compid`) values (1,'李海星','lhx','123456','13648495251','123@qq.com','女',1);
insert  into `base_user`(`userid`,`cname`,`username`,`password`,`telno`,`email`,`sex`,`compid`) values (2,'王文政','wwz','123456','13246467979','234@qq.com','男',8);
insert  into `base_user`(`userid`,`cname`,`username`,`password`,`telno`,`email`,`sex`,`compid`) values (3,'测试','1','1','1','1','1',9);
insert  into `base_user`(`userid`,`cname`,`username`,`password`,`telno`,`email`,`sex`,`compid`) values (4,'王文政','wwz','123456','13827299834','1234@qq.com','男',2);
insert  into `base_user`(`userid`,`cname`,`username`,`password`,`telno`,`email`,`sex`,`compid`) values (5,'梁壮壮','lzz','123456','13690947856','2345@qq.com','男',10);

/*Table structure for table `energy_consume` */

CREATE TABLE `energy_consume` (
  `consumeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键能耗id',
  `devid` int(11) DEFAULT NULL COMMENT '设备名称',
  `electric` double DEFAULT NULL COMMENT '电耗(kw.h)',
  `water` double DEFAULT NULL COMMENT '水耗(吨)',
  `oil` double DEFAULT NULL COMMENT '油耗(L)',
  `reportid` int(11) DEFAULT NULL COMMENT '报岗id',
  PRIMARY KEY (`consumeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `energy_consume` */

/*Table structure for table `energy_standradcoal` */

CREATE TABLE `energy_standradcoal` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `energetype` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '能源类别',
  `ratio` float DEFAULT NULL COMMENT '系数',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `energy_standradcoal` */

/*Table structure for table `produce_fault` */

CREATE TABLE `produce_fault` (
  `fault_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键故障id',
  `devid` int(11) DEFAULT NULL COMMENT '设备名称',
  `cause` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '故障原因',
  `faultuser` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '报告人',
  `faulttime` int(11) DEFAULT NULL COMMENT '故障时间(分钟)',
  PRIMARY KEY (`fault_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `produce_fault` */

/*Table structure for table `produce_job` */

CREATE TABLE `produce_job` (
  `jobid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `devid` int(100) DEFAULT NULL COMMENT '设备名称',
  `starttime` datetime DEFAULT NULL COMMENT '开始作业时间',
  `completetime` datetime DEFAULT NULL COMMENT '结束作业时间',
  `duration` double DEFAULT NULL COMMENT '运行时长',
  `amount` double DEFAULT NULL COMMENT '作业量',
  `reportid` int(11) DEFAULT NULL COMMENT '报岗id',
  PRIMARY KEY (`jobid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `produce_job` */

/*Table structure for table `produce_repair` */

CREATE TABLE `produce_repair` (
  `repairid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键维修id',
  `devid` int(11) DEFAULT NULL COMMENT '设备名称',
  `cause` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '维修原因',
  `cost` int(11) DEFAULT NULL COMMENT '维修费用',
  `repairdate` date DEFAULT NULL COMMENT '维修日期',
  PRIMARY KEY (`repairid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `produce_repair` */

/*Table structure for table `produce_report` */

CREATE TABLE `produce_report` (
  `reportid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键报岗id',
  `shipname` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '船队名称',
  `capacity` float DEFAULT NULL COMMENT '装载量(吨)',
  `planjobtime` datetime DEFAULT NULL COMMENT '预计到港时间',
  `startjobtime` datetime DEFAULT NULL COMMENT '实际到港时间',
  `completetime` datetime DEFAULT NULL COMMENT '完成时间',
  `flowid` int(11) DEFAULT NULL COMMENT '流程',
  `reportuser` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '报岗人',
  `compid` int(11) DEFAULT NULL COMMENT '所属企业',
  PRIMARY KEY (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `produce_report` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;