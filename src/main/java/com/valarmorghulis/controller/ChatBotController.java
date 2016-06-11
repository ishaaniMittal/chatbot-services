package com.valarmorghulis.controller;

import com.valarmorghulis.model.BotResp;
import com.valarmorghulis.model.Greeting;
import com.valarmorghulis.service.ChatbotService;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by Alekhya on 11-06-2016.
 */

@Controller
@RequestMapping("/chatBot")
public class ChatBotController {

    private ChatbotService chatBotService;

    @RequestMapping("/postQues/{ques}")
    public @ResponseBody
    BotResp provideResponse(@PathVariable("ques") String ques) throws IOException, ParseException {

        return chatBotService.provideResponse(ques);
    }

}
