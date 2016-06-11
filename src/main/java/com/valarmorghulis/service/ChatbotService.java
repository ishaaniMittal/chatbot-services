package com.valarmorghulis.service;

import com.valarmorghulis.dao.ETQDao;
import com.valarmorghulis.model.Beneficiary;
import com.valarmorghulis.model.BotReq;
import com.valarmorghulis.model.BotResp;
import com.valarmorghulis.model.Topic;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Alekhya on 11-06-2016.
 */
@Service
public class ChatbotService {


    @Autowired
    BeneficiaryService beneficiaryService;

    @Autowired
    ETQDao etqDao;


    public BotResp provideResponse(BotReq req) throws IOException, ParseException {
        String url = "https://api.wit.ai/message";
        String key = "7D6SBYV522DKGVN45BKFISHPNSSNP5SZ";

        String param1 = "20160612";
        String param2 = req.getQues();
        String charset = "UTF-8";
        BotResp botResp = new BotResp();

        String query = String.format("v=" + URLEncoder.encode(param1, charset) + "&q=" +
                URLEncoder.encode(param2, charset));

        //System.out.println(url + "?" + query);
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty ("Authorization","Bearer "+ key);
        connection.setRequestProperty("Accept-Charset", charset);

        InputStream resp = connection.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(resp));
        String line="";
        String line1="";
        while((line=reader.readLine())!=null)
        {
            //System.out.println(line);
            line1+=line;
        }
        JSONParser par = new JSONParser();
        Object parse = par.parse(line1);
        JSONObject obj = (JSONObject)parse;
        HashMap entities = (HashMap) obj.get("entities");
        Set set = entities.keySet();
        Iterator it = set.iterator();
        HashMap<String,String> entityMap = new HashMap();
        String dbResp="";
        String topic = decideTopic(entities);
        if(topic!=null)
        {
            req.getReqParameters().put("topic",topic);
        }
        else
        {
            topic = (String) req.getReqParameters().get("topic");
        }
        while(it.hasNext())
        {
            String entity = it.next().toString();
            JSONArray array = (JSONArray) entities.get(entity);
            HashMap map = (HashMap) array.get(0);
            String value = map.get("value").toString();
            //System.out.println(value);
            entityMap.put(entity, value);
            if(topic!=null) {
                dbResp+=etqDao.getResponse(entity,topic );
            }
            else
            {
                dbResp+="I didn't quiet follow you";
            }
        }




        String otherDetails = checkDetails(entities,req.getReqParameters());
        dbResp+=otherDetails;
        botResp.setResponse(dbResp);
        botResp.setChatParameters(req.getReqParameters());


        return botResp;
    }

    private String decideTopic(HashMap entities) {
        Set set = entities.keySet();
        Iterator it = set.iterator();
        while(it.hasNext())
        {
            String entity = it.next().toString();
            Topic topic = etqDao.getTopic(entity);
            if(topic!=null)
                return topic.getName();
        }
        return null;
    }

    private String checkDetails(HashMap entities,HashMap params) {
        String res = "";
        String topic= (String) params.get("topic");
        if(topic!=null) {

            List<String> topicEntities = etqDao.getEntititiesForTopic(topic);

            Set set = entities.keySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String entity = it.next().toString();
                if (topicEntities.contains(entity)) {
                    JSONArray array = (JSONArray) entities.get(entity);
                    HashMap map = (HashMap) array.get(0);
                    String value = map.get("value").toString();
                    //System.out.println(value);
                    params.put(entity, value);
                }

            }
            Beneficiary ben = new Beneficiary();
            boolean created = createBenRequest(params, ben);
            if (created) {
                boolean b = beneficiaryService.addBeneficiary(ben);
                if (b) {
                    res += "\nBeneficiary added!";
                } else {
                    res += "\nBeneficiary not added :(";
                }

            }
            checkTransfer(params, res);
        }
        return res;
    }

    private void checkTransfer(HashMap params, String res) {
        if(params.get("contact")!=null && params.get("amount")!=null){
            boolean b = beneficiaryService.checkIfTransaferPossible((long) params.get("amount"), (String) params.get("contact"));
            if(b)
            {
                res+="\nAmount is transferrable";
            }
            else{
                res+="\ninsufficient balance :(";
            }
        }
    }

    private boolean createBenRequest(HashMap params,Beneficiary ben) {
        if(params.get("contact")==null)
        {
            return false;
        }
        else {
            ben.setName((String) params.get("contact"));
        }
        if(params.get("ifsc")==null)
        {
            return false;
        }
        else {
            ben.setIfscCode((String) params.get("ifsc"));
        }
        if(params.get("accountNo")==null)
        {
            return false;
        }
        else {
            ben.setAccountNumber((int) params.get("accountNo"));
        }

        return true;
    }


}
