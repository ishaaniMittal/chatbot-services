package com.valarmorghulis.service;

import com.valarmorghulis.dao.LoginDao;
import com.valarmorghulis.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mounika on 11-06-2016.
 */


    @Service
    public class LoginService {


        @Autowired
        private LoginDao loginDao;

        public boolean performLogin(String username, String password) {

            for (Login login : loginDao.findAll()) {
                if (login.getUserName().equals(username) && login.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }


