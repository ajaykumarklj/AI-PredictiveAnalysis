package com.ai.prediction.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.prediction.app.model.Provider;
import com.ai.prediction.app.service.ProviderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/provider")
public class ProviderController {
	
@Autowired
@Qualifier("providerService")
private ProviderService providerService;
	
	@GetMapping("/providerId/{providerId}")
	public Provider getProviderInfo(@PathVariable(value="providerId") String providerId)
	{
		Provider provider= null;
		List<Provider> providers=providerService.getProviderList(providerId);
		if(providers!=null && !providers.isEmpty())
		{
			provider=providers.get(0);
		}
		return provider;
		
	}
	
	@PostMapping("/add")
	public Provider addProvider(@Valid @RequestBody Provider provider)
	{
		return providerService.addProvider(provider);
	}

}
