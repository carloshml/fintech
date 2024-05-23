package com.teste.fintech.controller.dto;

import com.teste.fintech.entity.Wallet;
import com.teste.fintech.entity.WalletType;

public record CreateWalletDto(
		String fullName,
		String cpfCnpj,
		String email,
		String password,
		WalletType.Enum  walletType
		) {
	
	public Wallet toWallet() {
		return new Wallet(
				  fullName,
				  cpfCnpj,
				  email,
				  password,
				  walletType.get()
				);
	}

}
