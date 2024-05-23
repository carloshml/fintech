package com.teste.fintech.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.teste.fintech.entity.WalletType;
import com.teste.fintech.repository.WalletTypeRepository;

@Configuration
public class Dataloader implements CommandLineRunner {
 
	private final WalletTypeRepository  walletTypeRepository; 
	
	public Dataloader(WalletTypeRepository walletTypeRepository) {
		this.walletTypeRepository = walletTypeRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Arrays.stream(WalletType.Enum.values())
		 .forEach(walletType -> walletTypeRepository.save(walletType.get()));		
	}

}
