package com.ai.prediction.engine;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.prediction.app.engine.ClaimAnalyzer;
import com.ai.prediction.app.model.Claim;
import com.ai.prediction.app.model.Claim.ClaimType;
import com.ai.prediction.app.model.Claim.ServiceType;
import com.ai.prediction.app.model.ClaimAmountPerService;
import com.ai.prediction.app.repository.ClaimAmountPerServiceRepository;
import com.ai.prediction.app.service.ClaimAmountService;

public class ClaimAnalyzerTest {
	
	@Autowired	
	ClaimAmountPerServiceRepository claimAmountPerServiceRepository;

	@Test
	public void test() {
		ClaimAnalyzer analyzer = new ClaimAnalyzer();
		
		Claim claim = new Claim();
		claim.setClaimId(UUID.randomUUID());
		claim.setProviderName("ravikiran");
		claim.setServiceType(ServiceType.Angiography);
		claim.setClaimType(ClaimType.Medical);
		claim.setCity("Atlanta");
		//.setProviderType(ProviderType.IN_NETWORK);
		claim.setClaimAmount(3500);
		/*List<ClaimAmountPerService> list=claimAmountPerServiceRepository.findByCityAndServiceName(claim.getCity(), ServiceType.Angiography);*/
		System.out.println(claim);
		System.out.println(analyzer.analyzeClaim(claim).isProvDetailsReq());
	}
	
	@Test
	public void testClaimAmount() {
		ClaimAmountPerService claim = new ClaimAmountPerService();
		
		
		claim.setServiceName("Angiography");
		claim.setCity("Atlanta");
		//.setProviderType(ProviderType.IN_NETWORK);
		claim.setClaimAmount(3500);
		System.out.println(claim);
		ClaimAmountService claimAmountService= new ClaimAmountService();
		claimAmountService.addServiceClaimAmount(claim);
		
	}

}
