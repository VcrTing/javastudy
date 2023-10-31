package com.example.transac;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class MoneyDao {

    public boolean inMoney(Integer recId, BigDecimal num) {
        System.out.println("NUM = " + num);
        return true;
    }

    public BigDecimal outMoney(Integer payId, BigDecimal num) {
        return num;
    }
}
