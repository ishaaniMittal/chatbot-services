package com.valarmorghulis.service;

import com.valarmorghulis.dao.BeneficiaryDao;
import com.valarmorghulis.dao.LoginDao;
import com.valarmorghulis.model.Beneficiary;
import com.valarmorghulis.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by imittal on 6/11/16.
 */
@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryDao beneficiaryDao;

    @Autowired
    private LoginDao loginDao;

    public boolean addBeneficiary(Beneficiary request) {
        beneficiaryDao.save(request);
        return false;
    }

    public boolean checkIfTransaferPossible(long amount, String username) {
        if (getBalance(username) - amount > 0)
            return true;
        return false;
    }

    public long getBalance(String username) {
        Login login = loginDao.findByUserName(username);
        return login.getBalance();
    }
}
