package com.example.ExpenseWallet.repository;

import com.example.ExpenseWallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
