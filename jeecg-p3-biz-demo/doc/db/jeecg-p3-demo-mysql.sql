/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50037
Source Host           : localhost:3306
Source Database       : jeecg-p3

Target Server Type    : MYSQL
Target Server Version : 50037
File Encoding         : 65001

Date: 2016-04-11 21:47:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `jw_auth`
-- ----------------------------
DROP TABLE IF EXISTS `jw_auth`;
CREATE TABLE `jw_auth` (
  `id` bigint(20) unsigned NOT NULL auto_increment COMMENT '序号',
  `auth_id` varchar(32) collate utf8_bin NOT NULL default '' COMMENT '权限编码',
  `auth_name` varchar(100) collate utf8_bin default NULL COMMENT '权限名称',
  `auth_type` varchar(2) collate utf8_bin default NULL COMMENT '权限类型 0:菜单;1:功能',
  `auth_contr` varchar(256) collate utf8_bin default NULL COMMENT '权限控制',
  `parent_auth_id` char(12) collate utf8_bin default NULL COMMENT '上一级权限编码',
  `leaf_ind` char(2) collate utf8_bin default NULL COMMENT '是否叶子节点',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_authid` (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='运营系统权限表';

-- ----------------------------
-- Records of jw_auth
-- ----------------------------
INSERT INTO `jw_auth` VALUES ('1', '21', '系统管理', '0', null, null, 'N');
INSERT INTO `jw_auth` VALUES ('2', '2101', '用户管理', '0', '/system/back/jwSystemUser/list.do', '21', 'Y');
INSERT INTO `jw_auth` VALUES ('3', '210101', '新增用户', '1', '/system/back/jwSystemUser/doAdd.do', '2101', 'Y');
INSERT INTO `jw_auth` VALUES ('4', '210102', '编辑用户', '1', '/system/back/jwSystemUser/doEdit.do', '2101', 'Y');
INSERT INTO `jw_auth` VALUES ('5', '2102', '角色管理', '0', '/system/back/jwSystemRole/list.do', '21', 'Y');
INSERT INTO `jw_auth` VALUES ('6', '210201', '新增角色', '1', '/system/back/jwSystemRole/doAdd.do', '2102', 'Y');
INSERT INTO `jw_auth` VALUES ('7', '210202', '编辑角色', '1', '/system/back/jwSystemRole/doEdit.do', '2102', 'Y');
INSERT INTO `jw_auth` VALUES ('8', '210203', '角色授权', '1', '/system/back/jwSystemRole/editRoleAuth.do', '2102', 'Y');
INSERT INTO `jw_auth` VALUES ('9', '210204', '删除角色', '1', '/system/back/jwSystemRole/doDelete.do', '2102', 'Y');
INSERT INTO `jw_auth` VALUES ('10', '2103', '权限管理', '0', '/system/back/jwSystemAuth/list.do', '21', 'Y');
INSERT INTO `jw_auth` VALUES ('11', '210301', '新增权限', '1', '/system/back/jwSystemAuth/doAdd.do', '2103', 'Y');
INSERT INTO `jw_auth` VALUES ('12', '210302', '编辑权限', '1', '/system/back/jwSystemAuth/doEdit.do', '2103', 'Y');

-- ----------------------------
-- Table structure for `wx_act_invite`
-- ----------------------------
DROP TABLE IF EXISTS `wx_act_invite`;
CREATE TABLE `wx_act_invite` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT '活动名称',
  `begin_time` datetime default NULL COMMENT '活动开始时间',
  `end_time` datetime default NULL COMMENT ' 活动结束时间',
  `hdurl` varchar(300) default NULL COMMENT '入口地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='红包活动表';

-- ----------------------------
-- Records of wx_act_invite
-- ----------------------------
INSERT INTO `wx_act_invite` VALUES ('95B6BF61945043039008299AA53A2991', '1212', '2016-03-26 15:50:32', '2016-03-26 15:50:34', '1212');
INSERT INTO `wx_act_invite` VALUES ('DEBCE74A2E87406EBA557748BE0FA700', '1', '2016-04-10 14:33:50', '2016-04-10 14:33:52', '1');
