package com.valarmorghulis.controller;

import com.valarmorghulis.model.Login;
import com.valarmorghulis.service.FcmService;
import com.valarmorghulis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alekhya on 11-06-2016.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private FcmService fcmService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public boolean authenticateUser(@RequestBody Login request) {
        fcmService.sendMessage("hi","he");
        return loginService.performLogin(request.getUserName(), request.getPassword());
    }
}

