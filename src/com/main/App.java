package com.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);
    static User userSekarang;

    public static int showMenu() {
        System.out.printf("====== Silahkan Pilih Menu ====== %s \n", userSekarang.getUserName());
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tambah Saldo");
        System.out.println("3. Transfer");
        System.out.println("4. Log Out");
        System.out.println("5. Selesai");
        System.out.print("Silahkan Pilih Nomor Menu : ");
        return input.nextInt();
    }

    public static void login(ArrayList<User> users) {
        System.out.print("Username : ");
        String userName = input.next();
        System.out.print("Pin (Angka) : ");
        int pin = input.nextInt();
        Boolean founded = false;
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPin() == pin) {
                System.out.printf("== Berhasil Login %s == \n", user.getUserName());
                founded = true;
                userSekarang = user;
                break;
            }
        }
        if (!founded) {
            System.out.println("User Tidak Ditemukan");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("slamet", 123, 123, 5));
        users.add(new User("sri", 12, 12, 5));
        System.out.println("============= Selamat Datang ===============");
        System.out.println("Silahkan Masukkan Username Dan Pin : ");
        try {
            login(users);
        } catch (InputMismatchException e) {
            System.out.println("Mohon Memasukkan Input Yang Sesuai");
        }
        Boolean state = true;
        while (state) {
            int pil = showMenu();
            switch (pil) {
                case 1:
                    System.out.println("\n Saldo Anda " + userSekarang.cekSaldo() + "\n");
                    break;
                case 2:
                    System.out.print(" Masukkan Jumlah Saldo : ");
                    int saldo = input.nextInt();
                    userSekarang.tambahSaldo(saldo);
                    System.out.println("\n Saldo Anda " + userSekarang.cekSaldo() + "\n");
                    break;
                case 3:
                    System.out.print("Masukkan Rekening Tujuan : ");
                    int rekening = input.nextInt();
                    BankProcess bank = new BankProcess();
                    Boolean status = bank.checkRekening(users, userSekarang, rekening);
                    if (status) {
                        System.out.printf("\n Transfer Kepada Rekening %d Berhasil \n", rekening);
                    } else {
                        System.out.println("Gagal");
                    }
                    break;
                case 4:
                    login(users);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilih Menu Yang Sesuai");
                    break;
            }
        }
    }
}