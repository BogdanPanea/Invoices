package ro.bogdanpanea.invoices;


import ro.bogdanpanea.invoices.POJOs.Company;
import ro.bogdanpanea.invoices.POJOs.Invoice;
import ro.bogdanpanea.invoices.POJOs.Product;
import ro.bogdanpanea.invoices.services.AddingANewInvoiceIvenIfItIsADuplicate;
import ro.bogdanpanea.invoices.services.GeneratingCompanies;
import ro.bogdanpanea.invoices.services.GeneratingInvoices;
import ro.bogdanpanea.invoices.services.GeneratingProducts;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Subtask 1: Generate Companies
        System.out.println("Subtask 1: Generate Companies :");

        String[] names = {"a", "b", "c", "d", "e", "f", "g", "h"};
        GeneratingCompanies generatingCompanies = new GeneratingCompanies();
        generatingCompanies.generateCompanies(names);
        for (Company company : generatingCompanies.getCompanyList()) {
            System.out.println(company);
        }

        System.out.println("-----------------------------------------------------------------------------");

        //Subtask 2: Generate Products
        System.out.println("Subtask 2: Generate Products :");

        System.out.println("Subtask 2: Generate Products :");
        GeneratingProducts generatingProducts = new GeneratingProducts();
        generatingProducts.generateProducts();
        for (Product s : generatingProducts.getProducts()) {
            System.out.println(s);
        }

        System.out.println("-----------------------------------------------------------------------------");

        //Subtask 3: Generate Invoices
        System.out.println("Subtask 3: Generate Invoices :");

        GeneratingInvoices generatingInvoices = new GeneratingInvoices();
        generatingInvoices.setCompanies(generatingCompanies.getCompanyList());
        generatingInvoices.setProducts(generatingProducts.getProducts());
        generatingInvoices.generateInvoices();
        for (Invoice i : generatingInvoices.getInvoices()) {
            System.out.println(i);
        }

        System.out.println("-----------------------------------------------------------------------------");

        //Subtask 4: Equality vs. Identity
        System.out.println("Subtask 4: Equality vs. Identity :");

        Invoice invoiceDuplicate;
        List<Invoice> invoicesList;
        List<Invoice> newInvoicelist;

        invoicesList = generatingInvoices.getInvoices();
        invoiceDuplicate = new Invoice(invoicesList.get(25));

        AddingANewInvoiceIvenIfItIsADuplicate addingANewInvoiceIvenIfItIsADuplicate = new AddingANewInvoiceIvenIfItIsADuplicate(invoiceDuplicate, invoicesList);
        addingANewInvoiceIvenIfItIsADuplicate.addANewInvoice();
        for (Invoice i : addingANewInvoiceIvenIfItIsADuplicate.getInvoices()) {
            System.out.println(i);
        }

        System.out.println("-----------------------------------------------------------------------------");

        //Subtask 5: Ordered invoices
        System.out.println("Subtask 5: Ordered invoices :");



    }
}
