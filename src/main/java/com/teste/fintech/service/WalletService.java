package com.teste.fintech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teste.fintech.Exception.WalletDataAlreadyExistisException;
import com.teste.fintech.controller.dto.CreateWalletDto;
import com.teste.fintech.entity.Wallet;
import com.teste.fintech.repository.WalletRepository;

@Service
public class WalletService {

	private final WalletRepository walletRepository;

	public WalletService(WalletRepository walletRepository) {
		this.walletRepository = walletRepository;
	}

	public Wallet createWallet(CreateWalletDto dto) {
		var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
		
		if(walletDb.isPresent()) {
			throw new WalletDataAlreadyExistisException("CPF CNPJ or E-mail Exists");
		}
		return walletRepository.save(dto.toWallet());
	}

	public List<Wallet> findAll() {
		return walletRepository.findAll();
	}

}
