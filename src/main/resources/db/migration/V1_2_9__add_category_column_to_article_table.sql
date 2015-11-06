ALTER TABLE article
ADD COLUMN category VARCHAR(30);

UPDATE article
SET category = 'إعلامات';

ALTER TABLE article
ALTER COLUMN category SET NOT NULL;

ALTER TABLE article ADD CONSTRAINT article_category_fk FOREIGN KEY (category) REFERENCES category (category)
  MATCH FULL;