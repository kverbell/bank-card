package ru.netology.cards;

public class CreditCard extends BankCard {
    private final double creditLimit;
    private double creditBalance;
    private double personalBalance;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
        this.creditBalance = creditLimit;
        this.personalBalance = 0;
    }

    @Override
    public double getBalance() {
        return personalBalance + creditBalance;
    }

    @Override
    public String getAvailableFundsInfo() {
        return "Ваш баланс: " + getBalance() + " рублей.\n" +
                "Кредитные средства: " + creditBalance + " рублей.\n" +
                "Собственные средства: " + personalBalance + " рублей.";
    }

    @Override
    public void topUpBalance(double amount) {
        if (amount > 0) {
            double availableCredit = creditLimit - creditBalance;
            if (availableCredit > 0) {
                double creditContribution = Math.min(amount, availableCredit);
                creditBalance += creditContribution;
                amount -= creditContribution;
            }
            personalBalance += amount;
        }
    }

    @Override
    public boolean pay(double amount) {
        if (personalBalance >= amount) {
            personalBalance -= amount;
            return true;
        } else {
            double remainingAmount = amount - personalBalance;
            personalBalance = 0;
            if (creditBalance >= remainingAmount) {
                creditBalance -= remainingAmount;
                return true;
            } else {
                return false;
            }
        }
    }

    protected double getCreditBalance() {
        return creditBalance;
    }
}
