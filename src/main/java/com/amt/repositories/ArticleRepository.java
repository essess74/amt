package com.amt.repositories;

import com.amt.entities.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * Created by MedMalek on 18/10/2015.
 */
public interface ArticleRepository extends PagingAndSortingRepository<ArticleEntity, Long> {
    Page<ArticleEntity> findById(Long id, Pageable page);

    @Query("select distinct k.article from KeyWordEntity k where k.keyWord in :keyWords")
    Page<ArticleEntity> findByKeyWordsIn(@Param("keyWords") Collection<String> keyWords, Pageable page);
}
