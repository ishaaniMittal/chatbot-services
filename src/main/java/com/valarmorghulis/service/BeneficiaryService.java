package com.valarmorghulis.service;

import com.valarmorghulis.dao.BeneficiaryDao;
import com.valarmorghulis.model.AddBeneficiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by imittal on 6/11/16.
 */
@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryDao beneficiaryDao;

    public boolean addBeneficiary(AddBeneficiary request){
        beneficiaryDao.save(request);
        return false;
    }
}
