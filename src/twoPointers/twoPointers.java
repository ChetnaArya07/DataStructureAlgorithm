package twoPointers;

import java.util.Arrays;

public class twoPointers {


    public static void main(String[] args) {

        char[]  arr = {'h', 'e', 'l', 'l', 'o'};
        char[] result = reverseCharArray2(arr);

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
