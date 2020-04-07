package ro.bogdanpanea.invoices.services;

import java.util.ArrayList;
import java.util.List;

public class GeneratingCombinations {

    private List<int[]> combinationsList = new ArrayList<>();

    public List<int[]> generateCombinations(int n, int r) {


        int[] a = new int[r];
        // initialize first combination
        for (int i = 0; i < r; i++) {
            a[i] = i;
        }
        int i = r - 1; // Index to keep track of maximum unsaturated element in array
        // a[0] can only be n-r+1 exactly once - our termination condition!
        while (a[0] < n - r + 1) {
            // If outer elements are saturated, keep decrementing i till you find unsaturated element
            while (i > 0 && a[i] == n - r + i) {
                i--;
            }
            int[] b = a.clone();
            combinationsList.add(b);
            a[i]++;
            // Reset each outer element to prev element + 1
            while (i < r - 1) {
                a[i + 1] = a[i] + 1;
                i++;
            }
        }
        return combinationsList;
    }

    public List<int[]> getCombinationsList() {
        return combinationsList;
    }
}