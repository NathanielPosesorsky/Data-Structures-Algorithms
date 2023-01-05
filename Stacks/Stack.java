/*
Student Name: Nathaniel Posesorsky
Student ID:260803332
 */

package CCCS315.CCCS315_Assignment.CCCS315_A2;

import java.util.Scanner;


public class CCCS315_A2_P1_INT_STACK {

    // class defining the properties of a Stack
    private static class IntStack {
        private final int BUFFER_SIZE = 5; // set BUFFER_SIZE to 5
        private Integer[] arr; // define Integer array

        public IntStack(){
            this.arr = new Integer[BUFFER_SIZE]; // initialize size of array
        }

        /***
         * Pushes the value to the Stack
         * @param value Integer value to push to the stack
         */
        public void push(int value){
            for(int i=0; i < this.arr.length; i++){ // for every element
                if(this.arr[i] == null){ // if the element of arr at i is null
                    this.arr[i] = value; // assigns value to the element of arr at i
                    return; // returns to ensure not to assign the same value twice
                }
            }
            // if the program reaches this line, the array is full
            // to push the value, we then need to increase the size first
            Integer[] arr2 = new Integer[arr.length + BUFFER_SIZE]; // define new array arr2 of size arr + BUFFER_SIZE
            for(int i = 0; i < this.arr.length; i++){ // for every element
                arr2[i] = this.arr[i]; // assign to arr2 the values from arr
            }
            arr2[this.arr.length] = value; // push to arr2 at arr.length the value
            this.arr = arr2; // set arr to be the same as arr2
        }

        /***
         * Removes the last value of the Stack
         * @return Returns the popped value
         */
        public Integer pop() {
            if(arr[0] == null) return null; // if the array is empty, return null
            for (int i = 0; i < this.arr.length - 1; i++) { // for every element except the last one,
                // if the element at i is not null AND the next element of the array is null
                if (this.arr[i] != null && this.arr[i + 1] == null) {
                    int value = arr[i]; // store value of arr at i
                    arr[i] = null; // nullify arr at i
                    return value; // return the value
                }
            }
            if(arr[arr.length-1] != null){ // if the value of the last element of the array is not null
                int value = arr[arr.length-1]; // store that value to int value
                arr[arr.length-1] = null; // then set the value of that element of the array to null
                return value; // return value
            }
            return null;
        }

        /***
         * Gives the size of the stack
         * @return Returns the size int
         */
        public int size(){
            if(arr[0] == null) return 0; // if the array is empty, return 0 for size
            int size = 0; // define int size as 0
            for (int i = 0; i < this.arr.length; i++) {// for every i,
                if(arr[i] != null) // check if the array at i contains a value other than null
                    size++;// if so, increase the size
            }
            return size; // return the size
        }

        /***
         * Overrides the toString method to print the Stack
         * @return Returns the printed Stack
         */
        @Override
        public String toString(){
            int size = this.size(); // define int size using the size method above

            if (size == 0) // if the array is size 0, return empty string
                return "Stack is empty!";
            else if (size == 1) // if the array has only 1 element, print it
                return "[ " + this.arr[0] + " ]";
            // if size is 2 or more
            String str = "";
            str+="[ ";
            for(int i = 0; i < size-1; i++){// for every i
                if(arr[i] != null) // if the element of the array at i is not null
                    str += arr[i] + ", "; // print that element of the array at i
            }
            str += arr[size-1] + " ]"; // print the last element of the array

            return str; // return the string containing all elements of the array
        }

    }

    public static void main(String[] args) {

        IntStack myStack = new IntStack(); // create Stack myStack
        Scanner s = new Scanner(System.in); // create Scanner object s


        do { // while user_Input is not z
            System.out.print("Please enter user input: "); // print
            String user_Input = s.nextLine(); // store scanner.nextLine to user_Input
            try { // try to convert user_Input to an int
                int value = Integer.parseInt(user_Input);
                myStack.push(value); // if it worked, push the value to myStack
                System.out.println(myStack.toString()); // print the stack
            } catch (Exception e) { // if converting the String to int did not work
                switch (user_Input) { // switch case on user_Input
                    case "+":  // if "+"
                        myStack = add(myStack); // add method on myStack
                        System.out.println(myStack.toString()); // print the stack
                        break;

                    case "*":  // if "*"
                        myStack = multiplication(myStack); // multiplication method on myStack
                        System.out.println(myStack); // print the stack
                        break;
                    case "P": // if "P"
                    case "p":  // if "p"
                        System.out.println(myStack.pop()); // pop the stack and print the value
                        System.out.println(myStack.toString()); // print the stack
                        break;
                    case "?":  // if "?"
                        System.out.println(myStack.toString()); // print the stack
                        break;
                    case "Z":
                    case "z":
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break; // unreachable statement added for clarity
                    default:
                        System.out.println("Invalid entry. Please try again.");
                        break;
                }
            }
        } while (true);
    }

    /***
     * Sum the recent two values of the stack and pushes the sum into the stack
     * @param st Stack of numbers to add up
     * @return Returns the added values in a Stack
     */
    public static IntStack add(IntStack st) {
        if(st.size() >= 2 ){ // if the stack size is bigger or equal to 2
            int firstValue = st.pop(); // store the recent value of the stack to a variable
            int secondValue = st.pop(); // store the second recent value of the stack to a variable
            int result = firstValue + secondValue; // store the sum of both values to variable result
            st.push(result); // push the result of the sum
            return st; // return the new stack
        }
        return st;
    }

    /***
     * multiplies the recent two values of the stack and push the result value to the stack
     * @param st Stack of numbers to add up
     * @return Returns the multiplied values in a Stack
     */
    public static IntStack multiplication(IntStack st) {
        if(st.size() >= 2 ){ // if the stack size is bigger or equal to 2
            int firstValue = st.pop(); // store the recent value of the stack to a variable
            int secondValue = st.pop(); // store the second recent value of the stack to a variable
            int result = firstValue * secondValue; // store the multiplication of both values to variable result
            st.push(result); // push the result of the multiplication
            return st; // return the new stack
        }
        return st;
    }
}