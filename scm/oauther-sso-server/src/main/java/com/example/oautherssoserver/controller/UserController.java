package com.example.oautherssoserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author sleepwalker
 */
@RestController
public class UserController {

    @RequestMapping("/user/me")
    public Principal user(Principal user){
        return user;
    }

}
