package ru.netology;

import ru.netology.cards.DebitCard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DebitCardTest {
    private DebitCard debitCard;

    @BeforeEach
    public void setUp() {
        debitCard = new DebitCard();
    }

    @Test
    public void testTopUpBalance() {
        debitCard.topUpBalance(2000);
        assertEquals(2000, debitCard.getBalance(), "Баланс должен быть 2000");
    }

    @Test
    public void testPay() {
        debitCard.topUpBalance(5000);
        boolean success = debitCard.pay(3000);
        assertTrue(success, "Оплата должна быть успешной");
        assertEquals(2000, debitCard.getBalance(), "Баланс должен быть 2000");

        success = debitCard.pay(3000);
        assertFalse(success, "Оплата должна быть отклонена из-за недостаточности средств");
    }
}
