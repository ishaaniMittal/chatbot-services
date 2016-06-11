package com.valarmorghulis.dao;

import com.valarmorghulis.model.Login;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Alekhya on 11-06-2016.
 */
@Transactional
public interface LoginDao extends CrudRepository<Login, Integer> {
    Login findByUserName(String username);

    boolean updateToken(String gcmToken);
}
