package ro.bogdanpanea.invoices.tasks;

import ro.bogdanpanea.invoices.POJOs.Invoice;

import java.time.LocalDate;

public class InvoicePay {

    private Invoice invoice;

    public InvoicePay(Invoice invoice) {
        this.invoice = invoice;
    }

    public void payInvoice() {
        LocalDate date = LocalDate.now();
        invoice.setPaidDate(date);
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
