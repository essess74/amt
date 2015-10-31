package com.amt;

import com.amt.entities.ArticleEntity;
import com.amt.entities.KeyWordEntity;
import com.amt.entities.UserInfoEntity;
import com.amt.repositories.ArticleRepository;
import com.amt.repositories.KeyWordRepository;
import com.amt.repositories.UserInfoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.TransactionSystemException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class DemoApplicationTests {

    private static final Log LOGGER = LogFactory.getLog(DemoApplicationTests.class);

    private static final String KINGKONG_EMAIL_DOMAIN = "kingkong@email.domain";

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private KeyWordRepository keyWordRepository;
    ArticleEntity articleEntity;
    ArticleEntity articleEntity2;

    @Before
    public void setUp() throws Exception {
        articleEntity = generateArticle("title", "author", "URL", "Content", "VID");
        articleRepository.save(articleEntity);
        for (int i = 0; i < 3; i++) {
            KeyWordEntity keyWordEntity = new KeyWordEntity();
            keyWordEntity.setArticle(articleEntity);
            keyWordEntity.setKeyWord("keyword" + i);
            keyWordRepository.save(keyWordEntity);
        }
        articleEntity2 = generateArticle("title2", "author2", "URL2", "Content2", "VID");
        articleRepository.save(articleEntity2);
        for (int i = 2; i < 5; i++) {
            KeyWordEntity keyWordEntity = new KeyWordEntity();
            keyWordEntity.setArticle(articleEntity2);
            keyWordEntity.setKeyWord("keyword" + i);
            keyWordRepository.save(keyWordEntity);
        }
    }

    @After
    public void tearDown() throws Exception {
        keyWordRepository.deleteAll();
        articleRepository.delete(articleEntity.getId());
        articleRepository.delete(articleEntity2.getId());
        if (userInfoRepository.exists(KINGKONG_EMAIL_DOMAIN))
            userInfoRepository.delete(KINGKONG_EMAIL_DOMAIN);
    }

    @Test(expected = TransactionSystemException.class)
    public void testSaveUserInfoWithNotAValidEmail() throws Exception {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setEmail("hhdf");
        userInfoRepository.save(userInfoEntity);
    }

    @Test
    public void testSaveUserInfoWithAValidEmail() throws Exception {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setEmail(KINGKONG_EMAIL_DOMAIN);
        userInfoRepository.save(userInfoEntity);
        UserInfoEntity actual = userInfoRepository.findOne(KINGKONG_EMAIL_DOMAIN);
        assertEquals(actual, userInfoEntity);
    }

    @Test
    public void testFindByKeyWordWorks() throws Exception {
        /*List<ArticleEntity> articles = articleRepository.findByKeyWordsIn(Arrays.asList("keyword10", "keyword0"), new PageRequest(0, 10)).getContent();
        articles.forEach(w -> LOGGER.debug(w));
        assertEquals(1, articles.size());*/
    }


    private ArticleEntity generateArticle(String title, String author, String url, String content, String type) {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setTitle(title);
        articleEntity.setAuthor(author);
        articleEntity.setUrl(url);
        articleEntity.setContent(content);
        articleEntity.setSubmissionDate(new Date());
        articleEntity.setType(type);
        return articleEntity;
    }
}
