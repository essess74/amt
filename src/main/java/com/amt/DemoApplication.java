package com.amt;

import com.amt.entities.UserInfoEntity;
import com.amt.repositories.UserInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean CommandLineRunner init(UserInfoRepository userInfoRepository) {
        return args -> {
            Arrays.stream("teyeb.med.malek@gmail.com;essess74@hotmail.com;kingkong@yahoo.fr".split(";")).map(UserInfoEntity::new).forEach(userInfoRepository::save);
        };
    }

    @RequestMapping(value = "/login",
                    method = RequestMethod.GET)
    public String greetingForm(Model model) {
        return "login";
    }
}

