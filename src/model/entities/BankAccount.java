package model.entities;

import model.exceptions.BusinessException;

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

    public void deposit(double amount)throws BusinessException{
        if(amount > 0) {
            balance = getBalance() + amount;
        }
        else {
            throw new BusinessException("Invalid deposit");
        }
    }

    public void withdraw(double amount) throws BusinessException{
        validadeWithdraw(amount);
        if (amount > getBalance()) {
            double overdraftUsed = amount - getBalance();
            double overdraftFee = overdraftUsed * 0.2;
            balance = - overdraftUsed - overdraftFee ;
            System.out.println("You are in overdraft funds. Overdraft applied: 20% of $" + overdraftUsed);
        }
        else {
            balance -= amount;
        }
    }

    private void validadeWithdraw(double amount) throws BusinessException{
        if(amount <= 0){
            throw new BusinessException("Invalid withdraw");
        }
        double availableBalance = getBalance() + getOverdraftFacility();
        if(amount > availableBalance) {
            throw new BusinessException("This amount is not available, even with overdraft facility.");
        }

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
