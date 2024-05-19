-- ----------------------------
-- Table structure for interface_info
-- ----------------------------
use chl_so;
DROP TABLE IF EXISTS `interface_info`;
CREATE TABLE `interface_info`  (
                                   `id` bigint(0) NOT NULL AUTO_INCREMENT,
                                   `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口名称',
                                   `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口描述',
                                   `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口地址',
                                   `method` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求类型',
                                   `requestHeader` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求头',
                                   `responseHeader` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '响应头',
                                   `status` tinyint(0) NULL DEFAULT 1 COMMENT '接口状态 0 关闭，1启用',
                                   `isDelete` int(0) NULL DEFAULT 1 COMMENT '逻辑删除 0 删除，1正常',
                                   `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                   `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
                                   `userId` bigint(0) NULL DEFAULT NULL,
                                   `requestParams` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求参数',
                                   `sdk` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口对应的SDK类路径',
                                   `parameterExample` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数示例',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interface_info
-- ----------------------------
INSERT INTO `interface_info` VALUES (3, 'getName', '获取用户名', 'http://localhost:8123/api/interface/name/user', 'post', '{\"Content-Type\":\"application/json\"}', '{\"Content-Type\":\"application/json\"}', 1, 1, '2023-07-08 20:00:14', '2023-07-08 20:00:14', 1, '\n{\"name\":\"name\",\"type\":\"string\"}\n', 'com.czq.apiclientsdk.client.NameApiClient', '{ \"name\": \"czq\"}');
INSERT INTO `interface_info` VALUES (4, 'getRandomWork', '随机文本', 'http://localhost:8123/api/interface/random/word', 'get', NULL, NULL, 1, 1, '2023-07-29 20:33:55', '2023-07-29 20:33:55', 1, '', 'com.czq.apiclientsdk.client.RandomApiClient', NULL);
INSERT INTO `interface_info` VALUES (5, 'getRandomImageUrl', '随机动漫图片地址', 'http://localhost:8123/api/interface/random/image', 'post', NULL, NULL, 1, 1, '2023-07-29 21:51:08', '2023-07-29 21:51:08', 1, NULL, 'com.czq.apiclientsdk.client.RandomApiClient', NULL);
INSERT INTO `interface_info` VALUES (6, 'getDayWallpaperUrl', '每日壁纸URL', 'http://localhost:8123/api/interface/day/wallpaper', 'post', NULL, NULL, 1, 1, '2023-07-29 22:20:10', '2023-07-29 22:20:10', 1, NULL, 'com.czq.apiclientsdk.client.DayApiClient', NULL);
