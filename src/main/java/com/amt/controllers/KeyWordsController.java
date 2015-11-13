package com.amt.controllers;

import com.amt.entities.KeyWordEntity;
import com.amt.repositories.KeyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MedMalek on 12/11/2015.
 */
@RestController
public class KeyWordsController {

    @Autowired
    private KeyWordRepository keyWordRepository;

    @RequestMapping("admin/keywords")
    public @ResponseBody List<KeyWordEntity> getKeywordsForArticle(@RequestParam("articleId") Long articleId) {
        return keyWordRepository.findByArticleId(articleId);
    }
}
