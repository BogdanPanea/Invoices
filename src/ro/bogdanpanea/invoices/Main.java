package ro.bogdanpanea.invoices;


import ro.bogdanpanea.invoices.Exceptions.InvoiceException;
import ro.bogdanpanea.invoices.POJOs.Company;
import ro.bogdanpanea.invoices.POJOs.Invoice;
import ro.bogdanpanea.invoices.POJOs.Product;
import ro.bogdanpanea.invoices.services.InvoiceComparatorByDueDate;
import ro.bogdanpanea.invoices.tasks.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Subtask 1: Generate Companies
        System.out.println("Subtask 1: Generate Companies :");

        String[] names = {"Romanian", "Bulgarian", "Serbian", "European", "Food", "Electricity", "Incorporated", "Construction"};
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

        OrderedInvoices orderedInvoices = new OrderedInvoices(invoicesList);
        orderedInvoices.generateOrderedLists();
        orderedInvoices.sortPendingInvoices();
        orderedInvoices.sortPaidInvoices();

        System.out.println("\n" + "Subtask 5: Pending invoices :" + "\n");

        for (Invoice i : orderedInvoices.getPendingList()) {
            System.out.println(i);
        }

        System.out.println("\n" + "Subtask 5: Paid invoices :" + "\n");

        for (Invoice i : orderedInvoices.getPaidList()) {
            System.out.println(i);
        }

//        List<Invoice> sortedInvoicesList=new ArrayList<Invoice>();
//        sortedInvoicesList.addAll(orderedInvoices.getPendingList()); // add first arraylist
//        sortedInvoicesList.addAll(orderedInvoices.getPaidList()); // add Second arraylist
//
//        for (Invoice i : sortedInvoicesList) {
//            System.out.println(i);
//        }


        System.out.println("-----------------------------------------------------------------------------");

        //Subtask 6: Text Search
        System.out.println("Subtask 6: Text Search :");

        TextSearch textSearch = new TextSearch("ood", invoicesList);
        try {
            textSearch.filterInvoices();
        } catch (InvoiceException e) {
            System.out.println(e.getMessage());
        }

        for (Invoice i : textSearch.getInvoicesTextMatch()) {
            System.out.println(i);
        }

        System.out.println("-----------------------------------------------------------------------------");

        //Subtask 7: Editing
        System.out.println("Subtask 7: Editing :");

        System.out.println("\n" + "Invoice before payment :" + "\n");

        System.out.println(invoicesList.get(0));

        InvoicePay invoicePay = new InvoicePay(invoicesList.get(0));
        invoicePay.payInvoice();

        System.out.println("\n" + "Invoice after payment :" + "\n");

        System.out.println(invoicesList.get(0));

//        for (Invoice i : invoicesList) {
//            System.out.println(i);
//        }

        System.out.println("-----------------------------------------------------------------------------");

        //Subtask 8: Persistency
        System.out.println("Subtask 8: Persistency :");




    }
}
