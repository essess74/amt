package com.amt.repositories;

import com.amt.entities.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MedMalek on 18/10/2015.
 */
public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> {
}
