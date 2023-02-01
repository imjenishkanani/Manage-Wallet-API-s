package com.example.ExpenseWallet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Wallet")
public class    Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;
    @Column(name = "userName")
    public String userName;
    @Column(name = "walletBalance")
    public Double walletBalance;

    public Integer id() {
        return id;
    }

    public void id(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }
}
