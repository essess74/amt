package com.amt.controllers;

import com.amt.repositories.ArticleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/articles/search", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getArticlesWithKeyWords(@RequestParam("keyWords") String keyWords, @RequestParam("page") Integer page) {
        return articleRepository.findByKeyWordsIn(Arrays.asList(StringUtils.split(keyWords, ",")), new PageRequest(page, 10));
    }
}
