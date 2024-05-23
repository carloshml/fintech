package com.teste.fintech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.fintech.entity.WalletType;

 

@Repository
public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
 

}
