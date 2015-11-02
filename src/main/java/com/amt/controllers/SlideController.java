package com.amt.controllers;

import com.amt.entities.ArticleEntity;
import com.amt.repositories.ArticleRepository;
import com.amt.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SlideController {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ImageRepository imageRepository;


    @RequestMapping("/slide")
    public
    @ResponseBody List<ArticleEntity> getSlideshowImages() {
        List<ArticleEntity> articles = articleRepository.findTop6ByTypeOrderBySubmissionDateDesc("IMG");
        articles.forEach(articleEntity -> articleEntity.setImage(imageRepository.findOne(articleEntity.getImageId()).getImage()));
        return articles;
    }
}
