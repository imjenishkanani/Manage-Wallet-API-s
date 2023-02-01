package com.example.ExpenseWallet.serviceImpl;

import com.example.ExpenseWallet.entity.Wallet;
import com.example.ExpenseWallet.repository.WalletRepository;
import com.example.ExpenseWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRepository walletRepository;

    Wallet fetchedWallet;

    public Wallet getWalletById(Integer id) {
       return walletRepository.findById(id).orElse(null);
    }
    @Override
    public Wallet addUser(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Map<String, Double> showCurrentBalance(Integer id) {
        Map<String, Double> responseEntry = new HashMap<>();
        fetchedWallet = getWalletById(id);
        if(fetchedWallet == null) {
            return null;
        }
        responseEntry.put("currentBalance", fetchedWallet.getWalletBalance());
        return responseEntry;
    }

    @Override
    public Map<String, String> addBalance(Integer id, Double walletBalanceToBeAdded) {
        Map<String, String> responseMessage = new HashMap<>();
        fetchedWallet = getWalletById(id);
        if(fetchedWallet == null) {
            return null;
        }
        fetchedWallet.setWalletBalance(fetchedWallet.getWalletBalance() + walletBalanceToBeAdded);
        walletRepository.save(fetchedWallet);
        responseMessage.put("Message", "Successfully added balance");
        return responseMessage;
    }

    @Override
    public Map<String, String> withdrawMoney(Integer id, Double moneyToBeWithdraw) {
        Map<String, String> responseMessage = new HashMap<>();
        fetchedWallet = getWalletById(id);
        if(fetchedWallet == null) {
            return null;
        }
        if(moneyToBeWithdraw <= fetchedWallet.getWalletBalance()) {
            fetchedWallet.setWalletBalance(fetchedWallet.getWalletBalance() - moneyToBeWithdraw);
            walletRepository.save(fetchedWallet);
            responseMessage.put("Message", "Successfully withdraw money");
        } else {
            responseMessage.put("Message", "Balance not sufficient");
        }
        return responseMessage;
    }
}
