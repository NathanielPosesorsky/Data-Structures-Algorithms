/*
Student Name: Nathaniel Posesorsky
Student ID:260803332
 */

package CCCS315.CCCS315_Assignment.CCCS315_A2;

public class SelectionSort {
    /***
     * Method to sort array by swapping values between the previous minimum value and the newly found minimum value
     * @param myArr Unsorted array of integers
     * @return New array of sorted elements
     */
    public int[] selectionSort(int[] myArr) {
        int[] a = new int[myArr.length]; // create a copy of the array so that we don't modify the given array
        for (int i = 0; i < myArr.length; i++) { // for every element i in array myArr,
            a[i] = myArr[i]; // copy value at position i from myArr to the new array a
        }

        for (int currPos = 0; currPos < a.length; currPos++) { // for every position in the array a
            int minValPos = currPos; //store the current position as the minimum value position for the time being

            // for every position i AFTER the current position in the array,
            for (int i = currPos+1; i < a.length; i++) {
                // verify if the value at that position is smaller than the current minimum value
                if (a[i] < a[minValPos])// if so,
                    // update the position of the minimum value to the position of the new smaller value found
                    minValPos = i;
            }

            // in order to swap both values,
            // store the new minimum value found to the temporary variable minVal
            int minVal = a[minValPos];
            // Then, take the previous smallest value and store it at the location where the new smallest value was found
            a[minValPos] = a[currPos];
            // Once that is done, store the new minimum value at the location of the previous minimum value
            a[currPos] = minVal;
        }

        return a; // return the newly sorted array a

    }

}
