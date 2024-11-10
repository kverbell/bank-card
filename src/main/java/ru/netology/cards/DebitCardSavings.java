package ru.netology.cards;

public class DebitCardSavings extends DebitCard {
    private static final double SAVINGS_PERCENTAGE = 0.00005;

    @Override
    public void topUpBalance(double amount) {
        super.topUpBalance(amount);
        balance += amount * SAVINGS_PERCENTAGE;
        System.out.println("Вы накопили: " + (amount * SAVINGS_PERCENTAGE) + " рублей.");
    }
}
