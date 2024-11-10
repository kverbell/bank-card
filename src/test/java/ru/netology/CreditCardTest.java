package ru.netology;

import ru.netology.cards.CreditCard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void testTopUpBalance() {
        CreditCard card = new CreditCard(10000);
        card.topUpBalance(5000);
        assertEquals(15000, card.getBalance(), "Баланс должен быть 15000");
    }

    @Test
    void testPay() {
        CreditCard card = new CreditCard(10000);
        card.topUpBalance(2000);
        card.pay(1000);
        assertEquals(11000, card.getBalance(), "Баланс должен быть 11000");
    }
}

