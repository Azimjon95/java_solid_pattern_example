Java Best Practices for Beginners - SOLID Principles

Introduction

This repository provides examples of good and bad coding practices following the SOLID principles in Java. SOLID is a set of five design principles that help create maintainable, scalable, and flexible software.

The current examples cover:

Single Responsibility Principle (SRP)

Open-Closed Principle (OCP)

Single Responsibility Principle (SRP)

The SRP states that a class should have only one reason to change, meaning it should have only one responsibility.

❌ Bad Practice (Violating SRP)

class BadReportGenerator {
    public void generateReport() {
        System.out.println("Generating Report...");
    }
    public void saveToFile() {
        System.out.println("Saving Report to File...");
    }
}

🔴 This class is handling both report generation and file saving, violating SRP.

✅ Good Practice (Following SRP)

class ReportGenerator {
    public String generateReport() {
        return "Generated Report";
    }
}

class ReportSaver {
    public void saveToFile(String report) {
        System.out.println("Saving Report: " + report);
    }
}

🟢 Responsibilities are separated: ReportGenerator handles report creation, and ReportSaver manages saving.

Open-Closed Principle (OCP)

The OCP states that a class should be open for extension but closed for modification. This means we should be able to add new functionality without modifying existing code.

❌ Bad Practice (Violating OCP)

class BadDiscountCalculator {
    public double calculateDiscount(String type, double price) {
        if (type.equals("STUDENT")) {
            return price * 0.9; // 10% discount
        } else if (type.equals("SENIOR")) {
            return price * 0.8; // 20% discount
        }
        return price;
    }
}

🔴 Adding a new discount type requires modifying the class, which can introduce bugs.

✅ Good Practice (Following OCP)

interface DiscountStrategy {
    double applyDiscount(double price);
}

class StudentDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}

class SeniorDiscount implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.8;
    }
}

class PriceCalculator {
    public double calculatePrice(double price, DiscountStrategy strategy) {
        return strategy.applyDiscount(price);
    }
}

🟢 New discount types can be added without modifying existing code by implementing the DiscountStrategy interface.

Contributing

Feel free to contribute by improving examples or adding more SOLID principles!

License

This project is open-source and free to use.

📌 Next Steps: More examples covering Liskov Substitution Principle (LSP), Interface Segregation Principle (ISP), and Dependency Inversion Principle (DIP) will be added soon!
