package com.amt.repositories;

import com.amt.entities.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by MedMalek on 08/11/2015.
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity,String>{
}
