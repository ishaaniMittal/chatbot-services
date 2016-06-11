package com.valarmorghulis.dao;

import com.valarmorghulis.model.AddBeneficiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by imittal on 6/11/16.
 */
@Transactional
public interface BeneficiaryDao extends CrudRepository<AddBeneficiary, Integer> {
}
