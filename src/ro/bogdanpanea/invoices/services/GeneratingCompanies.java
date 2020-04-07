package ro.bogdanpanea.invoices.services;

import ro.bogdanpanea.invoices.POJOs.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratingCompanies {


    private List<Company> companyList = new ArrayList<>();

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void generateCompanies(String[] words) {

        GeneratingCombinations generatingCombinations = new GeneratingCombinations();
        generatingCombinations.generateCombinations(8, 3);
        List<int[]> generatetCombinations = generatingCombinations.getCombinationsList();
        for (int counter = 0; counter < 25; counter++) {
            companyList.add(new Company(words[generatetCombinations.get(counter)[0]] + " " + words[generatetCombinations.get(counter)[1]] + " " + words[generatetCombinations.get(counter)[2]], generatePhoneNumber()));
        }
    }

    public long generatePhoneNumber() {
        Random r = new Random();
        int low = 111111111;
        int high = 999999999;
        long result = r.nextInt(high - low) + low;

        return result * 100000;
    }
}