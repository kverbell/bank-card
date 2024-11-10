package ru.netology;

import ru.netology.cards.BankCard;
import ru.netology.controllers.CardController;
import ru.netology.controllers.CardFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип карты:\n" +
                "credit — для кредитной карты\n" +
                "debit — для дебетовой карты");
        String cardType = scanner.next();
        BankCard card = CardFactory.createCard(cardType, scanner);
        CardController controller = new CardController(card);
        controller.start();
    }
}