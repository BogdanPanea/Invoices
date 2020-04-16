package ro.bogdanpanea.invoices.services;

import ro.bogdanpanea.invoices.Exceptions.InvoiceException;

public class CheckingSearchTextValidity {

    private String text;

    public CheckingSearchTextValidity(String text) {
        this.text = text;
    }

    public boolean checkTextLength() throws InvoiceException {
        if (text.length() < 3) {
            throw new InvoiceException("Text should contain at least 3 characters !");
        }
        return true;
    }
}
