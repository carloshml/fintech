package com.teste.fintech;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teste.fintech.controller.dto.CreateWalletDto;
import com.teste.fintech.controller.dto.TransferDto;
import com.teste.fintech.entity.Transfer;
import com.teste.fintech.entity.Wallet;
import com.teste.fintech.entity.WalletType;
import com.teste.fintech.repository.TransferRepository;
import com.teste.fintech.repository.WalletRepository;
import com.teste.fintech.service.AuthorizationService;
import com.teste.fintech.service.NotificationService;
import com.teste.fintech.service.TransferService;

@SpringBootTest
public class TransferServiceTest {

	@Mock
	private AuthorizationService authorizationService;

	@Mock
	private NotificationService notificationService;

	@Mock
	private TransferRepository transferRepository;

	@Mock
	private WalletRepository walletRepository;

 
	@InjectMocks
	private TransferService transferService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

 

 

	// Add more test cases for other scenarios (e.g., unauthorized transfer, wallet
	// not found, etc.)
}
