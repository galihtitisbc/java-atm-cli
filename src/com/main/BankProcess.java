package com.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.atminterface.BankInterface;

public class BankProcess implements BankInterface {

    @Override
    public Boolean transfer(User pengirim, User penerima, int total) {
        if (pengirim.getSaldo() < total) {
            return false;
        }
        try {
            pengirim.setSaldo(pengirim.getSaldo() - total);
            penerima.setSaldo(penerima.getSaldo() + total);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean checkRekening(ArrayList<User> daftarUser, User saatIni, int rekening) {
        boolean founded = false;
        Scanner input = new Scanner(System.in);
        User userTujuan = null;
        for (User user : daftarUser) {
            if (user.getRekening() == rekening && user.getRekening() != saatIni.getRekening()) {
                System.out.printf(" \n Rekening Ditemukan Milik : %s \n", user.getUserName());
                founded = true;
                userTujuan = user;
                break;
            }
        }
        if (!founded) {
            System.out.println("\n User Tidak Ditemukan \n");
            return false;
        }
        System.out.print("Masukkan Nominal Transfer : ");
        int total = input.nextInt();
        return transfer(saatIni, userTujuan, total);
    }

}
