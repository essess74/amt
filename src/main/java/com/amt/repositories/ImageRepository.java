package com.amt.repositories;

import com.amt.entities.ImageEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MedMalek on 01/11/2015.
 */
public interface ImageRepository extends CrudRepository<ImageEntity, Long> {

    @Cacheable("imageByKey")
    @Override ImageEntity findOne(Long aLong);
}
