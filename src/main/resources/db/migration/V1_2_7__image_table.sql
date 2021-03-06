DROP TABLE IF EXISTS image;

DROP SEQUENCE IF EXISTS image_seq;

CREATE SEQUENCE image_seq START 1 INCREMENT 1;

CREATE TABLE image (
  id    INTEGER CONSTRAINT image_seq_pk PRIMARY KEY DEFAULT nextval('image_seq'),
  image BYTEA
);