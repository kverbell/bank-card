package ru.netology.cards;

public class DebitCard extends BankCard {
    @Override
    public String getAvailableFundsInfo() {
        return "Ваш баланс: " + balance + " рублей.";
    }

    @Override
    public void topUpBalance(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
