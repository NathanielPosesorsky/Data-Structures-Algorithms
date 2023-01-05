/*
Student Name: Nathaniel Posesorsky
 */


import java.util.LinkedList;
import java.util.Random; // this creates random for our program

public class App {

    public static void main(String[] args) throws Exception {
        int numItem = 10; // This decide how big you array is
        int[] myArr = new int[numItem];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }

        //Initial Array
        System.out.print("Initial Array:");
        System.out.print("[");
        for(int i=0;i<myArr.length;i++){
            if(i != myArr.length-1) System.out.print(myArr[i] + ",");
            else System.out.println(myArr[i]+"]");
        }
        System.out.println();

        // THE FOLLOWING IS FOR BUBBLE SORT
        int[] myBubbleSortedArray;
        double startTime = System.nanoTime();
        myBubbleSortedArray = bubbleSort(myArr);
        double endTime = System.nanoTime();
        double duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to sort using BubbleSort is " + duration);

        System.out.print("Bubble Sorted Array:");
        System.out.print("[");
        for(int i=0;i<myBubbleSortedArray.length;i++){
            if(i != myBubbleSortedArray.length-1) System.out.print(myBubbleSortedArray[i] + ",");
            else System.out.println(myBubbleSortedArray[i]+"]");
        }
        // END OF BUBBLE SORT

        // THE FOLLOWING IS FOR QUICK SORT
        int[] myQuickSortedArray = myArr;
        startTime = System.nanoTime();
        quickSort(myQuickSortedArray,0,myQuickSortedArray.length-1);
        endTime = System.nanoTime();
        duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to sort using QuickSort is " + duration);

        System.out.print("Quick Sorted Array:");
        System.out.print("[");
        for(int i=0;i<myQuickSortedArray.length;i++){
            if(i != myQuickSortedArray.length-1) System.out.print(myQuickSortedArray[i] + ",");
            else System.out.println(myQuickSortedArray[i]+"]");
        }
        // END OF QUICK SORT

        // THE FOLLOWING IS FOR RADIX SORT
        int[] myRadixSortedArray;
        startTime = System.nanoTime();
        myRadixSortedArray = radixSort(myArr);
        endTime = System.nanoTime();
        duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to sort using RadixSort is " + duration);

