package ro.bogdanpanea.invoices.POJOs;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Invoice {
    private int invoiceNumber;
    private Company seller;
    private List<Product> products;
    private double price;
    private LocalDate dueDate;
    private LocalDate payDate;
    private boolean duplicate;

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

    public Invoice(Invoice invoice) {
        this.invoiceNumber = invoice.getInvoiceNumber();
        this.seller = invoice.getSeller();
        this.products = invoice.products;
        this.price = invoice.getPrice();
        this.dueDate = invoice.dueDate;
        this.payDate = invoice.payDate;
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

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
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
                ", duplicate=" + duplicate +
                '}';
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.price, price) == 0 &&
                Objects.equals(seller, invoice.seller) &&
                Objects.equals(products, invoice.products) &&
                Objects.equals(dueDate, invoice.dueDate) &&
                Objects.equals(payDate, invoice.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seller, products, price, dueDate, payDate);
    }
}
