package ro.bogdanpanea.invoices.services;

import ro.bogdanpanea.invoices.POJOs.Invoice;

import java.util.Comparator;

public class InvoiceComparatorByDueDate implements Comparator<Invoice> {
    // Used for sorting in ascending order of
    // due date name
    public int compare(Invoice a, Invoice b) {
        return a.getDueDate().compareTo(b.getDueDate());
    }
}

