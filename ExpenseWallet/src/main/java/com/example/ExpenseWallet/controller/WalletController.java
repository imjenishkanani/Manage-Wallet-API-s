package com.example.ExpenseWallet.controller;

import com.example.ExpenseWallet.entity.Wallet;
import com.example.ExpenseWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/wallet")
@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/add-user")
    public Wallet createUser(@RequestBody Wallet wallet) {
        return walletService.addUser(wallet);
    }

    @GetMapping("/current-balance/{id}")
    public Map<String,Double> getCurrentBalance(@PathVariable Integer id) {
        return walletService.showCurrentBalance(id);
    }

    @PutMapping(path = "/add-balance/{id}")
    public Map<String, String> addBalance(@PathVariable Integer id,@RequestBody Double balance) {
        return walletService.addBalance(id, balance);
    }

    @PutMapping(path = "/withdraw-money/{id}")
    public Map<String, String> withdrawMoney(@PathVariable Integer id, @RequestBody Double money) {
        return walletService.withdrawMoney(id, money);
    }
}
