package com.teste.fintech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.teste.fintech.controller.dto.CreateWalletDto;
import com.teste.fintech.entity.Wallet;
import com.teste.fintech.entity.WalletType;
import com.teste.fintech.repository.TransferRepository;
import com.teste.fintech.repository.WalletRepository;
import com.teste.fintech.repository.WalletTypeRepository;

import jakarta.persistence.EntityManager;

 
class WalletRepositoryMockTest {

	@Mock
	WalletRepository walletRepository;
	
	@Mock
	WalletTypeRepository walletTypeRepository;
	
	@Mock
	TransferRepository  transferRepository;

	@Mock
	EntityManager entityManager;
	
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Should return an wallet sucessfully ")
	void findWalletSucess() {
		CreateWalletDto dto = new CreateWalletDto("Carlos", "205.881.120-89", "email@mock.com", "1234",
				WalletType.Enum.USER);
		createWalletType();
		Wallet wallet = dto.toWallet();
		wallet.setId(Long.getLong("99"));
		when(walletRepository.save(wallet)).thenReturn(wallet); 
		Optional<Wallet> result1 = Optional.of(wallet);
		when(walletRepository.findByCpfCnpjOrEmail("205.881.120-89", "")).thenReturn(result1); 
		Arrays.stream(WalletType.Enum.values())
		 .forEach(walletType -> a(walletType));	  
		createWallet(dto.toWallet());
		Optional<Wallet> result = walletRepository.findByCpfCnpjOrEmail("205.881.120-89", "");
		assertThat(result.isPresent()).isTrue();
	}
	
	void a(WalletType.Enum walletType){
		WalletType wallet = walletType.get();
		wallet.setId(Long.getLong("1"));
		when(walletTypeRepository.save(walletType.get())).thenReturn(wallet);
	}
	
	@Test
	@DisplayName("Should not return an wallet  ")
	void findWalletError() {  
		Optional<Wallet> result = walletRepository.findByCpfCnpjOrEmail("205.881.120-89", "");
		assertThat(result.isEmpty()).isTrue();
	}

	private Wallet createWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}
	
	private void createWalletType() {
		Arrays.stream(WalletType.Enum.values())
		 .forEach(walletType -> walletTypeRepository.save(walletType.get()));	
	}

}
