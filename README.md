# Приложение bank-card

Это приложение имитирует работу с кредитными и дебетовыми банковскими картами. Оно позволяет управлять денежными средствами на картах, копить бонусы и получать кэшбек.

## Как запустить

Приложение можно запустить следующими способами:

### Через IntelliJ IDEA

1. Откройте проект в IntelliJ IDEA.
2. Запустите файл с методом `main`, чтобы начать работу с приложением.
3. Приложение предложит выбрать тип карты для выполнения дальнейших операций.

### Через консоль (PowerShell)

Если вы хотите запустить приложение через консоль, нужно иметь установленный Java Runtime Environment (JRE) или Java Development Kit (JDK). 

1. Откройте PowerShell с правами администратора.
2. Чтобы запустить приложение `bank-card.jar`, выполните команду: 

<p style="text-align: center;">java -jar "путь к файлу\bank-card.jar"</p>

3. После этого вам будет предложено выбрать тип карты для выполнения дальнейших операций.

## О проекте

**Название**: bank-card  
**Тип**: Console Application (Java)

Приложение использует банковские карты с функциями пополнения баланса, оплаты и начисления бонусных баллов. Кэшбек начисляется за использование кредитных средств, а бонусные баллы — за успешные покупки.

### Структура проекта

Проект включает несколько классов карт и контроллеров. Каждая карта имеет свои особенности.
## Кредитные карты

1. **Кредитная карта с бонусами**
   
   Эта карта начисляет 1% от суммы каждой покупки в виде бонусных баллов.
   
   **Особенности**: 
     - Баллы начисляются за каждую покупку.
     - Баллы можно использовать для оплаты товаров или услуг на сумму, эквивалентную их количеству.

2. **Кредитная карта с кэшбеком**
   
   Эта карта начисляет 5% кэшбека с покупок свыше 2000 рублей, но только если были использованы кредитные средства.
   
   **Особенности**: 
     - Кэшбек начисляется только за расход кредитных средств, а не собственных.
     - Кэшбек начисляется только если сумма покупки превышает 2000 рублей.
     - Кэшбек зачисляется на карту и может быть использован для следующих покупок.

3. **Классическая кредитная карта**
   
   Обычная кредитная карта с кредитным лимитом. Без бонусов и кэшбека.
   
   **Особенности**: 
     - Имеет стандартные функции пополнения баланса и оплаты товаров.
     - Простой интерфейс без дополнительных начислений за покупки.

---

## Дебетовые карты

1. **Дебетовая карта с кэшбеком**
   
   Эта карта начисляет 5% кэшбека от общей суммы покупок, если сумма покупок за месяц превышает 5000 рублей.
   
   **Особенности**:
     - Кэшбек начисляется только если сумма покупок за месяц превышает 5000 рублей.
     - Кэшбек начисляется за все покупки, сделанные по карте, после выполнения условия.

2. **Дебетовая карта с накоплением**
   
   Эта карта начисляет 0,005% от суммы каждого пополнения в качестве бонусных баллов.
   
   **Особенности**:
     - Накопленные баллы можно использовать для оплаты товаров или перевести на основной баланс.
     - Баллы начисляются на сумму пополнений, а не на сумму покупок.

3. **Классическая дебетовая карта**
   
   Обычная дебетовая карта без кэшбека и бонусных баллов.
   
   **Особенности**:
     - Стандартная дебетовая карта с возможностью пополнения и снятия средств.
     - Без дополнительных функций для начисления баллов или кэшбека.

## Технологии

Проект использует следующие технологии:
- **Java 17**
- **Maven** для управления зависимостями и сборки проекта.
- **JUnit 5** для тестирования.

