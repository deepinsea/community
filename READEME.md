##南城北巷的社区

##资料
https://spring.io/guides   
[^_^]:SpringBoot所有技术示例集合
https://spring.io/guides/gs/serving-web-content/ 
[^_^]:web前端开发示例
https://elasticsearch.cn/explore  
[^_^]:elasticsearch技术
https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys
[^_^]:远程连接本地的秘钥配置方法(https/ssh)
https://v3.bootcss.com/getting-started/
[^_^]:BootStrap框架开发示例
https://developer.github.com/apps/building-github-apps/creating-a-github-app/
[^_^]:Github OAuth市场的API开发接口对接
https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support
[^_^]:Spring配置mybatis的官方文档
http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
[^_^]:SpringBoot集成mybatis文档
https://www.runoob.com/mysql/mysql-insert-query.html
[^_^]:菜鸟教程

##工具
https://git-scm.com/download 
[>_<]：git下载地址
https://git-scm.com/download [>_<]：git下载地址
https://www.visual-paradigm.com [>_<]：VP工具

##脚本
```sql
create table USER
(
    ID           INTEGER default NEXT VALUE FOR "PUBLIC".auto_increment,
    ACCOUNT_ID   VARCHAR,
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);