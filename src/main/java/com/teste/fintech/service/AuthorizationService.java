package com.teste.fintech.service;

import org.springframework.stereotype.Service;

import com.teste.fintech.Exception.FintechException;
import com.teste.fintech.client.AuthorizationClient;
import com.teste.fintech.controller.dto.TransferDto;
import com.teste.fintech.entity.Transfer;

@Service
public class AuthorizationService {
	
	private final AuthorizationClient  authorizationClient;
	
	public AuthorizationService(AuthorizationClient a) {
		this.authorizationClient = a;
	}
	
	public boolean isAuthorized(TransferDto transfer) {
		
		var resp = authorizationClient.isAuthorized();
		
		if(resp.getStatusCode().isError()) {
			throw new FintechException();
		}
		
		
		return resp.getBody().authorized();
	}

}
