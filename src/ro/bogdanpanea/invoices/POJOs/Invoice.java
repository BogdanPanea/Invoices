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
    private LocalDate paidDate;
    private boolean duplicate;
    private int rank;

    public Invoice(int invoiceNumber, Company seller, List<Product> products, LocalDate dueDate, LocalDate paidDate) {
        this.invoiceNumber = invoiceNumber;
        this.seller = seller;
        this.products = products;
        this.dueDate = dueDate;
        this.paidDate = paidDate;

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
        this.paidDate = invoice.paidDate;
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

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public int getRank() {
        return rank;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", seller=" + seller +
                ", products=" + products +
                ", price=" + price +
                ", dueDate=" + dueDate +
                ", paidDate=" + paidDate +
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
                Objects.equals(paidDate, invoice.paidDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seller, products, price, dueDate, paidDate);
    }
}
