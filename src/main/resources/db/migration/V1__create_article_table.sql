/*Drop article table*/
DROP TABLE IF EXISTS article;

/*Create article table*/
CREATE TABLE article (
  id              INT           NOT NULL AUTO_INCREMENT,
  title           VARCHAR(100)  NOT NULL,
  author          VARCHAR(40)   NOT NULL,
  content         VARCHAR(1000) NOT NULL,
  submission_date TIMESTAMP              DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);