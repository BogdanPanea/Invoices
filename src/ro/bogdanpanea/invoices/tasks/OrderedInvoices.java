package ro.bogdanpanea.invoices.tasks;

import ro.bogdanpanea.invoices.POJOs.Invoice;
import ro.bogdanpanea.invoices.services.InvoiceComparatorByDueDate;
import ro.bogdanpanea.invoices.services.InvoiceComparatorByPaidDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderedInvoices {

    private List<Invoice> invoiceList;
    private List<Invoice> pendingList = new ArrayList<>();
    private List<Invoice> paidList = new ArrayList<>();

    public OrderedInvoices(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public List<Invoice> getPendingList() {
        return pendingList;
    }

    public List<Invoice> getPaidList() {
        return paidList;
    }

    public void generateOrderedLists() {
        for (Invoice i : invoiceList) {
            if (i.getPaidDate() == null) {
                pendingList.add(i);
            } else {
                paidList.add(i);
            }
        }
    }

    public void sortPendingInvoices() {
        Collections.sort(pendingList, new InvoiceComparatorByDueDate());
    }

    public void sortPaidInvoices() {
        Collections.sort(paidList, new InvoiceComparatorByPaidDate());
    }

}

