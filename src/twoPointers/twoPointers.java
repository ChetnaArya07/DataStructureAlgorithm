package twoPointers;

import java.util.Arrays;

public class twoPointers {


    public static void main(String[] args) {

        char[]  arr = {'h', 'e', 'l', 'l', 'o'};
        char[] result = reverseCharArray2(arr);

    }

    public static char[] reverseCharArray(char[] nums) {
        char[] revArray = new char[nums.length];
       int start = 0;
       int end = nums.length-1;
        while(start <= end){
            revArray[start] = nums[end];
            revArray[end] = nums[start];
            start++;
            end--;
        }

        System.out.println("reverse char array : "+ Arrays.toString(revArray));
        return revArray;
    }

    public static char[] reverseCharArray2(char[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            char ch = nums[start];
            nums[start] = nums[end];
            nums[end] = ch;
            start++;
            end--;
        }

        System.out.println("reverse char array : "+ Arrays.toString(nums));
        return nums;
    }


}
