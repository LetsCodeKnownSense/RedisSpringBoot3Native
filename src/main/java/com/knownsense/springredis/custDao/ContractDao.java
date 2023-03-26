package com.knownsense.springredis.custDao;

import com.knownsense.springredis.vo.ContractInfo;
import com.knownsense.springredis.ContractModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class ContractDao implements ContractDaoInterface{

    private static final Logger logger = LoggerFactory.getLogger(ContractDao.class);
    @Autowired
    @Qualifier("redis")
    private RedisTemplate<String, Object> redisContractInfo;

    @Autowired
    private Environment env;

    @Override
    public ContractInfo getContractByCategory(final String locale, String category) throws DataAccessException, IOException {
        Boolean hasKey = false;
        try {
        	
            hasKey = redisContractInfo.opsForHash().hasKey("Contract", "TERMS_OF_USE");
            if (hasKey) {
            	logger.info("Hi Knownsense!! Reading from Redis");
                return  (ContractInfo) redisContractInfo.opsForHash().get("Contract", "TERMS_OF_USE");
            }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (!hasKey) {
            try {
                final ContractInfo ContractInfo = getContractData();
                try {
                	logger.info("Hi Knownsense!! Reading from application properties file");
                    redisContractInfo.opsForHash().put("Contract", "TERMS_OF_USE", ContractInfo);
                    redisContractInfo.expire("Contract", 6, TimeUnit.HOURS);
                } catch (Exception ex) {
                    logger.warn("Error [{}] while adding Contract in redis cache", ex.getLocalizedMessage());
                }
                return ContractInfo;
            } catch (Exception ex) {
                logger.info("Application:: SVC:: GetContractByCategory::  " + ex.getMessage());
                throw  ex;
            }
        }
        return null;
    }


    private ContractInfo getContractData() throws IOException {

        ObjectMapper obj = new ObjectMapper();
        ContractInfo ContractInfo =null;
        try {
            ContractModel ContractModel = obj.readValue(env.getProperty("my.Contract"), ContractModel.class);
            if(ContractModel !=null && ContractModel.getContract() !=null )
                return ContractModel.getContract().get(0);
        } catch (Exception e) {
            logger.error("error during converting reading Contract info, {}", e);
        }
        return ContractInfo;
    }
}
