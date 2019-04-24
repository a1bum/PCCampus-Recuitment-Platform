# PCCampus-Recuitment-Platform

![](<https://img.shields.io/badge/layuiadmin-2.0-green.svg>)&emsp;![](<https://img.shields.io/badge/Xadmin-2.1-blue.svg>)

## 项目简介

&emsp;&emsp;校园招聘平台-PC端，一方面为手机端的微信小程序提供数据接口，另一方面为企业和高校管理人员提供沟通渠道。从企业资质审核，申请宣讲会资源，到高校招生就业处相关人员进行时间、地点安排，发布公告，整个流程形成一个闭环，将人力从繁复的流程中释放出来。后端采用 Spring + SpringMVC + Mybatis 框架，前端采用layuiadmin 和 Xadmin 部分代码，并做了相关修改，以适应本项目的使用。
	
&emsp;&emsp;本项目当前仅给出 eclipse 工程文件，和供 tomcat 启动的 war 包，以及数据库的 SQL 文件。后续可能会提供 IDEA 工程文件。微信小程序端请访问 [WXCampus-Recuitment-Platform](https://github.com/a1bum/WXCampus-Recruitment-Platform)。

## 致谢&参考

[登录界面](https://gitee.com/layuicms/layuicms) &emsp; [管理界面](https://gitee.com/daniuit/X-admin/)&emsp;[bing每日背景图](https://area.sinaapp.com/bingImg/)

## 更新日志

### 2019-04-21

1. 修改后台管理主页为 layui-admin风格（[layuiadmin](https://www.layui.com/admin/std/dist/views/)）；
2. 修复“cpu 和 内存利用率识别不准”问题（[java获取系统CPU、内存占用](https://blog.csdn.net/callmev6/article/details/83176840)）；
3. 修复“layui 复选框不渲染”问题（[为什么表单不显示？](https://www.layui.com/doc/base/faq.html#form)）；
4. 删除 xadmin.js 中无用代码，并处理相关依赖；
5. 实现“提取页面 javascript 到 xadmin.js 文件实现复用”；
6. 实现“layui 左侧菜单栏二级菜单动画” （[后台布局](https://www.layui.com/demo/admin.html)）；
7. 实现“OS/Tomcat/MySQL 版本获取及前端页面显示功能”（[java获取操作系统信息](https://mao1985.iteye.com/blog/190378)、[jsp 用java代码获得tomcat版本号](https://heisetoufa.iteye.com/blog/406791)、[Java获取mysql数据库元数据](https://blog.csdn.net/Mr_Lonely_f/article/details/48805671)）；
8. 实现“信息添加的上传附件功能，并限制上传文件格式和大小”（[图片/文件上传 - layui.upload](https://www.layui.com/doc/modules/upload.html)）。

### 2019-04-17

1. 修复“编辑和删除操作识别区域太小”问题；
2. 实现“ajax异步单项删除信息”功能；

### 2019-04-15

1. 砍掉目前不用的功能及其相关代码，使得代码结构整洁；
2. 修复“相关字体图标由于目录结构变化导致显示不正常”问题（[layui--字体图标](https://www.layui.com/doc/element/icon.html)）；
3. 修复“ iframe 加载的标签没有图标”问题；
4. 实现“ jsp 页面使用c标签循环读取分页后的数据，并以表格形式显示”；
5. 修复“table中复选框点击无效”问题（[Gitee-issue](https://gitee.com/daniuit/X-admin/issues/IVFBL)）。

### 2019-04-13

1. 解决“后台登录界面在分辨率小的情况下兼容性”问题（[html+CSS让背景图片充满整个屏幕](https://blog.csdn.net/u011846249/article/details/78283844)）；

### 2019-04-10

1. mapper 配置文件的 namespace 一定要与写的 mapper 接口中的类名保持一致，否则会出现没有找到该配置文件下的方法；
2. mapper 接口中的方法参数，与 mapper 配置文件中参数名一致，并不会直接去找文件名一致的进行注入，因为方法参数为临时变量，所以 mapper 配置文件中不知道哪一个是对应的，解决方法是在mapper接口方法参数前面加上 mybatis 的注解 @Param() 说明；

### 2019-04-09

1. 编写python程序，调用海投网微信小程序接口获取数据，并通过mysqlclient完成数据库的插入和查询；
2. 修改数据库表结构适合实际需要。

### 2019-03-31

1. 编写python脚本请求微信解密接口获取用户openid（[Java调用Python程序方法总结](https://blog.csdn.net/IT_xiao_bai/article/details/79074988)）；
2. 使用 jython 使得 java 调用 python 脚本；
3. 完成用户接口并做单元测试。

### 2019-03-25

1. 手动填充部分学校的官网和就业信息网的 URL

### 2019-03-21

1. 解决“ tomcat 启动时报错 java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener”（[[Solved] java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener](https://howtodoinjava.com/spring-core/solved-java-lang-classnotfoundexception-org-springframework-web-context-contextloaderlistener/)）
2. 解决“数据库模糊查询”

### 2019-03-20

1. 解决“访问Controller中的 RequstMapping 路径 404”，缺少web.xml
2. 尝试解决“tomcat 启动时报错 ContextLoaderListener找不到”问题

### 2019-03-19

1. 解决 “console 中报错 SQLerror” 问题
2. Univesity 模块的增加、查询功能，单元测试并写出 Controller 接口
3. 解决“工程不能部署到 tomcat server”问题（[在eclipse下创建maven项目并部署到tomcat服务器下](https://blog.csdn.net/m751075306/article/details/11115353)）
4. 尝试解决“访问Controller中的 RequstMapping 路径 404”

### 2019-03-18

1. 使用 eclipse 安装 git 插件（[eclipse快速安装git工具](https://jingyan.baidu.com/article/09ea3ede74b8d9c0aede39c0.html)）
2. 尝试解决 ApplicationContext 文件 Load fail 问题

### 2019-03-12~2019-03-17

       不得不说，懒得要命，混吃等死，项目搁置

### 2019-03-11

1. 利用 python 的requests、json、jsonpath获取中国大学名单
2. 利用 shell 标准输出重定向为一个 csv 文件

### 2019-03-10

1. 解决“创建多个外键时报错 Foreign key constraint is incorrectly formed”
2. 找到中国大学名单，分析网页结构（[ajax动态加载网页抓取](https://zhuanlan.zhihu.com/p/35682031)）
3. 尝试编写爬虫，填充 university_info 表

### 2019-03-09

1. 新建 maven工程，配置 pom.xml 文件

2. 安装 MariaDB 数据库，配置 dbconfig.properties
3. 使用 navicat prenium 设计数据库，创建表