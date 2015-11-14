package com.amt.controllers;

import com.amt.entities.KeyWordEntity;
import com.amt.repositories.KeyWordRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by MedMalek on 12/11/2015.
 */
@RestController
public class KeyWordsController {

    @Autowired
    private KeyWordRepository keyWordRepository;

    @RequestMapping(value = "admin/keywords",
                    method = RequestMethod.GET)
    public @ResponseBody Collection<String> getKeywordsForArticle(@RequestParam("articleId") Long articleId) {
        return CollectionUtils.collect(keyWordRepository.findByArticleId(articleId), new Transformer<KeyWordEntity, String>() {
            @Override public String transform(KeyWordEntity input) {
                return input.getKeyWord();
            }
        });
    }

    @RequestMapping(value = "admin/keywords",
                    method = RequestMethod.POST)
    public void saveKeyWords(
            @RequestParam("keywords") List<String> keywords, @RequestParam("articleId") Long articleId) {
        keyWordRepository.deleteByArticleId(articleId);
        CollectionUtils.collect(keywords, new Transformer<String, KeyWordEntity>() {
            @Override public KeyWordEntity transform(String input) {
                KeyWordEntity keyWordEntity = new KeyWordEntity();
                keyWordEntity.setArticleId(articleId);
                keyWordEntity.setKeyWord(input);
                return keyWordEntity;
            }
        }).forEach(x -> keyWordRepository.save(x));
    }
}
