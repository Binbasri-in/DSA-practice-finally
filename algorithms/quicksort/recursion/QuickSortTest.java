package algorithms.quicksort.recursion;
import java.util.Arrays;

public class QuickSortTest {

    /* 
     * Placeholder for Quick Sort function. 
     * Implement your Quick Sort logic here.
     */
    public static void quickSort(int[] arr, int left, int right) {
        // terminating condition: left is not left anymore :)
        if (left < right) {
            int q = partition(arr, left, right);
            quickSort(arr, left, q - 1);
            quickSort(arr, q + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        int temp = 0;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i+1;
    }



    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {10, 7, 8, 9, 1, 5};
        System.out.println("Test Case 1:");
        System.out.println("Array before sorting: " + Arrays.toString(arr1));
        quickSort(arr1, 0, arr1.length - 1);
        System.out.println("Array after sorting:  " + Arrays.toString(arr1));
        System.out.println();

        // Test Case 2 (including negative and duplicate values)
        int[] arr2 = {3, -1, 0, 3, -5, 10, -5, 3};
        System.out.println("Test Case 2:");
        System.out.println("Array before sorting: " + Arrays.toString(arr2));
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println("Array after sorting:  " + Arrays.toString(arr2));
        System.out.println();

        // Test Case 3 (single element)
        int[] arr3 = {42};
        System.out.println("Test Case 3:");
        System.out.println("Array before sorting: " + Arrays.toString(arr3));
        quickSort(arr3, 0, arr3.length - 1);
        System.out.println("Array after sorting:  " + Arrays.toString(arr3));
        System.out.println();

        // Test Case 4 (already sorted)
        int[] arr4 = {-3, 0, 2, 5, 9, 12};
        System.out.println("Test Case 4:");
        System.out.println("Array before sorting: " + Arrays.toString(arr4));
        quickSort(arr4, 0, arr4.length - 1);
        System.out.println("Array after sorting:  " + Arrays.toString(arr4));
    }
}
