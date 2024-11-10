package ru.netology.cards;

public class CreditCardBonus extends CreditCard {
    private double bonusPoints;

    public CreditCardBonus(double creditLimit) {
        super(creditLimit);
        this.bonusPoints = 0.0;
    }

    @Override
    public String getAvailableFundsInfo() {
        return super.getAvailableFundsInfo() + "\nБонусные баллы: " + bonusPoints;
    }

    @Override
    public boolean pay(double amount) {
        double amountToPay = amount;
        boolean isPaidWithBonus = false;

        if (bonusPoints > 0) {
            if (bonusPoints >= amountToPay) {
                bonusPoints -= amountToPay;
                System.out.println("Покупка полностью оплачена бонусными баллами.");
                return true;
            } else {
                amountToPay -= bonusPoints;
                System.out.println("Часть покупки оплачена бонусными баллами: " + bonusPoints + " рублей.");
                bonusPoints = 0;
                isPaidWithBonus = true;
            }
        }
        boolean success = super.pay(amountToPay);

        if (success && !isPaidWithBonus) {
            double earnedPoints = amount * 0.01;
            bonusPoints += earnedPoints;
            System.out.println("Вы заработали бонусные баллы: " + earnedPoints);
        }
        return success;
    }
}

