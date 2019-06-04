# 代码快速生成

#### 项目介绍
配合代码生成工具而搭建的建议基础框架

#### 软件架构
简单的Spring Boot框架

spring boot + mybatis + freemarker

集成了alibaba.druid

添加了用户登录信息拦截器

#### 安装教程

1. maven install 
2. nohup java -jar easyCoding-0.0.1-SNAPSHOT.jar &

#### 使用说明

1. 下载该框架,然后打开Spring Boot代码生成器
2. 修改DataBase的命名空间,如:com.coding.temp,生成代码,下载代码
3. 拷贝到该框架下面,添加html页面即可使用,如是接口则不需要页面

#### 参与贡献

1. 张永伟
2. 作者官网网站:http://www.594cto.com
3. 代码生成器地址:http://coding.594cto.com
4. 如有疑问,联系我:admin@594cto.com



#### 附上代码中基础的用户表sql 导入到自己库即可用
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编码',
  `user_name` varchar(200) DEFAULT NULL COMMENT '登录名',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表'