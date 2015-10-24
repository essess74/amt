package com.amt.controllers;

import com.amt.entities.KeyWordEntity;
import com.amt.repositories.ArticleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by MedMalek on 18/10/2015.
 */
@RestController
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping("/articles")
    public
    @ResponseBody
    Object getAllArticles() {
        return articleRepository.findAll();
    }

    @RequestMapping("/articles/{id}")
    public
    @ResponseBody
    Object getArticle(@PathVariable("id") Long id) {
        return articleRepository.findOne(id);
    }

    @RequestMapping("/articles/search/{keyWords}")
    public
    @ResponseBody
    Object getArticlesWithKeyWords(@PathVariable("keyWords") String keyWords) {
        //return articleRepository.findByKeyWordsIn(Arrays.asList(StringUtils.split(keyWords, ",")).forEach(x -> new KeyWordEntity(x)), new PageRequest(0, 10));
        //return articleRepository.findOne(id);
        return null;
    }
}
