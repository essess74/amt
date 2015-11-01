DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS users_seq;

CREATE SEQUENCE users_seq START 1 INCREMENT 1;

CREATE TABLE users (
  id       INTEGER CONSTRAINT users_seq_key PRIMARY KEY DEFAULT nextval('users_seq'),
  username VARCHAR(30)  NOT NULL,
  password VARCHAR(100) NOT NULL,
  name     VARCHAR(30)  NOT NULL,
  phone    VARCHAR(30),
  email    VARCHAR(30)  NOT NULL,
  role     VARCHAR(5)                                   DEFAULT 'USER'
);

INSERT INTO users (username, password, name, email, role)
VALUES ('admin', '$2a$10$QwjeLX1D5IJ4USrjlS9/jOkv6McCe7Wy0Lbdi0VRJ1k21/rbFDmZe', 'admin', 'admin@email.com', 'ADMIN');
