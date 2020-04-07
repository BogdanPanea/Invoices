package ro.bogdanpanea.invoices.POJOs;

import java.time.LocalDateTime;
import java.util.List;

public class Invoice {
    private int invoiceNumber;
    private String seller;
    private List<Product> products;
    private double price;
    private LocalDateTime dueDate;
    private LocalDateTime payDate;

    public Invoice(int invoiceNumber, String seller, List<Product> products, double price, LocalDateTime dueDate, LocalDateTime payDate) {
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

    public String getSeller() {
        return seller;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getPayDate() {
        return payDate;
    }
}
