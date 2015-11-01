package com.amt.repositories;

import com.amt.entities.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by MedMalek on 18/10/2015.
 */
@RepositoryRestResource(path = "articles")
public interface ArticleRepository extends PagingAndSortingRepository<ArticleEntity, Long>, JpaSpecificationExecutor<ArticleEntity> {
    Page<ArticleEntity> findById(Long id, Pageable page);
}
