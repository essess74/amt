package com.amt.repositories;

import com.amt.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by MedMalek on 28/04/2015.
 */
public interface UserRepository extends CrudRepository<UsersEntity, Long>, PagingAndSortingRepository<UsersEntity, Long> {
    public UsersEntity findByUsername(final String username);
}