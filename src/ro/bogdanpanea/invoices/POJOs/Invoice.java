package ro.bogdanpanea.invoices.POJOs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Invoice {
    private int invoiceNumber;
    private Company seller;
    private List<Product> products;
    private double price;
    private LocalDate dueDate;
    private LocalDate payDate;

    public Invoice(int invoiceNumber, Company seller, List<Product> products, LocalDate dueDate, LocalDate payDate) {
        this.invoiceNumber = invoiceNumber;
        this.seller = seller;
        this.products = products;
        this.dueDate = dueDate;
        this.payDate = payDate;

        double totalPrice = 0.0;
        for (Product p : products) {
            totalPrice += p.getPrice();
        }

        totalPrice = Math.round(totalPrice * 10);
        totalPrice = totalPrice / 10;

        this.price = totalPrice;
    }

    public Invoice(int invoiceNumber, Company seller, List<Product> products, double price, LocalDate dueDate, LocalDate payDate) {
        this.invoiceNumber = invoiceNumber;
        this.seller = seller;
        this.products = products;
        this.price = price;
        this.dueDate = dueDate;
        this.payDate = payDate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public Company getSeller() {
        return seller;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", seller=" + seller +
                ", products=" + products +
                ", price=" + price +
                ", dueDate=" + dueDate +
                ", payDate=" + payDate +
                '}';
    }
}
