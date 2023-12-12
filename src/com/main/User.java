package com.main;

import com.atminterface.Account;

public class User implements Account {
    public String userName;
    public int pin;
    public int rekening;
    public int saldo;

    public User(String userName, int pin, int rekening, int saldo) {
        this.userName = userName;
        this.pin = pin;
        this.rekening = rekening;
        this.saldo = saldo;
    }

    @Override
    public int cekSaldo() {
        return this.saldo;
    }

    public void tambahSaldo(int saldo) {
        this.saldo += saldo;
    }

    public String getUserName() {
        return userName;
    }

    public int getPin() {
        return pin;
    }

    public int getRekening() {
        return rekening;
    }

    public int getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", pin=" + pin + ", rekening=" + rekening + ", saldo=" + saldo + "]";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setRekening(int rekening) {
        this.rekening = rekening;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
