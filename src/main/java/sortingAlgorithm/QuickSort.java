package sortingAlgorithm;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] {1, 8, 3, 9, 4, 5, 7};
        quickSort(array);

        for (int j : array) {
            System.out.println(j);
        }
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex){
            return;
        }

        // Randomize the Pivot selection
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        int leftPointer = getLeftPointer(array, lowIndex, highIndex, pivot);
        quickSort(array, lowIndex, leftPointer - 1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    private static int getLeftPointer(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        // Loop till the both pointer converge at the same location
        while(leftPointer < rightPointer) {
            // Check the left side of the pivot
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Check the left side of the pivot
            while (array[rightPointer] >= pivot && rightPointer > leftPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int leftPointer, int rightPointer) {
        int temp;
        temp = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = temp;
    }
}
