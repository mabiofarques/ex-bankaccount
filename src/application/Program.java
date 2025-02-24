package application;

import model.entities.BankAccount;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("Fabio", "5465-H8", 10000);

        System.out.println(account);
    }
}
