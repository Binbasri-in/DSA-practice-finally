package java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // first solution
        // char[] sChar = s.toCharArray();
        // char[] tChar = t.toCharArray();
        // int ls = s.length();
        // int lt = t.length();
        // quicksort(sChar, 0, ls-1);
        // quicksort(tChar, 0,lt-1);

        // return Arrays.equals(sChar, tChar);

        // second solution
        Map<Character, Integer> count = new HashMap<>();
        int ls = s.length();
        int lt = t.length();

        if (ls != lt) return false;

        for (int i = 0; i < ls; i++) {
            char sCurrent = s.charAt(i);
            char tCurrent = t.charAt(i);

            count.put(sCurrent, count.getOrDefault(sCurrent, 0) + 1);
            count.put(tCurrent, count.getOrDefault(tCurrent, 0) - 1);
        }

        for (int val : count.values()) {
            if (val != 0) return false;
        }

        return true;
    }

    public static void quicksort(char[] arr, int low, int high) {
        if (low < high) {
            int q = partition(arr, low, high);
            quicksort(arr, low, q-1);
            quicksort(arr, q+1, high);
        }
    }

    public static int partition(char[] arr, int low, int high) {
        char pivot = arr[high];
        int i = low-1;
        char temp;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        temp = arr[i+1];
        arr[i+1] = pivot;
        arr[high] = temp;

        return i+1;
    }
}
