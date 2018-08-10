/*
Navicat MySQL Data Transfer

Source Server         : 172.16.15.116
Source Server Version : 50505
Source Host           : 172.16.15.116:3306
Source Database       : write01

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-08-03 11:40:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_employee
-- ----------------------------
DROP TABLE IF EXISTS `system_employee`;
CREATE TABLE `system_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deleted` tinyint(4) DEFAULT NULL COMMENT '1 有效  2 无效 -1 删除',
  `create_id` int(11) DEFAULT NULL COMMENT '创建id（cashier_member：ID）',
  `create_name` varchar(100) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_id` int(11) DEFAULT NULL COMMENT '修改者id（cashier_member：ID）',
  `last_update_name` varchar(100) DEFAULT NULL COMMENT '修改者',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `name` varchar(50) DEFAULT NULL COMMENT '员工姓名',
  `loginname` varchar(20) DEFAULT NULL COMMENT '登录名',
  `loginpwd` varchar(11) DEFAULT NULL COMMENT '登录密码',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `icon_skin` varchar(50) DEFAULT NULL COMMENT '图标样式',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_employee
-- ----------------------------
INSERT INTO `system_employee` VALUES ('1', '0', '1', '余能顺', '2018-07-24 13:10:03', null, null, null, '余能顺', 'ynshun', '123456', '1', 'user', '系统超级管理员');
INSERT INTO `system_employee` VALUES ('122', '0', '1', '余能顺', '2018-07-24 13:11:53', null, null, null, '张三', 'zhangsan', '123456', '2', 'user', '系统超级管理员');
INSERT INTO `system_employee` VALUES ('123', '0', '1', '余能顺', '2018-07-24 13:12:02', null, null, null, '李四', 'lisi', '123456', '3', 'user', '系统超级管理员');
INSERT INTO `system_employee` VALUES ('124', '0', '1', '余能顺', '2018-07-24 13:12:09', null, null, null, '王五', 'wangwu', '123456', '4', 'user', '系统超级管理员');
INSERT INTO `system_employee` VALUES ('125', '0', '1', '余能顺', '2018-07-24 13:12:21', null, null, null, '大麻子', 'damazi', '123456', '4', 'user', '系统超级管理员');

-- ----------------------------
-- Table structure for system_organiz
-- ----------------------------
DROP TABLE IF EXISTS `system_organiz`;
CREATE TABLE `system_organiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deleted` tinyint(4) DEFAULT NULL COMMENT '1 有效  2 无效 -1 删除',
  `create_id` int(11) DEFAULT NULL COMMENT '创建id（cashier_member：ID）',
  `create_name` varchar(100) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_id` int(11) DEFAULT NULL COMMENT '修改者id（cashier_member：ID）',
  `last_update_name` varchar(100) DEFAULT NULL COMMENT '修改者',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `org_name` varchar(50) DEFAULT NULL COMMENT '组织架构名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级ID（Null为顶级）',
  `icon_skin` varchar(50) DEFAULT NULL COMMENT '图标样式',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_organiz
-- ----------------------------
INSERT INTO `system_organiz` VALUES ('1', '0', null, null, null, '1', '余能顺', '2018-07-31 15:56:17', '重庆软岛科技（发展）股份有限公司', null, 'company', '重庆软岛科技股份有限公司成立于2005年，实际跨境电商服务平台运营历史已达十来年，是一家专业提供数字娱乐产品和游戏增值服务 的全球性跨境电商平台服务的高科技公司。核心业务是“数字 娱乐产品跨境电子商务增值服务平台”——即通过成熟运营的全球跨境电商增值服务平台，面向中国的数字娱乐服务产品提供商、游戏厂商、游戏运营商和增值服务提供商提供海外市场的产品发布、 营销推广、互联网运营、海外电子收支清算、7*24小时多语言呼叫、物流仓储管理等一体化的海外在线运营服务，帮助中国优秀数字娱乐产品、游戏和增值服务实现海外市场的销售拓展，帮助其把 产品和服务推向全球。\n公司致力于协助帮助中国中小型数字娱乐产业服务商、游戏厂商、娱乐增值服务企业进行全球市场开拓的同时，积极从事自主知识产权 的跨境电子商务技术平台的研发、各数据仓库的建立、海外在 线信用风控体系研发及大数据运营系统建设等业务。公司曾多次荣获全国 “技术先进型服务企业”、“重庆市创新性试点企业”“重庆市高新技术产品”等荣誉奖项。多年来，软岛科技一直秉承 “以 诚为本，用户第一”的经营理念，专注全球化数字娱乐电商服务平台的系统化运营，目标为助力中国数字娱乐产业服务商向多文化、多地域的国际化发展。');
INSERT INTO `system_organiz` VALUES ('2', '0', '1', '余能顺', '2018-07-24 10:59:01', null, null, null, 'IT中心', '1', 'briefcase', '主要负责IT相关的处理');
INSERT INTO `system_organiz` VALUES ('3', '0', '1', '余能顺', '2018-07-24 11:01:08', null, null, null, '财务中心', '1', 'briefcase', '主要负责财务相关的处理');
INSERT INTO `system_organiz` VALUES ('4', '0', null, null, null, '1', '余能顺', '2018-07-27 16:29:11', '人资中心', '1', 'briefcase', '主要负责人力资源相关的工作');
INSERT INTO `system_organiz` VALUES ('5', '0', '1', '余能顺', '2018-07-24 11:39:40', null, null, null, 'TM协理', '2', 'briefcase', '主要负责软件开发相关工作');
INSERT INTO `system_organiz` VALUES ('6', '0', '1', '余能顺', '2018-07-24 11:41:02', null, null, null, '海外业务部', '5', 'briefcase', '主要负责海外业务相关软件开发工作');
INSERT INTO `system_organiz` VALUES ('122', '1', '1', '余能顺', '2018-07-24 11:41:02', '1', '余能顺', '2018-07-27 13:50:29', '打算发到付', '6', 'briefcase', '大打算发到付');
INSERT INTO `system_organiz` VALUES ('123', '1', '1', '余能顺', '2018-07-27 10:27:46', '1', '余能顺', '2018-07-27 13:50:25', '我就是这么强大', '122', 'briefcase', '啦啦啦啦啦啦啦啦啦');
INSERT INTO `system_organiz` VALUES ('124', '1', '1', '余能顺', '2018-07-27 10:38:31', '1', '余能顺', '2018-07-27 11:49:44', '高级部门', '1', 'briefcase', '高级部门');
INSERT INTO `system_organiz` VALUES ('125', '1', '1', '余能顺', '2018-07-27 10:40:23', '1', '余能顺', '2018-07-27 11:49:26', '还是这么高级', '124', 'briefcase', '还是这么高级');
INSERT INTO `system_organiz` VALUES ('126', '1', '1', '余能顺', '2018-07-27 10:41:05', '1', '余能顺', '2018-07-27 13:50:22', '打算发到付', '123', 'briefcase', '打发斯蒂芬');
INSERT INTO `system_organiz` VALUES ('127', '1', '1', '余能顺', '2018-07-27 10:42:52', '1', '余能顺', '2018-07-27 13:52:28', '没有办法我就是这么强大', '3', 'briefcase', '啦啦啦啦啦阿拉啦');
INSERT INTO `system_organiz` VALUES ('128', '1', '1', '余能顺', '2018-07-27 11:05:19', '1', '余能顺', '2018-07-27 13:52:23', 'soaga', '3', 'briefcase', 'dafdfdsf');
INSERT INTO `system_organiz` VALUES ('129', '0', '1', '余能顺', '2018-07-27 13:57:18', null, null, null, '海外华人', '6', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('130', '0', '1', '余能顺', '2018-07-27 13:57:39', null, null, null, '海外虚拟', '6', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('131', '0', '1', '余能顺', '2018-07-27 13:57:51', null, null, null, '海外电竞', '6', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('132', '0', '1', '余能顺', '2018-07-27 13:58:06', null, null, null, '前段开发', '6', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('133', '0', '1', '余能顺', '2018-07-27 13:58:18', null, null, null, '研发团队', '6', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('134', '0', '1', '余能顺', '2018-07-27 14:03:19', null, null, null, '运维云平台部', '5', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('135', '0', '1', '余能顺', '2018-07-27 14:04:02', null, null, null, '运维支撑', '134', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('136', '0', '1', '余能顺', '2018-07-27 14:04:16', null, null, null, '云平台', '134', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('137', '0', '1', '余能顺', '2018-07-27 14:05:16', null, null, null, '数据平台部', '5', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('138', '0', '1', '余能顺', '2018-07-27 14:05:39', null, null, null, '国内业务部', '5', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('139', '0', '1', '余能顺', '2018-07-27 14:10:06', null, null, null, '独立业务部', '2', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('140', '0', '1', '余能顺', '2018-07-27 14:10:33', null, null, null, 'PM协理', '2', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('141', '0', '1', '余能顺', '2018-07-27 14:10:51', null, null, null, '项目产品部', '140', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('142', '0', '1', '余能顺', '2018-07-27 14:11:08', null, null, null, '测试维护部', '140', 'briefcase', '');
INSERT INTO `system_organiz` VALUES ('143', '0', '1', '余能顺', '2018-07-27 14:11:24', null, null, null, '视觉设计部', '140', 'briefcase', '');

-- ----------------------------
-- Table structure for system_resources
-- ----------------------------
DROP TABLE IF EXISTS `system_resources`;
CREATE TABLE `system_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deleted` tinyint(4) DEFAULT NULL COMMENT '1 有效  2 无效 -1 删除',
  `create_id` int(11) DEFAULT NULL COMMENT '创建id（cashier_member：ID）',
  `create_name` varchar(100) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_id` int(11) DEFAULT NULL COMMENT '修改者id（cashier_member：ID）',
  `last_update_name` varchar(100) DEFAULT NULL COMMENT '修改者',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名字',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `org_id` int(11) DEFAULT NULL COMMENT '所属部门ID',
  `icon_skin` varchar(50) DEFAULT NULL COMMENT '图标样式',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_resources
-- ----------------------------

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deleted` tinyint(4) DEFAULT NULL COMMENT '1 有效  2 无效 -1 删除',
  `create_id` int(11) DEFAULT NULL COMMENT '创建id（cashier_member：ID）',
  `create_name` varchar(100) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_id` int(11) DEFAULT NULL COMMENT '修改者id（cashier_member：ID）',
  `last_update_name` varchar(100) DEFAULT NULL COMMENT '修改者',
  `last_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名字',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `org_id` int(11) DEFAULT NULL COMMENT '所属部门ID',
  `icon_skin` varchar(50) DEFAULT NULL COMMENT '图标样式',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('1', '0', '1', '余能顺', '2018-07-24 13:04:40', null, null, null, '超级管理员', 'admin', '1', 'users', null);
INSERT INTO `system_role` VALUES ('2', '0', '1', '余能顺', '2018-07-24 13:04:40', null, null, null, 'IT总监', 'it_director', '2', 'users', null);
INSERT INTO `system_role` VALUES ('3', '0', '1', '余能顺', '2018-07-24 13:04:40', null, null, null, '首席架构师', 'it_rchitect', '5', 'users', null);
INSERT INTO `system_role` VALUES ('4', '0', '1', '余能顺', '2018-07-24 13:04:40', null, '', null, 'Java研发人员', 'java_programmer', '6', 'users', null);
INSERT INTO `system_role` VALUES ('122', '0', '1', '余能顺', '2018-07-24 13:49:40', null, null, null, '财务总监', 'financial_director', '3', 'users', null);
INSERT INTO `system_role` VALUES ('123', '0', '1', '余能顺', '2018-07-24 13:49:59', null, null, null, '人资总监', 'hr_director', '4', 'users', null);
