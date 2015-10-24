package com.amt;

import com.amt.entities.UserInfoEntity;
import com.amt.repositories.UserInfoRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.TransactionSystemException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class DemoApplicationTests {

    public static final String KINGKONG_EMAIL_DOMAIN = "kingkong@email.domain";

    @Autowired
    private UserInfoRepository userInfoRepository;

    @After
    public void tearDown() throws Exception {
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
        Assert.assertEquals(actual, userInfoEntity);
    }
}
