import java.util.Arrays;

/**
 * Name: Anjola Aina
 *
 * This class contains the methods needed to run the Counting Sort algorithm.
 * These methods are:
 *
 * countingSort(int[]) -> void
 * printSortedArray(int[]) -> void
 * findLargestElementInArray(int[]) -> int
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] anArray = {2, 5, 3, 0, 2, 3, 0, 3};
        System.out.println("Unsorted array: " + Arrays.toString(anArray));
        countingSort(anArray);
    } // main

    /**
     * Sorts an unsorted integer array using the Counting Sort algorithm.
     * @param A the array to be sorted
     */
    public static void countingSort(int[] A) {
        int largestElement = findLargestElementInArray(A);
        int[] sortedArray = new int[A.length];
        int[] auxiliaryArray = new int[largestElement + 1];
        for (int i = 0; i < auxiliaryArray.length; i++) {
            auxiliaryArray[i] = 0;
        }
        for (int j = 0; j < A.length; j++) {
            auxiliaryArray[A[j]] += 1;
        }
        for (int i = 1; i < auxiliaryArray.length; i++) {
            auxiliaryArray[i] = auxiliaryArray[i] + auxiliaryArray[i - 1];
        }
        for (int j = A.length - 1; j >= 0; j--) {
            sortedArray[auxiliaryArray[A[j]] - 1] = A[j];
            auxiliaryArray[A[j]] -= 1;
        }
        printSortedArray(sortedArray);
    } // countingSort

    /**
     * Prints the sorted array in a specific format.
     * @param sortedArray
     */
    private static void printSortedArray(int[] sortedArray) {
        System.out.print("Sorted array: [");
        for (int i = 0; i < sortedArray.length - 1; i++) {
            System.out.print(sortedArray[i] + ", ");
        }
        System.out.print(sortedArray[sortedArray.length - 1] + "]");
    } // printSortedArray

    /**
     * Finds the largest element in an integer array.
     * @param array the current array
     * @return - the largest element in the array
     */
    private static int findLargestElementInArray(int[] array) {
        int largest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    } // findLargestElementInArray

} // class