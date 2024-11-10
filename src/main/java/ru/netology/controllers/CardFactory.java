package ru.netology.controllers;

import ru.netology.cards.CreditCardCashback;
import ru.netology.cards.DebitCard;
import ru.netology.cards.DebitCardCashback;
import ru.netology.cards.DebitCardSavings;
import ru.netology.cards.BankCard;
import ru.netology.cards.CreditCard;
import ru.netology.cards.CreditCardBonus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CardFactory {
    public static BankCard createCard(String cardType, Scanner scanner) {
        BankCard card = null;

        while (card == null) {
            switch (cardType.toLowerCase()) {
                case "credit":
                    double creditLimit = setCreditLimit(scanner);
                    card = createCreditCard(scanner, creditLimit);
                    break;
                case "debit":
                    card = createDebitCard(scanner);
                    break;
                default:
                    System.out.println("Неизвестный тип карты. Попробуйте снова.");
                    System.out.print("Введите тип карты (credit или debit): ");
                    cardType = scanner.next();
                    break;
            }
        }
        return card;
    }

    private static double setCreditLimit(Scanner scanner) {
        double creditLimit = 0;

        while (true) {
            System.out.print("Введите лимит кредитной карты от 10 000 до 100 000 рублей: ");

            try {
                creditLimit = scanner.nextDouble();
                if (creditLimit >= 10000 && creditLimit <= 100000) {
                    break;
                } else {
                    System.out.println("Некорректный лимит. Пожалуйста, введите значение от 10 000 до 100 000.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите корректное число.");
                scanner.next();
            }
        }
        return creditLimit;
    }

    private static BankCard createCreditCard(Scanner scanner, double creditLimit) {
        int choice = 0;

        while (true) {
            System.out.println("Выберите тип кредитной карты:\n" +
                    "1 — Кредитная карта с бонусами 1% от суммы каждой покупки\n" +
                    "2 — Кредитная карта с кэшбеком 5% от суммы покупки свыше 2000 рублей на кредитные средства\n" +
                    "3 — Классическая кредитная карта");

            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Неверный выбор. Пожалуйста, выберите правильный номер: 1, 2 или 3.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите номер от 1 до 3.");
                scanner.next();
            }
        }

        return switch (choice) {
            case 1 -> new CreditCardBonus(creditLimit);
            case 2 -> new CreditCardCashback(creditLimit);
            case 3 -> new CreditCard(creditLimit);
            default -> null;
        };
    }

    private static BankCard createDebitCard(Scanner scanner) {
        int choice = 0;

        while (true) {
            System.out.println("Выберите тип дебетовой карты:\n" +
                    "1 — Дебетовая карта с кэшбеком 5% от покупок, если общая сумма покупок выше 5000 рублей\n" +
                    "2 — Дебетовая карта с накоплением 0,005% от суммы пополнений\n" +
                    "3 — Классическая дебетовая карта");

            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Неверный выбор. Пожалуйста, выберите правильный номер: 1, 2 или 3.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Пожалуйста, введите номер от 1 до 3.");
                scanner.next();
            }
        }

        return switch (choice) {
            case 1 -> new DebitCardCashback();
            case 2 -> new DebitCardSavings();
            case 3 -> new DebitCard();
            default -> null;
        };
    }
}
