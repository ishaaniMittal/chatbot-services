package com.valarmorghulis.model;

import java.util.HashMap;

/**
 * Created by Alekhya on 12-06-2016.
 */
public class BotReq {
    private String ques;
    private HashMap reqParameters;

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public HashMap getReqParameters() {
        return reqParameters;
    }

    public BotReq() {
    }

    public BotReq(String ques, HashMap reqParameters) {
        this.ques = ques;
        this.reqParameters = reqParameters;
    }

    public void setReqParameters(HashMap reqParameters) {
        this.reqParameters = reqParameters;
    }
}
