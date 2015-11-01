package com.amt;

import com.amt.entities.ArticleEntity;
import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

/**
 * Created by MedMalek on 01/11/2015.
 */
@Configuration
public class RepositoryConfiguration extends SpringBootRepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(ArticleEntity.class);
    }
}
