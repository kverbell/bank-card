package ru.netology.controllers;

import ru.netology.cards.BankCard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CardController {
    private final BankCard card;
    private final Scanner scanner = new Scanner(System.in);

    public CardController(BankCard card) {
        this.card = card;
    }

    public void start() {
        System.out.println("Введите команду:\n" +
                "topup — для пополнения счета\n" +
                "pay — для покупки\n" +
                "balance — для вывода информации о балансе\n" +
                "cardfunds — для вывода информации о средствах на карте\n" +
                "exit — для выхода");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            String[] parts = input.split(" ");

            if (parts.length > 1) {
                System.out.println("Команда не должна содержать дополнительных аргументов. Попробуйте снова.");
                continue;
            }

            String command = parts[0];

            switch (command) {
                case "topup":
                    handleTopUp();
                    break;
                case "pay":
                    handlePayment();
                    break;
                case "balance":
                    System.out.println(card.getBalance());
                    break;
                case "cardfunds":
                    System.out.println(card.getAvailableFundsInfo());
                    break;
                case "exit":
                    System.out.println("Завершение работы.");
                    return;
                default:
                    System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
    }

    private void handleTopUp() {
        while (true) {
            System.out.print("Введите сумму для пополнения: ");
            try {
                double topUpAmount = scanner.nextDouble();
                scanner.nextLine();
                if (topUpAmount <= 0) {
                    System.out.println("Сумма должна быть выше нуля. Попробуйте снова.");
                } else {
                    card.topUpBalance(topUpAmount);
                    System.out.println(card.getAvailableFundsInfo());
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Введите корректное число.");
                scanner.next();
            }
        }
    }

    private void handlePayment() {
        System.out.print("Введите сумму для покупки: ");

        while (true) {
            try {
                double payAmount = scanner.nextDouble();
                scanner.nextLine();
                if (payAmount <= 0) {
                    System.out.println("Сумма должна быть выше нуля. Попробуйте снова.");
                } else if (!card.pay(payAmount)) {
                    System.out.println("Недостаточно средств. Введите команду.");
                    break;
                } else {
                    System.out.println("Покупка прошла успешно.");
                    System.out.println("Доступные средства: " + card.getBalance() + " рублей. Введите cardfunds, чтобы узнать подробнее.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Введите корректное число.");
                scanner.nextLine();
            }
        }
    }
}
