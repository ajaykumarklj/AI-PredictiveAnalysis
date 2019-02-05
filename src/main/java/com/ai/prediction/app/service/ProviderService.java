package com.ai.prediction.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.prediction.app.model.Provider;
import com.ai.prediction.app.repository.ProviderRepository;

@Service
public class ProviderService {
	
@Autowired
private ProviderRepository providerRepository;

public List<Provider> getProviderList(String providerId) {
	// TODO Auto-generated method stub
	return providerRepository.findByProvId(providerId);
}

public Provider addProvider(Provider provider) {
	// TODO Auto-generated method stub
	return providerRepository.save(provider);
}



}
