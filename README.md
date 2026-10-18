# Assignment 4 — Facade Pattern

Dauletkyzy Bayan, SE-2523

## Project description

This Java application demonstrates the Facade pattern using online
order processing. The example uses one product: headphones priced
at 2000 KZT per item.

OrderFacade coordinates stock reservation, payment, delivery,
and confirmation messages. Main uses only the facade.

## Classes

- Main: starts the demonstration.
- OrderFacade: coordinates the order processing steps.
- InventoryService: reserves, releases, and sells stock.
- PaymentProcessor: processes payments and refunds.
- ShippingService: checks addresses and stores delivery records.
- NotificationService: creates and stores confirmation messages.

## Requirements and running

Use JDK 17. No external libraries are required.

Open the project in IntelliJ IDEA, select JDK 17,
and run the main method in src/Main.java.

## Demonstration

The OrderFacade constructor accepts initial stock,
initial customer balance, and delivery availability.

The placeOrder method accepts quantity, customer name, and address.

- Successful order: stock and balance decrease.
- Insufficient stock: payment is not attempted.
- Insufficient balance: reserved stock is released.
- Delivery failure: payment is refunded and stock is released.
- Invalid order input: the order is rejected before stock or money changes.

## Scope

This is an in-memory simulation for one customer balance and one
product type. It does not connect to a bank, delivery company,
or messaging service. Data resets when the program restarts.