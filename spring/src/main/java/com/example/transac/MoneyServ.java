package com.example.transac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class MoneyServ {

    @Autowired
    MoneyDao moneyDao;

    @Transactional(rollbackFor = { IOException.class }) // 這裡要使用 事務回滾，可以寫在類上面
    public boolean transfMoney (Integer payId, Integer recId, BigDecimal num) {
        BigDecimal bd = moneyDao.outMoney(1, new BigDecimal(100));
        moneyDao.inMoney(2, bd);
        return true;
    }
}
