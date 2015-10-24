DROP TABLE IF EXISTS user_info;

CREATE TABLE user_info (
  email VARCHAR(50) CONSTRAINT user_info_email_pk PRIMARY KEY
);