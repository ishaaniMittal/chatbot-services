package com.valarmorghulis.service;

import com.valarmorghulis.dao.LoginDao;
import com.valarmorghulis.model.Data;
import com.valarmorghulis.model.FcmSendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by imittal on 6/12/16.
 */
@Service
public class FcmService {

    private RestTemplate restTemplate;

    @Autowired
    private LoginDao loginDao;

    public boolean registerToken(String gcmToken) {
        return loginDao.updateToken(gcmToken);
    }

    public boolean sendMessage(String gcmToken, String responseAsNotification) {
        FcmSendMessage message = new FcmSendMessage();
        message.setTo(gcmToken);
        message.setData(new Data(responseAsNotification));
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String key = "key=";
        headers.set("Authorization", key.concat("AIzaSyCJ_jGcIbT7Z7zt-nSr3SgjOv4E57QI_JY"));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        restTemplate.exchange("https://fcm.googleapis.com/fcm/send", HttpMethod.POST, entity, Boolean.class);
        return true;
    }
}
