package com.ai.prediction.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.prediction.app.model.ClaimAmountPerService;
import com.ai.prediction.app.service.ClaimAmountService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/serviceAmount")
public class ClaimAmountController {
	
@Autowired
private ClaimAmountService claimAmountService;
	
	
	@PostMapping("/add")
	public ClaimAmountPerService addClaimAmount(@Valid @RequestBody ClaimAmountPerService claimAmountPerService)
	{
		return claimAmountService.addServiceClaimAmount(claimAmountPerService);
	}

	
}
