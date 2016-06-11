package com.valarmorghulis.dao;

import com.valarmorghulis.model.ETQMapping;
import com.valarmorghulis.model.MyEntity;
import com.valarmorghulis.model.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vijay on 12/06/2016.
 */
@Transactional
public interface ETQDao extends CrudRepository<ETQMapping,Integer> {

    @Query("Select t.topic from ETQMapping t where t.topic.name=?1")
    public Topic getTopic(String entityName);

    @Query("Select t.entity.name from ETQMapping t where t.topic.name=?1")
    public List<String> getEntititiesForTopic(String name);

    @Query("select t.question.value from ETQMapping t where t.entity.name=?1 and t.topic.name=?2")
    public String getResponse(String entityName,String topicName);
}