        System.out.print("Radix Sorted Array:");
        System.out.print("[");
        for(int i=0;i<myRadixSortedArray.length;i++){
            if(i != myRadixSortedArray.length-1) System.out.print(myRadixSortedArray[i] + ",");
            else System.out.println(myRadixSortedArray[i]+"]");
        }
        // END OF RADIX SORT
    }

    /***
     * Method to sort an integer array based on low and high indices
     * @param myArr integer array to sort
     * @param low low index
     * @param high high index
     */
    public static void quickSort(int[] myArr, int low, int high){

        if(low >= high) return;// code will run recursively until this if statement's condition is met

        int comparedValue = myArr[high]; // value we will be comparing array elements to. For now, assign to the value of high index

        int left = low; // initialize int variable left that will go from left to right
        int right = high;// initialize int variable right that will go from right to left

        while(left < right){ // while left is smaller than right
            // while the value of the array at the left index is smaller than comparedValue
            // and that left is smaller than right
            while(myArr[left] <= comparedValue && left<right){
                left++; // increase left so that it moves from left to right.
                // it will move from left to right until it reaches a value bigger than comparedValue
            }
            // while the value of the array at the right index is bigger than comparedValue
            // and that left is smaller than right
            while(myArr[right] >= comparedValue && left<right){
                right--;// decrease right so that it moves from right to left.
                // it will move from right to left until it reaches a value smaller than comparedValue
            }

            // at this line, left has a value bigger than comparedValue and is found on the left
            // right has a value smaller than compareValue and is found on the right
            // the two values are then swapped to ensure that the array has values smallest to biggest from left to right
            int temp = myArr[left]; // stores the value of myArr at left to variable temp
            myArr[left] = myArr[right]; // assigns to myArr at left the value of myArr at right
            myArr[right] = temp; // assigns to myArr at right the value that was stored into temp

            // the process then repeats until the left and right point to the same element
        }
        // once left and right point to the same element, left is swapped with the comparedValue
        int temp = myArr[left]; // stores the value of myArr at left to variable temp
        myArr[left] = myArr[high]; // assigns to myArr at left the value of myArr at high (comparedValue)
        myArr[high] = temp; // assigns to myArr at high the value that was stored into temp

        // By doing the swap, at this line now, all the values smaller than the comparedValue are on the left of it,
        // and all the values bigger than the comparedValue are on the right of it

        //However, the values on the left and right of the comparedValue are not necessarily in order from smallest to biggest
        // To ensure that these values get sorted, the method is called recursively twice
        // Once for the left array from the comparedValue
        quickSort(myArr,low,left-1);
        // And once for the right array from the comparedValue
        quickSort(myArr,left+1,high);

        // Each recursive call will sort the arrays from smallest to biggest until low is bigger or equal to high

    }


    /***
     * Method to sort an integer array by bucketing and sorting based on digits of the values
     * @param myArr integer array to be sorted
     * @return sorted integer array
     */
    public static int[] radixSort(int[] myArr){

        // Finding the maxValue in the array
        int maxValue = myArr[0]; // set max value to the first value of the array
        for(int i=1; i < myArr.length; i++){ // for every i in the array after the first value,
            // checks if the value at i is bigger than the maxValue. If so, update the maxValue
            if(myArr[i]>maxValue) maxValue = myArr[i];
        }

        // Finding the length of the maxValue
        int maxValueLength = 0; // set maxValue length to 0 for now
        while(maxValue != 0){ // while the maxValue is not equal to 0
            maxValue = maxValue/10; // divide the value by zero to remove one character
            maxValueLength++; // increase the maxValue Length
            // once maxValue is equal to zero, the maxValueLength will be accurate to the number of digits in the maxValue
        }

        //Radix loop
        for(int i=0; i<maxValueLength;i++){ // loop for number of maximum number of digits in every number
            LinkedList<Integer>[] myList = new LinkedList[10]; // initialize integer linked list as bucket for each possible digit
            for (int k : myArr) { // iterate through every element of the array and insert the element into correct bucket
                int currentItemKey = getKey(k, i); // key determines which bucket it goes into

                LinkedList<Integer> currentKeyList = myList[currentItemKey]; //list of values per key (0 to 9)
                if (currentKeyList == null) { // if the currentKeyList is null (nothing in the bucket already)
                    currentKeyList = new LinkedList<Integer>(); // create the bucket
                    myList[currentItemKey] = currentKeyList; // adds new bucket to list of buckets
                }
                currentKeyList.add(k);// assign the value to the bucket

            }
            LinkedList<Integer> flattenedList = new LinkedList<>(); // new list to rearrange the various buckets into ordered 1-Dimensional list

            for (LinkedList<Integer> integers : myList) { // goes through buckets in order,
                if(integers != null){ // if bucket exists, add all values in order that they were encountered in initial sorting
                    flattenedList.addAll(integers);
                }
            }
            // convert list to array to return through method
            for (int j = 0; j < flattenedList.size(); j++) {
                myArr[j] = flattenedList.get(j);
            }
        }
        return myArr;
    }

    /***
     * Method to isolate the current digit
     * @param num integer value
     * @param index integer index
     * @return current digit
     */
    private static int getKey(int num, int index){
        return (int) ((num % (Math.pow(10,index+1)))/(Math.pow(10,index)));

    }

    /***
     * Method to sort an integer array by swapping adjacent values
     * @param myArr integer array
     * @return sorted integer array
     */
    public static int[] bubbleSort(int[] myArr){
        // for every k in myArr.length
        for(int k=0;k<myArr.length; k++){
            // for every i in myArr.length-k-1, traverse through the array and swap values until the biggest value is all the way to the right
            for(int i=0; i<myArr.length-k-1; i++){
                try{
                    // compare the value of myArr at i with the value to its right at i+1
                    // if the value at i+1 is smaller than the value at i,
                    if(myArr[i]>myArr[i+1]){
                        int temp = myArr[i+1]; // store the value at i+1 to variable temp
                        myArr[i+1] = myArr[i]; // store the value at i to the element of the array at i+1
                        myArr[i] = temp; // store the value of temp to the array at i, effectively swapping both values
                    }
                } catch (NullPointerException e){ // if exception reached, myArr[i+1] = null, so this iteration is finished
                    break;
                }
            }
            // After the first iteration of the for loop for k=0, the biggest value is now all the way to the right
            // That said, the second for loop deducts k from the array length
            // to ensure that the second-biggest value will be directly on the left of the biggest one
            // This will repeat until the array is sorted from smallest to biggest from left to right
        }
        return myArr; // return the sorted array
    }

}
