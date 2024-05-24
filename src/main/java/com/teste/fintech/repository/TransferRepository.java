package com.teste.fintech.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.fintech.entity.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, UUID> {

}
