package twoPointers;

import java.util.Arrays;

public class twoPointers {


    public static void main(String[] args) {

        char[]  arr = {'h', 'e', 'l', 'l', 'o'};
        char[] result = reverseCharArray2(arr);
        int [] nums = {2, 7, 11, 15};
        int target = 9;
        twoSumSorted(nums,target);
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

    public static int[] twoSumSorted(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum == target) {
                return new int[]{start, end};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }


}
