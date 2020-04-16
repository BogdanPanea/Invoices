package ro.bogdanpanea.invoices.tasks;

import ro.bogdanpanea.invoices.Exceptions.InvoiceException;
import ro.bogdanpanea.invoices.POJOs.Invoice;
import ro.bogdanpanea.invoices.services.CheckingSearchTextValidity;
import ro.bogdanpanea.invoices.services.RankAndNumberComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextSearch {
    private String text;
    private List<Invoice> invoicesTextMatch = new ArrayList<>();
    private List<Invoice> invoices;

    public TextSearch(String text, List<Invoice> invoices) {
        this.text = text;
        this.invoices = invoices;
    }

    public void filterInvoices() throws InvoiceException {
        CheckingSearchTextValidity checkingSearchTextValidity = new CheckingSearchTextValidity(text);
        if (checkingSearchTextValidity.checkTextLength()) {
            int numberOfMatches = 0;
            for (int i = 0; i < invoices.size(); i++) {
                String name[] = invoices.get(i).getSeller().getName().split(" ");
                for (int j = 0; j < name.length; j++) {
                    if (name[j].contains(text)) {
                        Invoice addInvoice = new Invoice(invoices.get(i));
                        addInvoice.setRank(j);
                        invoicesTextMatch.add(addInvoice);
                        numberOfMatches++;
                        break;
                    }
                }
                if (numberOfMatches == 10) {
                    break;
                }
            }

            Collections.sort(invoicesTextMatch, new RankAndNumberComparator());
        }
    }

    public List<Invoice> getInvoicesTextMatch() {
        return invoicesTextMatch;
    }
}
