/*
Navicat MySQL Data Transfer

Source Server         : WJ
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : note_note

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-06-06 16:26:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '测试1');
INSERT INTO `category` VALUES ('2', '测试2');

-- ----------------------------
-- Table structure for `note`
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` int(10) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `abs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content_html` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `content_md` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `author` int(10) DEFAULT NULL,
  `category` int(10) DEFAULT NULL,
  `last_modified_time` datetime DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `note_ibfk_1` (`author`),
  KEY `note_ibfk_2` (`category`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`author`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `note_ibfk_2` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES ('1', 'n1', null, null, null, '4', '1', null, null);
INSERT INTO `note` VALUES ('2', 'n2', null, null, null, '4', '2', null, null);

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'leo');
INSERT INTO `test` VALUES ('2', 'luis');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '16ded035f0759f0b58f8948dee9296ec', 'UmVStKMYu3wG9cAkMp5SuA==');
INSERT INTO `user` VALUES ('2', 'li', '1af9a1f87ba2efbb4ca57f4a3427f12c', '/6v87FchPOrxYqQm4D2uTQ==');
INSERT INTO `user` VALUES ('3', 'yang', '07af46091f927ed3ce3ed98980339a98', 'CuuuAwBPhsOx5iaK+/2d5Q==');
INSERT INTO `user` VALUES ('4', 'hq', '37eb78348eadbecb07e6054aa532321e', 'DJ0YGQuBNKzNq1XT6Sv+ug==');
