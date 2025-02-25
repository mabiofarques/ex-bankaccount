package application;

import model.entities.BankAccount;
import model.exceptions.BusinessException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws  BusinessException{

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("João", "5465-H8", 500);

        System.out.println(account);

        try {
            account.withdraw(570);
            System.out.println(account.getBalance());
        }
        catch(BusinessException e){
            throw new BusinessException("Error: " + e.getMessage());
        }
    }
}
