package ru.netology;

import ru.netology.cards.DebitCardCashback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DebitCardCashbackTest {
    private DebitCardCashback cashbackCard;

    @BeforeEach
    public void setUp() {
        cashbackCard = new DebitCardCashback();
    }

    @Test
    public void testCashback() {
        cashbackCard.topUpBalance(6000);
        assertEquals(6000, cashbackCard.getBalance(), "Баланс должен быть 6000");

        boolean success = cashbackCard.pay(3000);
        assertTrue(success, "Оплата должна быть успешной");
        assertEquals(3000, cashbackCard.getBalance(), "Баланс должен быть 3000");

        assertEquals(0, cashbackCard.getBalance() - 3000, "Кэшбек не должен быть начислен");

        success = cashbackCard.pay(2500);
        assertTrue(success, "Оплата должна быть успешной");

        assertEquals(625, cashbackCard.getBalance(), "Баланс должен быть 625 после начисления кэшбека");
    }
}
