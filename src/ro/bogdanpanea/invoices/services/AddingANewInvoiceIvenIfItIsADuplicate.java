package ro.bogdanpanea.invoices.services;

import ro.bogdanpanea.invoices.POJOs.Invoice;

import java.util.List;

public class AddingANewInvoiceIvenIfItIsADuplicate {
    private Invoice invoice;
    private List<Invoice> invoices;

    public AddingANewInvoiceIvenIfItIsADuplicate(Invoice invoice, List<Invoice> invoices) {
        this.invoice = invoice;
        this.invoices = invoices;
    }

    public void addANewInvoice() {
        for (Invoice i : invoices) {
            if (invoice.equals(i)) {
                invoice.setDuplicate(true);
                invoice.setInvoiceNumber(invoices.size());
            }
        }
        invoices.add(invoice);
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
