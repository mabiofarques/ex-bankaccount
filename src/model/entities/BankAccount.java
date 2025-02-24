package model.entities;

public class BankAccount {
    private String holder;
    private final String numberAccount;
    private double balance;
    private double overdraftFacility;
    private boolean overdraftFacilityCalculated = false;


    public BankAccount(String holder, String numberAccount, double balance) {
        this.holder = holder;
        this.numberAccount = numberAccount;
        this.balance = balance;
        calculateOverdraftFacility();
    }

    public BankAccount(String holder, String numberAccount, double balance, double overdraftFacility) {
        this.holder = holder;
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.overdraftFacility = overdraftFacility;
        this.overdraftFacilityCalculated = true;
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

    public double getOverdraftFacility() {
        return overdraftFacility;
    }

    public void deposit(double amount){
        balance =  getBalance() + amount;
    }

    public void withdraw(double amount){
        balance = getBalance() - amount;
    }

    public void calculateOverdraftFacility(){
        if (!overdraftFacilityCalculated) {
            if (getBalance() <= 500.0) {
                overdraftFacility = 50.0;
            } else {
                overdraftFacility = getBalance() * 0.5;
            }
            overdraftFacilityCalculated = true;
        }
    }


    @Override
    public String toString(){
        return "Holder: "
                + getHolder()
                + ", Number Account: "
                + getNumberAccount()
                + ", Balance: "
                + getBalance()
                + ", Overdraft Facility: "
                + getOverdraftFacility();

    }

}
