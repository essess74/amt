package com.amt.repositories;

import com.amt.entities.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by MedMalek on 18/10/2015.
 */
public interface ArticleRepository extends PagingAndSortingRepository<ArticleEntity, Long> {
    Page<ArticleEntity> findById(Long id, Pageable page);
}
