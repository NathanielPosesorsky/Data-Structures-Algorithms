/*
Student Name: Nathaniel Posesorsky
Student ID:260803332
 */
package CCCS315.CCCS315_Assignment;

import java.util.Random; // this creates random for the program
public class App {


    public static int minFinder(int[] arr){
        int index = 0;
        int min = arr[0]; // sets min to the first value of the array
        for(int i=0; i<arr.length;i++){ // for every i,
            if(arr[i]<min){ // if the value of the array at i is smaller than the min
                min = arr[i]; // min becomes the value at i
                index = i; // the index of that new value is stored to index
            }
        }
        return index; // returns the index of the min value
    }

    public static int minFinder_recursive(int[] arr,int min, int minIndex, int currentIndex){
        if(currentIndex == arr.length-1) // if you went through the entire array at the index is the last element
            return minIndex; // return the current minIndex
        if (min > arr[currentIndex]) { // if the min is bigger than the element of the array at the current index,
            min = arr[currentIndex]; // update the min to that new value
            minIndex = currentIndex; // update the minIndex to that new index
        }
        return minFinder_recursive(arr,min,minIndex,currentIndex+1); //recursive call using currentindex+1

    }

    public static void main(String[] args) throws Exception {
        int[] myArr = new int[100];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin=0;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max-min+1) + min; // storing random integers in an array
        }
        // here we check the last item of array to see if it is full:
        System.out.println(myArr[ myArr.length-1]); // printing last element, not the biggest or smallest but just the last one
        //now we find the minimum calling the function you wrote:
        //timestamp
        indexMin=minFinder(myArr);
        //timestamp

        // one - the other  : race!!
        System.out.println("The minimum is at location: "+indexMin+" The value is: "+myArr[indexMin]);

        indexMin=minFinder_recursive(myArr,myArr[0],0,0);
        System.out.println("The minimum is at location: "+indexMin+" The value is: "+myArr[indexMin]);
    }
}