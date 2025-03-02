#include <stdio.h>

// defintions
void quickSort(int numbers[], int low, int high);
int partition(int numbers[], int low, int high) ;
void printArray(int arr[], int size);

int main(void) {
    // Test case 1
    int arr1[] = {10, 7, 8, 9, 1, 5};
    int size1 = sizeof(arr1) / sizeof(arr1[0]);

    printf("Test Case 1:\n");
    printf("Array before sorting: ");
    printArray(arr1, size1);

    quickSort(arr1, 0, size1 - 1);

    printf("Array after sorting:  ");
    printArray(arr1, size1);
    printf("\n");

    // Test case 2 (including negative and duplicate values)
    int arr2[] = {3, -1, 0, 3, -5, 10, -5, 3};
    int size2 = sizeof(arr2) / sizeof(arr2[0]);

    printf("Test Case 2:\n");
    printf("Array before sorting: ");
    printArray(arr2, size2);

    quickSort(arr2, 0, size2 - 1);

    printf("Array after sorting:  ");
    printArray(arr2, size2);
    printf("\n");

    // Test case 3 (single element)
    int arr3[] = {42};
    int size3 = sizeof(arr3) / sizeof(arr3[0]);

    printf("Test Case 3:\n");
    printf("Array before sorting: ");
    printArray(arr3, size3);

    quickSort(arr3, 0, size3 - 1);

    printf("Array after sorting:  ");
    printArray(arr3, size3);
    printf("\n");

    // Test case 4 (already sorted)
    int arr4[] = {-3, 0, 2, 5, 9, 12};
    int size4 = sizeof(arr4) / sizeof(arr4[0]);

    printf("Test Case 4:\n");
    printf("Array before sorting: ");
    printArray(arr4, size4);

    quickSort(arr4, 0, size4 - 1);

    printf("Array after sorting:  ");
    printArray(arr4, size4);
    printf("\n");

    return 0;
}

/*
This function implements the Quick Sort algorithm to sort an array of integers in a descending order,
the Quick sort is the best sorting algorithm with a good average case running time of O(nlogn)

Input:
    unsigned int numbers[]: a pointer to an array of unsigned integers
    int low: the starting index of the given array
    int high: the last index in the array

Output:
    No retrun statement, but the array numbers[] undergo an in-place sorting where the algorithm
    rearrange the element into a descending ordered array of integers.
*/
void quickSort(int numbers[], int low, int high) {
    // Termination condition: low is greater than high
    if (low < high) {
        // perform the partition procedure (divide)
        int pivot = partition(numbers, low, high);

        // now for the two produced arrays, recursively perform the quick sort till all branches terminate
        quickSort(numbers, low, pivot - 1);
        quickSort(numbers, pivot + 1, high);
    }
}

/*
This function performs the partition procedure where we choose one pivot point and split the array into two
arrays with the ones which are less or equal are on the left, and the greater are on the right. all in-place.

Input:
    unsigned int numbers[]: a pointer to the array to be partitioned
    int low: the starting index of the array
    int high: the end index of the array

Output:
    Return an Integer with the index of the pivot point where that partitioning was based on.
*/
int partition(int numbers[], int low, int high) {
    int pivot = numbers[high];
    int i = low - 1;
    int temp = 0;

    for (int j = low; j < high; j++) {
        if (numbers[j] <= pivot) {
            i++;
            temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }
    temp = numbers[i+1];
    numbers[i+1] = numbers[high];
    numbers[high] = temp;
    return i+1;
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d,", arr[i]);
    }
}