package ro.bogdanpanea.invoices.POJOs;

public class Product {
    private int productNumber;
    private String name;
    private double price;

    public Product(int productNumber, String name, double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
