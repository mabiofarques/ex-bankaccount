package model.entities;

public class BankAccount {
    private String holder;
    private String numberAccount;
    private double balance;

    public BankAccount(){
    }

    public BankAccount(String holder, String numberAccount, double balance) {
        this.holder = holder;
        this.numberAccount = numberAccount;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance =  getBalance() + amount;
    }

    public void withdraw(double amount){
        balance = getBalance() - amount;
    }

}
