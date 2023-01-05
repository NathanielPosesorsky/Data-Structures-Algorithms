/*
Student Name: Nathaniel Posesorsky
Student ID:260803332
 */

package CCCS315.CCCS315_Assignment.CCCS315_A2;

public class InsertionSort {
    /***
     * Method to sort array by swapping values between two adjacent elements
     * @param myArr Unsorted array of integers
     * @return New array of sorted elements
     */
    public int[] insertionSort(int[] myArr) {
        int[] a = new int[myArr.length]; // create a copy of the array so that we don't modify the given array
        for (int i = 0; i < myArr.length; i++) { // for every element i in array myArr,
            a[i] = myArr[i]; // copy value at position i from myArr to the new array a
        }

        for (int i = 0; i < a.length; i++) { // for every element i in array a,
            int currVal = a[i]; // assign the value of the array for that i to currVal
            int last = i - 1; // stores the location of the last position to later use for searching array

            while (last >= 0 && currVal < a[last]) { // while the current value is smaller than the last one
                a[last + 1] = a[last]; // replace the current value of the array at that index by the last value
                // now both elements contain the same value
                // after the while loop, the element to the left will be swapped with the smaller value stored in currVal
                last -= 1; // last decreases and once smaller than 0, exits while loop
            }
            // at this point, both elements of the array (last and current) have the same value

            // now that the element has been pushed to the right to allow for the current smaller value,
            a[last + 1] = currVal; // store to the element on the left the current value
        }

        return a; // return the newly sorted array a
    }
}
