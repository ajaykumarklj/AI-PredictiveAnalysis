package com.ai.prediction.app.service;

import org.springframework.stereotype.Service;

import com.ai.prediction.app.engine.ClaimAnalyzer;
import com.ai.prediction.app.model.Claim;
@Service
public class AIPredictiveAnalysisService {
	
	/*@Autowired
	ClaimAnalyzer claimAnalyzer;*/
	
	public Claim analyzeClaim(Claim claim) {
		ClaimAnalyzer claimAnalyzer= new ClaimAnalyzer();
		return claimAnalyzer.analyzeClaim(claim);
	}
}


