package com.knownsense.springredis.custDao;

import com.knownsense.springredis.vo.ContractInfo;
import org.springframework.dao.DataAccessException;

import java.io.IOException;

public interface ContractDaoInterface {


    ContractInfo getContractByCategory(final String locale, String category) throws DataAccessException, IOException;
}
