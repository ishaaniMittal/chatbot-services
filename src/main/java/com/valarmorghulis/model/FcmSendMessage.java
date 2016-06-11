package com.valarmorghulis.model;



/**
 * Created by imittal on 6/12/16.
 */
public class FcmSendMessage {

    private String to;
    private Data data;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
