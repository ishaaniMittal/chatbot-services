package com.valarmorghulis.dao;

import com.valarmorghulis.model.Greeting;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Vijay on 11/06/2016.
 */
@Transactional
public interface GreetingDao extends CrudRepository<Greeting,Integer> {

}
