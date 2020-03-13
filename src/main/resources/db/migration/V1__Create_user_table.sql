create table USER
  (
      ID           int  AUTO_INCREMENT PRIMARY KEY NOT NULL,
      ACCOUNT_ID   VARCHAR,
      NAME         VARCHAR(50),
      TOKEN        CHAR(36),
      GMT_CREATE   BIGINT,
      GMT_MODIFIED BIGINT,
      constraint USER_PK
          primary key (ID)
  );