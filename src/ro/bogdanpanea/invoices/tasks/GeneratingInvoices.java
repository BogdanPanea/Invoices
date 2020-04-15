package ro.bogdanpanea.invoices.tasks;

import ro.bogdanpanea.invoices.POJOs.Company;
import ro.bogdanpanea.invoices.POJOs.Invoice;
import ro.bogdanpanea.invoices.POJOs.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratingInvoices {

    private List<Invoice> invoices = new ArrayList<>();
    private List<Company> companies;
    private List<Product> products;

    public void generateInvoices() {
        LocalDate paidDate;
        for (int i = 0; i < 50; i++) {
            int j = i % 24;
            if (i % 4 == 0) {
                paidDate = null;
            } else {
                paidDate = generatePayDate();
            }
            invoices.add(new Invoice(i, getCompanyById(j, companies), generateProductsList(1, 3, 0, 47), generateDueDate(), paidDate));
        }
    }

    public LocalDate generateDueDate() {
        LocalDate date = LocalDate.now();
        return date.plusDays(gerenateRandomInt(1, 5));
    }

    public LocalDate generatePayDate() {
        LocalDate date = LocalDate.now();
        return date.minusDays(gerenateRandomInt(0, 4));
    }

    public List<Product> generateProductsList(int minRange, int maxRange, int minRangeProductId, int maxRangeProductId) {
        List<Product> invoiceProducts = new ArrayList<>();
        int i = gerenateRandomInt(minRange, maxRange);
        for (int j = 0; j < i; j++) {
            invoiceProducts.add(getProductById(gerenateRandomInt(minRangeProductId, maxRangeProductId), products));
        }
        return invoiceProducts;
    }

    public int gerenateRandomInt(int minRange, int maxRange) {
        Random r = new Random();
        return r.nextInt((maxRange - minRange) + 1) + minRange;
    }

    public Company getCompanyById(int id, List<Company> companies) {
        for (Company c : companies) {
            if (id == c.getCompanyId()) {
                return c;
            }
        }
        return null;
    }

    public Product getProductById(int id, List<Product> products) {
        for (Product p : products) {
            if (id == p.getProductNumber()) {
                return p;
            }
        }
        return null;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
