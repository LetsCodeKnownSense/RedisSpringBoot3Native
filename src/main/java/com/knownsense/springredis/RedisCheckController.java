package com.knownsense.springredis;


import com.knownsense.springredis.service.Svc;
import com.knownsense.springredis.vo.ContractInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController()
@RequestMapping(value="/knownsense")
public class RedisCheckController {

	@Autowired
	private Svc svc;

	@GetMapping("/check-redis")
	public ContractInfo check() throws IOException {
		final ContractInfo ContractInfo= svc.getContractByCategory();
		return ContractInfo;
	}

}

