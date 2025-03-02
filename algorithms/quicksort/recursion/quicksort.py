# Quick Sort Algorithm

# Quick Sort
def QuickSort(A, p, r):
    """Implementation of quick sort in python

    Args:
        A (int[]): array of integers representing the input
        p (int): starting index of the array
        r (int): last index of the array
    """
    # trmination condition
    if p < r:
        q = Partition(A, p, r)
        QuickSort(A, p, q - 1)
        QuickSort(A, q + 1, r)
    
    
# Partition
def Partition(A, l, h):
    # define random pivot (last one for now)
    pivot = A[h]
    i = l - 1
    
    # partition the array into the three regions as per the invariant
    for j in range(l, h):
        if A[j] <= pivot:
            i += 1
            temp = A[i]
            A[i] = A[j]
            A[j] = temp
    temp = A[i+1]
    A[i+1] = A[h]
    A[h] = temp
    return i+1
    
    
def test_case(arr):
    print("Array before sorting:", arr)
    # Call Quick Sort
    QuickSort(arr, 0, len(arr) - 1)
    print("Array after sorting: ", arr)
    print()

if __name__ == "__main__":
    # Test Case 1
    arr1 = [10, 7, 8, 9, 1, 5]
    print("Test Case 1:")
    test_case(arr1)

    # Test Case 2 (including negative and duplicate values)
    arr2 = [3, -1, 0, 3, -5, 10, -5, 3]
    print("Test Case 2:")
    test_case(arr2)

    # Test Case 3 (single element)
    arr3 = [42]
    print("Test Case 3:")
    test_case(arr3)

    # Test Case 4 (already sorted)
    arr4 = [-3, 0, 2, 5, 9, 12]
    print("Test Case 4:")
    test_case(arr4)
