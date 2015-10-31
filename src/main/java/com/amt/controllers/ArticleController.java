package com.amt.controllers;

import com.amt.entities.ArticleEntity;
import com.amt.repositories.ArticleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by MedMalek on 18/10/2015.
 */
@RestController
@Repository
public class ArticleController {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    ArticleRepository articleRepository;
    private static final Integer PAGE_SIZE = new Integer(10);
    private static final String BASE_QUERY = "select distinct art.* from article art, key_word key where ";

    @RequestMapping("/articles")
    public
    @ResponseBody Object getAllArticles() {
        return articleRepository.findAll();
    }

    @RequestMapping("/articles/{id}")
    public
    @ResponseBody Object getArticle(@PathVariable("id") Long id) {
        return articleRepository.findOne(id);
    }

    @RequestMapping(value = "/articles/search",
                    method = RequestMethod.GET)
    public
    @ResponseBody Object getArticlesWithKeyWords(
            @RequestParam(value = "keyWords",
                          defaultValue = StringUtils.EMPTY) String keyWords,
            @RequestParam(value = "page",
                          defaultValue = "0") Integer page) {
        List<String> queryPredicates = new ArrayList<>();
        Arrays.asList(StringUtils.split(keyWords, ",")).forEach(w -> queryPredicates.add("(art.title like '%" + w + "%') or (art.id = key.article_id and key.key_word = '" + w + "')"));
        String query = BASE_QUERY + StringUtils.join(queryPredicates, " or ") + " order by submission_date desc";

        List<ArticleEntity> results = em.createNativeQuery(query, ArticleEntity.class).setMaxResults(PAGE_SIZE).setFirstResult(page * PAGE_SIZE).getResultList();
        BigInteger count = (BigInteger) em.createNativeQuery("select count(*) from ( " + query + " ) as count").getSingleResult();
        return new PageImpl<ArticleEntity>(results, new Pageable() {
            @Override public int getPageNumber() {
                return page;
            }

            @Override public int getPageSize() {
                return PAGE_SIZE;
            }

            @Override public int getOffset() {
                return 1;
            }

            @Override public Sort getSort() {
                return null;
            }

            @Override public Pageable next() {
                return null;
            }

            @Override public Pageable previousOrFirst() {
                return null;
            }

            @Override public Pageable first() {
                return null;
            }

            @Override public boolean hasPrevious() {
                return false;
            }
        }, count.longValue());
        //return articleRepository.findAll(spec.build(), new PageRequest(page, PAGE_SIZE));
    }
}
