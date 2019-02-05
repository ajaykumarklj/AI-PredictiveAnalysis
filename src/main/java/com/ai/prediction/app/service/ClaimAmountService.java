package com.ai.prediction.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.prediction.app.model.ClaimAmountPerService;
import com.ai.prediction.app.repository.ClaimAmountPerServiceRepository;

@Service
public class ClaimAmountService {
	
	@Autowired
	private ClaimAmountPerServiceRepository claimAmountPerServiceRepository;
	
	public List<ClaimAmountPerService> getClaimAmountPerService(String city, String serviceName) {
		// TODO Auto-generated method stub
		return claimAmountPerServiceRepository.findByCityAndServiceName(city, serviceName);
	}

	public ClaimAmountPerService addServiceClaimAmount(ClaimAmountPerService claimAmountPerService) {
		// TODO Auto-generated method stub
		return claimAmountPerServiceRepository.save(claimAmountPerService);
	}
	
	

}
