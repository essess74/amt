package com.amt.controllers;

import com.amt.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
