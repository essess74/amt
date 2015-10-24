package com.amt.repositories;

import com.amt.entities.UserInfoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by MedMalek on 24/10/2015.
 */
@RepositoryRestResource(path = "userInfo")
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfoEntity, String> {
}
