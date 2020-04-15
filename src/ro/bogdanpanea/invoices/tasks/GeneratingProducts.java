package ro.bogdanpanea.invoices.tasks;

import ro.bogdanpanea.invoices.POJOs.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratingProducts {
    List<Product> products = new ArrayList<>();
    String[] names = new String[48];

    public char generateRandomChar() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return c;
    }

    public boolean checkArray(String name) {
        for (String a : names) {
            if (name.equals(a)) {
                return false;
            }
        }
        return true;
    }

    public String generateRandomString() {
        String c = new StringBuilder().append(generateRandomChar()).append(generateRandomChar()).append(generateRandomChar()).append(generateRandomChar()).append(generateRandomChar()).toString();
        return c;
    }

    public double generateRandomPrice(double rangeMin, double rangeMax) {
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        randomValue = Math.round(randomValue * 10);
        randomValue = randomValue / 10;
        return randomValue;
    }

    public void generateProducts() {
        String s = new StringBuilder().append(generateRandomChar()).append(generateRandomChar()).append(generateRandomChar()).append(generateRandomChar()).append(generateRandomChar()).toString();
        names[0] = s;
        products.add(new Product(0, s, generateRandomPrice(0.1, 999.9)));
        int i = 1;
        while (i < 48) {
            boolean b = true;
            while (b) {
                String word = generateRandomString();
                if (checkArray(word)) {
                    b = false;
                    names[i] = word;
                    products.add(new Product(i, word, generateRandomPrice(0.1, 999.9)));
                }
            }
            i++;
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
