package ro.bogdanpanea.invoices.POJOs;

public class Company {
    private int companyId;
    private String name;
    private long phoneNumber;

    public Company(int companyId, String name, long phoneNumber) {
        this.companyId = companyId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
