# Shopping-cart-system


Shopping Cart Console Application (Java)

A console-based Shopping Cart system built using Java with proper Low-Level Design structure.

This project demonstrates Object-Oriented Programming concepts including encapsulation, abstraction, polymorphism, interfaces, and layered architecture.

---

Features

* View available products
* Add products to cart
* Remove products from cart
* View cart with total bill
* Checkout functionality
* Multiple payment methods (UPI / Card)
* Menu-driven console interface

---

Project Structure

ShoppingCartProject
└── src
├── model
│     ├── Product.java
│     └── CartItem.java
├── service
│     ├── CartService.java
│     └── PaymentService.java
├── payment
│     ├── Payment.java
│     ├── UpiPayment.java
│     └── CardPayment.java
└── Main.java

---

OOPS Concepts Used

Encapsulation
Abstraction
Interface
Polymorphism
Separation of Concerns
Layered Architecture (Model, Service, Payment)

---

Technologies Used

Java
Command Line Interface
VS Code / Kiro AI
JDK 8 or above

---

How To Run (Windows PowerShell)

1. Navigate to project folder

cd ShoppingCartProject
cd src

2. Compile

javac model*.java service*.java payment*.java Main.java

If wildcard does not work:

javac model\Product.java model\CartItem.java service\CartService.java service\PaymentService.java payment\Payment.java payment\UpiPayment.java payment\CardPayment.java Main.java

3. Run

java Main

---

Sample Console Flow

1. View Products
2. Add Product
3. Remove Product
4. View Cart
5. Checkout
6. Exit

---

Learning Outcome

This project was built to practice Low-Level Design, Java OOPS fundamentals, package structure, interface implementation, and basic system design.

---

Future Improvements

Add Discount Strategy Pattern
Add User Login system
Add Inventory Management
Convert to Spring Boot Web Application
Connect to Database

---

Author

Joshika S
Java and System Design Learner


