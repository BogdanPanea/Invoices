package ro.bogdanpanea.invoices.services;

import ro.bogdanpanea.invoices.POJOs.Invoice;

import java.util.Comparator;

public class RankAndNumberComparator implements Comparator<Invoice> {
    // Used for sorting in ascending order of
    // rank name
    public int compare(Invoice a, Invoice b) {
        int c;
        c = a.getRank() - b.getRank();
        if (c == 0) {
            c = a.getInvoiceNumber() - b.getInvoiceNumber();
        }
        return c;
    }

}
