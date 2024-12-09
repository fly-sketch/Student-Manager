CREATE DATABASE IF NOT EXISTS ssm_student_management_b30;

USE ssm_student_management_b30;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin1', 'pass123', '管理员一');
INSERT INTO `admin` VALUES (2, 'admin2', 'pass123', '管理员二');
INSERT INTO `admin` VALUES (3, 'admin3', 'pass123', '管理员三');
INSERT INTO `admin` VALUES (4, 'admin4', 'pass123', '管理员四');
INSERT INTO `admin` VALUES (5, 'admin5', 'pass123', '管理员五');
INSERT INTO `admin` VALUES (6, 'user', '123', NULL);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '计算机基础', '计算机科学的基本概念和原理', 1);
INSERT INTO `course` VALUES (2, '高等数学', '微积分和线性代数的基础知识', 2);
INSERT INTO `course` VALUES (3, '普通物理', '经典力学和电磁学的基础知识', 3);
INSERT INTO `course` VALUES (4, '有机化学', '有机化学的基础理论和实验', 4);
INSERT INTO `course` VALUES (5, '生物学', '生物科学的基本原理', 5);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 1, 1, 86);
INSERT INTO `score` VALUES (2, 2, 2, 90);
INSERT INTO `score` VALUES (3, 3, 3, 78);
INSERT INTO `score` VALUES (4, 4, 4, 88);
INSERT INTO `score` VALUES (5, 5, 5, 92);
INSERT INTO `score` VALUES (6, 1, 2, 80);
INSERT INTO `score` VALUES (7, 2, 3, 85);
INSERT INTO `score` VALUES (8, 3, 4, 75);
INSERT INTO `score` VALUES (9, 4, 5, 89);
INSERT INTO `score` VALUES (10, 5, 1, 95);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'student1', 'pass123', '张三1', 20, '男');
INSERT INTO `student` VALUES (2, 'student2', 'pass123', '李四', 22, '女');
INSERT INTO `student` VALUES (3, 'student3', 'pass123', '王五', 21, '男');
INSERT INTO `student` VALUES (4, 'student4', 'pass123', '赵六', 23, '女');
INSERT INTO `student` VALUES (5, 'student5', 'pass123', '孙七', 20, '男');
INSERT INTO `student` VALUES (6, 'user', '123', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'teacher1', 'pass123', '张老师', '计算机系');
INSERT INTO `teacher` VALUES (2, 'teacher2', 'pass123', '李老师', '数学系');
INSERT INTO `teacher` VALUES (3, 'teacher3', 'pass123', '王老师', '物理系');
INSERT INTO `teacher` VALUES (4, 'teacher4', 'pass123', '赵老师', '化学系');
INSERT INTO `teacher` VALUES (5, 'teacher5', 'pass123', '孙老师', '生物系');
INSERT INTO `teacher` VALUES (6, 'user', '123', NULL, NULL);
INSERT INTO `teacher` VALUES (7, '1', '1', '1', NULL);
INSERT INTO `teacher` VALUES (8, '1', '1', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
