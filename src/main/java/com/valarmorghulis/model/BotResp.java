package com.valarmorghulis.model;

import java.util.HashMap;

/**
 * Created by imittal on 6/11/16.
 */
public class BotResp {

    private String response;
    private HashMap chatParameters;

    public BotResp(String response) {
        this.response = response;
    }

    public BotResp() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public HashMap getChatParameters() {
        return chatParameters;
    }

    public void setChatParameters(HashMap chatParameters) {
        this.chatParameters = chatParameters;
    }
}
