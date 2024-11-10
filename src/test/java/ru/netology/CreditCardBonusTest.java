package ru.netology;

import ru.netology.cards.CreditCardBonus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardBonusTest {
    private CreditCardBonus bonusCard;

    @BeforeEach
    public void setUp() {
        bonusCard = new CreditCardBonus(10000);
    }

    @Test
    public void testBonusPoints() {
        bonusCard.topUpBalance(5000);
        assertEquals(15000, bonusCard.getBalance(), "Баланс должен быть 15000");

        boolean success = bonusCard.pay(2000);
        assertTrue(success, "Оплата должна быть успешной");
        assertEquals(13000, bonusCard.getBalance(), "Баланс после оплаты должен быть 13000");

        String expectedInfo = "Ваш баланс: 13000.0 рублей.\n" +
                "Кредитные средства: 10000.0 рублей.\n" +
                "Собственные средства: 3000.0 рублей.\n" +
                "Бонусные баллы: 20.0";
        assertEquals(expectedInfo, bonusCard.getAvailableFundsInfo(), "Ожидается корректная информация о балансе и бонусах");

        bonusCard.pay(1000);
        assertEquals(12020, bonusCard.getBalance(), "Баланс должен быть 12020, часть оплачена 20 баллами");
    }
}