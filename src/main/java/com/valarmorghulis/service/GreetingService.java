package com.valarmorghulis.service;

import com.valarmorghulis.dao.GreetingDao;
import com.valarmorghulis.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vijay on 11/06/2016.
 */
@Service
public class GreetingService {

    @Autowired
    private GreetingDao greetingDao;

    public Greeting displayGreeting(int index)
    {
        return greetingDao.findOne(index);
    }
}
