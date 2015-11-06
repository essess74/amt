DROP TABLE IF EXISTS category;

CREATE TABLE category (
  category VARCHAR(30) CONSTRAINT category_pk PRIMARY KEY
);

INSERT INTO category (category) VALUES ('إعلامات');
INSERT INTO category (category) VALUES ('ندوات');
INSERT INTO category (category) VALUES ('متفرّقات');
INSERT INTO category (category) VALUES ('بيانات');