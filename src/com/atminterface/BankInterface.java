package com.atminterface;

import com.main.User;

public interface BankInterface {
    public Boolean transfer(User pengirim, User penerima, int total);
}
