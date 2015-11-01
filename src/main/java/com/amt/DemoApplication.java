package com.amt;

import com.amt.entities.UserInfoEntity;
import com.amt.repositories.UserInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories
@Controller
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean CommandLineRunner init(UserInfoRepository userInfoRepository) {
        return args -> {
            Arrays.asList("teyeb.med.malek@gmail.com", "essess74@hotmail.com", "kingkong@yahoo.fr").forEach(u -> userInfoRepository.save(new UserInfoEntity(u)));
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

    @RequestMapping(value = "/login",
                    method = RequestMethod.GET)
    public String greetingForm(Model model) {
        return "login";
    }
}

