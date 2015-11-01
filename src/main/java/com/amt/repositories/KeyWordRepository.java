package com.amt.repositories;

import com.amt.entities.KeyWordEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MedMalek on 25/10/2015.
 */
public interface KeyWordRepository extends CrudRepository<KeyWordEntity, Long> {

    List<KeyWordEntity> findByArticleId(Long articleId);
}
