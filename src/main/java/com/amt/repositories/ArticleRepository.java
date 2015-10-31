package com.amt.repositories;

import com.amt.entities.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Created by MedMalek on 18/10/2015.
 */
public interface ArticleRepository extends PagingAndSortingRepository<ArticleEntity, Long>,JpaSpecificationExecutor<ArticleEntity> {
    Page<ArticleEntity> findById(Long id, Pageable page);

    /*@Query("select distinct a from KeyWordEntity k, ArticleEntity a where (k.keyWord in :keyWords and k.article.id = a.id ) or (a.title like '%:keyWords%') order by a.submissionDate desc")
    Page<ArticleEntity> findByKeyWordsIn(@Param("keyWords") Collection<String> keyWords, Pageable page);*/
}
