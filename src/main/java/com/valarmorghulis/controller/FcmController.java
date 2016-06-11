package com.valarmorghulis.controller;

import com.valarmorghulis.service.FcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by imittal on 6/12/16.
 */
@Controller
@RequestMapping("/fcm")
public class FcmController {

    @Autowired
    private FcmService fcmService;

    @RequestMapping("/register")
    public boolean registerToken(String gcmToken) {
        return fcmService.registerToken(gcmToken);
    }
}
