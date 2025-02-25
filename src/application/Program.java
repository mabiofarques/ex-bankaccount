package application;

import model.entities.BankAccount;
import model.exceptions.BusinessException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws  BusinessException{

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter data account:");

        try {
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Account number: ");
            String accountNumber = sc.next();
            System.out.print("Balance: ");
            double balance = sc.nextDouble();

            BankAccount acc1 = new BankAccount(holder, accountNumber, balance);

            System.out.println("Account created.");
            System.out.println();

            System.out.println("Account data:" );
            System.out.println(acc1);
            System.out.println();

            System.out.println("SYSTEM:");

            boolean keep = true;
            while(keep) {
                System.out.println("Would you like: (deposit/withdraw/paybill/leave)");
                String choice = sc.next();
                switch (choice) {
                    case "deposit":
                        System.out.print("Enter amount to deposit: ");
                        acc1.deposit(sc.nextDouble());
                        System.out.println("Update balance: $ " + String.format("%.2f", acc1.getBalance()));
                        break;
                    case "withdraw":
                        System.out.print("Enter amount to withdraw: ");
                        acc1.withdraw(sc.nextDouble());
                        System.out.println("Update balance: $ " + String.format("%.2f", acc1.getBalance()));
                        break;
                    case "paybill":
                        System.out.print("Enter amount you want to pay: ");
                        acc1.payBill(sc.nextDouble());
                        System.out.println("Update balance: $ " + String.format("%.2f", acc1.getBalance()));
                        break;
                    case "leave":
                        keep = false;
                    default:
                        break;
                }
            }
            System.out.println("Updated account: " + acc1);
            System.out.println("Closing the bank system!");
        }
        catch(InputMismatchException e){
            throw new InputMismatchException("Something goes wrong");
        }
        catch(BusinessException e){
            throw new BusinessException("Error: " + e.getMessage());
        }
    }
}
