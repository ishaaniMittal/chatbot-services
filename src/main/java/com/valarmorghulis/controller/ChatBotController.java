package com.valarmorghulis.controller;

import com.valarmorghulis.model.BotReq;
import com.valarmorghulis.model.BotResp;
import com.valarmorghulis.model.Greeting;
import com.valarmorghulis.model.Login;
import com.valarmorghulis.service.ChatbotService;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Alekhya on 11-06-2016.
 */

@Controller
@RequestMapping("/chatBot")
public class ChatBotController {

    private ChatbotService chatBotService;

    @RequestMapping(value = "/postQues", method = RequestMethod.POST)
    @ResponseBody
    public BotResp provideResponse(@RequestBody BotReq request) throws IOException, ParseException {

        return chatBotService.provideResponse(request);
    }

}
