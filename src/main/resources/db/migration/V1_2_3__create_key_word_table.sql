DROP TABLE IF EXISTS key_word;

DROP SEQUENCE IF EXISTS key_word_seq;

CREATE SEQUENCE key_word_seq START 1 INCREMENT 1;

CREATE TABLE key_word (
  id         INTEGER CONSTRAINT key_word_seq_key PRIMARY KEY DEFAULT nextval('key_word_seq'),
  key_word   VARCHAR(30),
  article_id INTEGER NOT NULL,
  CONSTRAINT key_word_article_id_fkey FOREIGN KEY (article_id) REFERENCES article (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);