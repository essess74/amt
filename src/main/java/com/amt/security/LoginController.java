package com.amt.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by MedMalek on 06/06/2015.
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal getLoginPage(Principal user) {
        return user;
    }
}
