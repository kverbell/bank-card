package ru.netology.cards;

public class CreditCardCashback extends CreditCard {

    private static final double CASHBACK_THRESHOLD = 2000;
    private static final double CASHBACK_PERCENTAGE = 0.05;

    public CreditCardCashback(double creditLimit) {
        super(creditLimit);
    }

    @Override
    public boolean pay(double amount) {
        double initialCreditBalance = getCreditBalance();
        boolean success = super.pay(amount);

        if (success && amount > CASHBACK_THRESHOLD) {
            double creditUsed = initialCreditBalance - getCreditBalance();

            if (creditUsed > 0) {
                double cashbackAmount = creditUsed * CASHBACK_PERCENTAGE;
                super.topUpBalance(cashbackAmount);
                System.out.println("Вы получили кэшбек: " + cashbackAmount + " рублей.");
            }
        }
        return success;
    }
}
