/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : laf

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 11/05/2022 14:05:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emailtable
-- ----------------------------
DROP TABLE IF EXISTS `emailtable`;
CREATE TABLE `emailtable`  (
  `email_id` int(0) NOT NULL,
  `email_sender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email_addressee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email_status` tinyint(0) NULL DEFAULT NULL,
  `email_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`email_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emailtable
-- ----------------------------
INSERT INTO `emailtable` VALUES (14, '123132@email.com', 'all', NULL, '这个网页真好看.我超级喜欢', '2020-03-20 08:02:04');
INSERT INTO `emailtable` VALUES (15, '1231321', 'all', NULL, '大家好,初来乍到', '2020-03-20 08:03:59');
INSERT INTO `emailtable` VALUES (16, '112233', '12222', NULL, '您的账户因违章违规,特发警告!下次讲直接封号!', '2020-03-20 14:23:35');
INSERT INTO `emailtable` VALUES (17, '12222', '12222', NULL, '用户举报寻物招领(id:23)存在违规违章行为,请管理员核实!!', '2020-03-28 00:59:44');
INSERT INTO `emailtable` VALUES (20, '12222', '19981212', NULL, '用户举报寻物招领(id:26)存在违规违章行为,请管理员核实!!', '2020-03-28 01:14:26');
INSERT INTO `emailtable` VALUES (21, '23', '12222', NULL, '用户12222对您发布的信息23感兴趣,如有意向,请尽快联系!!', '2020-03-28 01:14:33');
INSERT INTO `emailtable` VALUES (22, '34', '12222', NULL, '用户12222对您发布的信息34感兴趣,如有意向,请尽快联系!!', '2020-04-02 17:38:21');
INSERT INTO `emailtable` VALUES (23, '35', '12222', NULL, '用户12222对您发布的信息35感兴趣,如有意向,请尽快联系!!', '2020-04-03 01:50:56');
INSERT INTO `emailtable` VALUES (24, '35', '12222', NULL, '用户12222对您发布的信息35感兴趣,如有意向,请尽快联系!!', '2020-04-03 07:32:28');
INSERT INTO `emailtable` VALUES (26, '12222', '12222', NULL, '用户12222对您发布的信息36感兴趣,如有意向,请尽快联系!!', '2020-04-03 07:47:56');
INSERT INTO `emailtable` VALUES (27, '21313', 'all', NULL, '你哦撒', '2020-04-03 07:59:29');
INSERT INTO `emailtable` VALUES (28, '1001100', '12222', NULL, '您的账户因违章违规,特发警告!下次讲直接封号!', '2020-04-03 11:45:07');
INSERT INTO `emailtable` VALUES (29, '1001100', '12222', NULL, '您的账户因违章违规,特发警告!下次讲直接封号!', '2020-04-03 11:45:54');
INSERT INTO `emailtable` VALUES (30, '6879', 'all', NULL, '笔', '2020-04-03 12:10:40');

-- ----------------------------
-- Table structure for goodstable
-- ----------------------------
DROP TABLE IF EXISTS `goodstable`;
CREATE TABLE `goodstable`  (
  `goods_id` int(0) NOT NULL,
  `goods_kinds` tinyint(0) NULL DEFAULT NULL,
  `goods_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `goods_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `goods_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `goods_master` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `goods_contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `goods_time` timestamp(0) NULL DEFAULT NULL,
  `goods_success` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodstable
-- ----------------------------
INSERT INTO `goodstable` VALUES (15, 0, '掉了一张照片', '12469d63-cc4b-476a-b9fb-f3ca3a86fa41.ico', '新东方的楼下', '1221212', '12313213', '2020-03-16 02:52:18', 1);
INSERT INTO `goodstable` VALUES (16, 1, '掉了一张照片啊', '7fb6858d-9604-4c37-aa34-c3a95ff6d9ce.ico', '新东下', '1221212', '15065248357', '2020-03-16 10:41:50', 0);
INSERT INTO `goodstable` VALUES (17, 0, '着急啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 'd976e0e8-3835-48ff-8680-b9a7184cf8ed.ico', '新东方的楼下', '1221212', '15065268997', '2020-03-16 10:44:51', 0);
INSERT INTO `goodstable` VALUES (18, 1, '捡到一张照片,失主请到23号楼联系我', '12080257-d754-466c-b178-b03d08254299.png', '23好楼下', '1221212', '15065268997', '2020-03-16 10:51:14', 0);
INSERT INTO `goodstable` VALUES (19, 0, '掉了一张照片', 'ba3b50ff-ec38-40ba-a58a-2209e43e1ebc.png', '23好楼下', '1221212', '15065268997', '2020-03-16 10:52:03', 0);
INSERT INTO `goodstable` VALUES (20, 0, '掉了一张照片', 'f03b36ae-e80f-4242-a442-465ba0e82db6.ico', '新东方的楼下', '12222', '15065268997', '2020-03-20 03:22:04', 1);
INSERT INTO `goodstable` VALUES (21, 1, '捡到一张照片,失主请到23号楼联系我', 'ae51c54b-dfcd-4d8c-b36f-7df32ca71440.jpg', '新东方的楼下', '12222', '1231311424', '2020-03-20 03:23:42', 1);
INSERT INTO `goodstable` VALUES (22, 1, '12212', 'b3f729ed-71ec-4ea3-9533-dcb6fbab5a5d.ico', '23好楼下', '12222', '13213213', '2020-03-20 03:24:29', 1);
INSERT INTO `goodstable` VALUES (23, 0, '掉了一张照片', '6e95a72a-3dc5-42eb-a4f4-23242e3a6e87.ico', '新东方的楼下', '12222', '155646364', '2020-03-28 00:49:45', 0);
INSERT INTO `goodstable` VALUES (24, 1, '捡到一张照片,失主请到23号楼联系我', '976b12d8-9e1c-4d21-b84d-04455c50541d.ico', '新东下', '12222', '436436', '2020-03-28 00:50:21', 0);
INSERT INTO `goodstable` VALUES (25, 0, '掉了一张照片', 'f8d5ad4b-73c6-4c44-a4e5-7eb888bc4cc5.jpg', '新东方的楼下', '12222', '15065546546', '2020-03-28 00:59:09', 0);
INSERT INTO `goodstable` VALUES (26, 0, '掉了一张照片啊', 'd93bd101-8f48-42b8-abfd-90f435b56489.ico', '新东下', '12222', '15065268997', '2020-03-28 01:14:14', 0);
INSERT INTO `goodstable` VALUES (27, 0, '掉了一张照片', '4d595dae-b447-489b-ace1-10d1c1aa6aac.png', '23好楼下', '12222', '15065268997', '2020-03-28 01:25:16', 0);
INSERT INTO `goodstable` VALUES (28, 0, '掉了一张照片', '58f8ed77-7a51-4d6b-87a5-dd3ef1aa465e.png', '新东方的楼下', '12222', '132132313213@qq.com', '2020-04-01 03:24:56', 0);
INSERT INTO `goodstable` VALUES (29, 1, '捡到一张照片,失主请到23号楼联系我', '34905cce-8cef-4646-b4d3-0bdab81bbea9.png', '23好楼下', '12222', '132132313213@qq.com', '2020-04-01 03:25:35', 0);
INSERT INTO `goodstable` VALUES (30, 0, '掉了一张照片', '1d24c715-4211-432d-97b8-f63eb9a45dfd.ico', '23好楼下', '12222', '132132313213@qq.com', '2020-04-01 03:32:44', 0);
INSERT INTO `goodstable` VALUES (31, 0, '捡到一张照片,失主请到23号楼联系我', '2f815fa9-bca3-42b7-87c4-e80691720af6.png', '新东方的楼下', '12222', '313213', '2020-04-01 03:40:01', 0);
INSERT INTO `goodstable` VALUES (32, 0, '掉了一张照片', 'a06b811c-bfdf-474a-a64d-621c5c6a5ef5.png', '国vv', '12222', '1231311424', '2020-04-01 05:39:03', 0);
INSERT INTO `goodstable` VALUES (33, 0, '掉了一张照片', 'd161d714-b9d2-4d30-a868-851bff4bd37a.ico', '国vv', '12222', '1323123', '2020-04-01 05:41:19', 0);
INSERT INTO `goodstable` VALUES (34, 1, '捡到一张照片,失主请到23号楼联系我', '95064656-9c3d-4754-8d26-39641e322dc5.ico', '新东方的楼下', '12222', '1323123', '2020-04-02 06:09:18', 0);
INSERT INTO `goodstable` VALUES (35, 0, '掉了一张照片', '679f2e86-b304-48a6-adb7-22b0538471dc.jpg', '新东方的楼下', '12222', '15065268997', '2020-04-03 01:50:40', 1);
INSERT INTO `goodstable` VALUES (36, 0, '捡到一张照片,失主请到23号楼联系我', '81dd9591-28b6-465c-9a51-922983002bd5.ico', '23好楼下', '12222', '15065268997', '2020-04-03 07:38:39', 0);
INSERT INTO `goodstable` VALUES (37, 1, '掉了一张照片', 'e992a3fe-3fa1-4bc3-86c0-dd07168d20bb.jpg', '新东方的楼下', '12222', '15065268997', '2020-04-03 07:56:52', 0);
INSERT INTO `goodstable` VALUES (38, 0, '掉了一张照片', '7008a52f-28b5-4354-b646-5de44f88c9fe.jpg', '新东方的楼下', '12222', '132132313213@qq.com', '2020-04-03 11:37:47', 0);
INSERT INTO `goodstable` VALUES (39, 1, '掉了一张照片', 'a1fbe681-9f9c-496e-9087-084cf0d0d71c.ico', '23好楼下', '12222', '132132313213@qq.com', '2020-04-03 12:09:11', 0);

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable`  (
  `user_id` bigint(0) NOT NULL COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `user_idnum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `user_status` tinyint(0) NULL DEFAULT NULL COMMENT '状态',
  `user_position` tinyint(0) NULL DEFAULT NULL COMMENT '权限',
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES (12222, 'AE02A442834A1FD7F14B74FE3C6FF3DC', 'A52FB1E3878D19E52254DB0BD3F68C66', '15065268997', '0FDAE764DD85429DC39959D3BD0E53FA', 0, 1, '37FC1BDF14D109E8EA81ED4836FE2F71');
INSERT INTO `usertable` VALUES (121212, '0423158FAAAE3925D8AB7B7BAF447278', 'A52FB1E3878D19E52254DB0BD3F68C66', '12313132311', '18B24B56BBE325708F423B0F406CD6D2', 0, 0, '72DCC892E83136365D15FC85DD3C674B');
INSERT INTO `usertable` VALUES (121300, '338A2CB608CAE83E48D6819E8EFE700E', 'A52FB1E3878D19E52254DB0BD3F68C66', '12312312', '60DF152B479FB9560800700FDDD8A924', 1, 0, '496E851A36DBEAC34FA30C5796089B02');

SET FOREIGN_KEY_CHECKS = 1;
