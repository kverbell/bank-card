package ru.netology.cards;

public class DebitCardCashback extends DebitCard {
    private static final double CASHBACK_THRESHOLD = 5000;
    private static final double CASHBACK_PERCENTAGE = 0.05;

    private double totalSpent;

    @Override
    public boolean pay(double amount) {
        boolean success = super.pay(amount);

        if (success) {
            totalSpent += amount;
            if (totalSpent > CASHBACK_THRESHOLD) {
                double cashbackAmount = amount * CASHBACK_PERCENTAGE;
                balance += cashbackAmount;
                System.out.println("Вы получили кэшбек: " + cashbackAmount);
            }
        }
        return success;
    }
}
