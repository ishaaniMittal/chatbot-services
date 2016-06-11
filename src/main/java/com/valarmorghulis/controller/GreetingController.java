package com.valarmorghulis.controller;

import com.valarmorghulis.model.Greeting;
import com.valarmorghulis.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Vijay on 11/06/2016.
 */
@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/get/{index}")
    public @ResponseBody
    Greeting displayGreeting(@PathVariable("index") int index)
    {
        return greetingService.displayGreeting(index);
    }
}
