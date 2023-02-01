package com.example.ExpenseWallet.service;

import com.example.ExpenseWallet.entity.Wallet;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface WalletService {
    Wallet addUser(Wallet wallet);

    Map<String, Double> showCurrentBalance(Integer id);

    Map<String, String> addBalance(Integer id, Double walletBalanceToBeAdded);

    Map<String, String> withdrawMoney(Integer id, Double moneyToBeWithdraw);
}
