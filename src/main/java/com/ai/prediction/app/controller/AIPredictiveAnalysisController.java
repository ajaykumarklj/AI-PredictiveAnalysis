package com.ai.prediction.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ai.prediction.app.model.Claim;
import com.ai.prediction.app.model.ClaimAmountPerService;
import com.ai.prediction.app.service.AIPredictiveAnalysisService;
import com.ai.prediction.app.service.ClaimAmountService;

@RestController
@CrossOrigin(origins = "*")
public class AIPredictiveAnalysisController {
	
	@Autowired
	private AIPredictiveAnalysisService  aiPredictiveAnalysisService;
	

	@Autowired
	private ClaimAmountService  claimAmountService;

	@PostMapping(value = "/claims")
	public Claim analyzeClaim(@RequestBody Claim claim) {
		List<ClaimAmountPerService> list= claimAmountService.getClaimAmountPerService(claim.getCity(), "Angiography");
		if(!list.isEmpty())
		{
			float amount=  Math.round(claim.getClaimAmount())- Math.round(list.get(0).getClaimAmount());
			System.out.println("ClaimAnalyzer.analyzeClaim() amount::"+amount);
			claim.setDeviation(amount);
		
		}
		return aiPredictiveAnalysisService.analyzeClaim(claim);
	}

	
}
