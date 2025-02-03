/*
 * Java Best Practices for Beginners - SOLID Principles
 * This repository demonstrates good and bad coding practices using SOLID principles.
 */

// Example: Single Responsibility Principle (SRP)

// BAD Practice: A class handling multiple responsibilities
class BadReportGenerator {
    public void generateReport() {
        System.out.println("Generating Report...");
    }
    public void saveToFile() {
        System.out.println("Saving Report to File...");
    }
}

// GOOD Practice: Separate concerns into different classes
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

// Example: Open-Closed Principle (OCP)

// BAD: Modifying existing code for new features
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

// GOOD: Extend functionality without modifying existing code
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
