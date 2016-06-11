package com.valarmorghulis.dao;

import com.valarmorghulis.model.MyEntity;
import com.valarmorghulis.model.Topic;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vijay on 12/06/2016.
 */
@Transactional
public interface ETQDao {

    @Query("Select t.topic from ETQMapping t where t.topic.name=?1")
    public Topic getTopic(String entityName);

    
}
