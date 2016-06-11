package com.valarmorghulis.service;

import com.valarmorghulis.model.BotResp;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Alekhya on 11-06-2016.
 */
@Service
public class ChatbotService {


    public BotResp provideResponse(String ques) throws IOException {
        String url = "https://api.wit.ai/message";
        String key = "IX7KP54MZTMAR3UJLQ5Y2JHVVQSR7SP3";

        String param1 = "20160611";
        String param2 = "Hi";
        String charset = "UTF-8";

        String query = String.format("v=" + URLEncoder.encode(param1, charset) + "&q=" +
                URLEncoder.encode(param2, charset));

        System.out.println(url + "?" + query);
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty ("Authorization","Bearer "+ key);
        connection.setRequestProperty("Accept-Charset", charset);

        InputStream resp = connection.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(resp));
        String line="";
        while((line=reader.readLine())!=null)
        {
            System.out.println(line);
        }
        return null;
    }
}
