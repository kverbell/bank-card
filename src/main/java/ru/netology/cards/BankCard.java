package ru.netology.cards;

public abstract class BankCard {
    protected double balance;

    public BankCard() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public abstract String getAvailableFundsInfo();

    public abstract void topUpBalance(double amount);

    public abstract boolean pay(double amount);
}
