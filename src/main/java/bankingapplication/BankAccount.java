package bankingapplication;

import java.math.BigInteger;

public class BankAccount {
    private String accountHolder;
    private BigInteger accountNumber;
    private double balance;

    public static enum TransactionType {
        DEPOSIT, WITHDRAW
    }

    public BankAccount(String accountHolder, BigInteger accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdraw amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public BigInteger getAccountNumber() {
        return accountNumber;
    }
}