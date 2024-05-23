package com.teste.fintech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.fintech.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

	Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);

}
