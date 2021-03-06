/*Drop article table*/
DROP TABLE IF EXISTS article;
DROP SEQUENCE IF EXISTS article_no_seq;
CREATE SEQUENCE article_no_seq START 1;

/*Create article table*/
CREATE TABLE article (
  id              INTEGER CONSTRAINT firstkey PRIMARY KEY DEFAULT nextval('article_no_seq'),
  title           VARCHAR(100) NOT NULL,
  content         TEXT         NOT NULL,
  url             VARCHAR(200),
  type            VARCHAR(3)   NOT NULL,
  author          VARCHAR(40)  NOT NULL,
  image_id        INTEGER,
  submission_date DATE                                    DEFAULT CURRENT_DATE
);