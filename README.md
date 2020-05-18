## 南城北巷的社区

### 资料   
[SpringBoot 所有技术示例集合](https://spring.io/guides)<br>
[web前端开发示例](https://spring.io/guides/gs/serving-web-content/)<br>
[elasticsearch技术](https://elasticsearch.cn/explore)  
[远程连接本地的秘钥配置方法(https/ssh)](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)<br>
[BootStrap框架开发示例](https://v3.bootcss.com/getting-started/)<br>
[Github OAuth市场的API开发接口](https://developer.github.com/apps/building-github-apps/creating-a-github-app/)<br>
[Spring配置mybatis的官方文档](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)<br>
[SpringBoot集成mybatis文档](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)<br>
[菜鸟教程](https://www.runoob.com/mysql/mysql-insert-query.html)<br>
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)

### 工具
[Git](https://git-scm.com/download)<br>
[VP](https://www.visual-paradigm.com)<br>
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)<br>
[Lombok](https://projectlombok.org/setup/maven)

### 脚本
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
  ```
  ```bash
  mvn flyway:migrate
  ```

```
项目目录
├─.idea
│  ├─dataSources
│  └─inspectionProfiles
├─.mvn
│  └─wrapper
├─src
│  ├─main
│  │  ├─java
│  │  │  └─life
│  │  │      └─peng
│  │  │          └─community
│  │  │              ├─controller
│  │  │              ├─dto
│  │  │              ├─mapper
│  │  │              ├─model
│  │  │              └─provider
│  │  └─resources
│  │      ├─db
│  │      │  └─migration
│  │      ├─static
│  │      │  ├─css
│  │      │  ├─fonts
│  │      │  └─js
│  │      └─templates
│  └─test
│      └─java
│          └─life
│              └─peng
│                  └─community
└─target
    ├─classes
    │  ├─db
    │  │  └─migration
    │  ├─life
    │  │  └─peng
    │  │      └─community
    │  │          ├─controller
    │  │          ├─dto
    │  │          ├─mapper
    │  │          ├─model
    │  │          └─provider
    │  ├─static
    │  │  ├─css
    │  │  ├─fonts
    │  │  └─js
    │  └─templates
    ├─generated-sources
    │  └─annotations
    ├─generated-test-sources
    │  └─test-annotations
    └─test-classes
        └─life
            └─peng
                └─community
```