package quicksort;

import java.util.Random;

/**
 *
 * @author mangu3804
 */
public class Quicksort {

    /**
     * 
     */
    public static void main(String[] args) {
        int[] array = new int[1000];
        Random r = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(1000);
        }
        quicksort(array);

        System.out.println(binarySearch(array, 120));
    }
    
    /**
     * This version of the quicksort function is used to sort the entire array
     * @param array
     */
    public static void quicksort(int[] array) {
        qSort(array, 0, array.length-1);
    }
    
    /**
     * Sorts the array recursively in the specified area.
     * @param array The array to sort
     * @param bottom The bottom (inclusive) of area to sort
     * @param top The top (inclusive) of the area to sort
     */
    public static void qSort(int[] array, int bottom, int top) {
        
        // If the partition is more than one element long
        // partition it and recursively sort it
        if (top-bottom > 0) {
        
            // The pivot is arbitrarily the top element in the array
            
            // Used to figure out where to place the pivot
            // after partitioning is complete, and where to swap elements to
            // for them to be considered part of the partition
            int bottomOfPartition = top;
            
            // Partition the array //
            
            // Iterate through the array from the top to the bottom,
            // which is apparantly the convention for sorting
            for (int i = top; i > bottom-1; i--) {
                // If the current value is more than the pivot
                // (the array can be sorted in reverse order by switching the
                // greater than sign to a lesser than sign)
                if (array[i] > array[top]) {
                    // Swap the value into the bottom of the partition
                    // and update the postition of the bottom of the partition
                    bottomOfPartition--;
                    swap(array, bottomOfPartition, i);
                }
            }
            
            // Put the pivot into place
            swap(array, bottomOfPartition, top);
            
            // Recursivley sort the array //
            // Notice how the pivot is not included in the recursive calls
            
            // Bottom half
            qSort(array, bottom, bottomOfPartition-1);
            
            // Top half
            qSort(array, bottomOfPartition+1, top);
        
        }
        
    }
    
    /**
     * Swaps the position of two values in an array.
     * pre: An array and two valid indices are passed.
     * post: elements swapped.
     * @param array The array to switch the values in
     * @param index1 The index of the first value to be swapped
     * @param index2 The index of the second value to be swapped
     */
    public static void swap(int[] array, int index1, int index2) {
        int val1 = array[index1];
        array[index1] = array[index2];
        array[index2] = val1;
    }
    
    /**
     * Binary search over the entire array.
     * @param array
     * @param value 
     * @return the index
     */
    public static int binarySearch(int[] array, int value) {
        return bSearch(array, value, 0, array.length-1);
    }
    
    /**
     * Searches items array for goal.
     * pre: items is sorted from low to high
     * post : Position of goal has been returned, or -1 has been returned if
     * goal not found.
     * @param items
     * @param goal
     * @param start
     * @param end
     * @return 
     */
    public static int bSearch(int[] items, int goal, int start, int end) {
        if (start > end) {
            return(-1);
        } else {
            int mid = (start + end) / 2;
            if (goal < items[mid]) {
                return(mid);
            } else if (goal < items[mid]) {
                return(bSearch(items, goal, start, mid-1));
            } else {
                return(bSearch(items, goal, mid+1, end));
            }
        }
    }
}