package com.knownsense.springredis.service;

import com.knownsense.springredis.vo.ContractInfo;
import com.knownsense.springredis.custDao.ContractDaoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class Svc {
    private static final Logger logger = LoggerFactory.getLogger(Svc.class);


    @Autowired
    private ContractDaoInterface ContractDao;

    public ContractInfo getContractByCategory() throws DataAccessException, IOException {
       return  ContractDao.getContractByCategory("1", "TERMS_OF_USE");
    }

}
