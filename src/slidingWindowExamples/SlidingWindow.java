package slidingWindowExamples;

import java.util.*;

public class SlidingWindow {

    public static int maximumSumOfArraySizeK(int[] arr, int k) {
        if (arr == null || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int len = arr.length;
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];

        maxSum = sum;
        for (int i = 0; i < len - k; i++) {
            sum += arr[k + i] - arr[i];
            maxSum = Math.max(maxSum, sum);

        }
    return maxSum;
    }

        public static double[] averageOfSubArraySizeK(int[] arr, int k){
            if (arr == null || k <= 0 || k > arr.length) {
                throw new IllegalArgumentException("Invalid input");
            }

            int len = arr.length;
            double ark = Double.parseDouble(String.valueOf(k));
            double sum = 0;
            double avg = 0.0;
            double[] average = new double[len-k+1];

            for(int i=0;i<k;i++) {
                sum += arr[i];
            }

            avg = sum/ark;
            average[0] = avg;
            for(int i=0;i<len-k;i++){
                sum += arr[k+i] -arr[i];
                avg = sum/ark;
                average[i+1] = avg;
            }


            return average;

    }

    public static int minimumSumOfArraySizeK(int[] arr, int k) {
        if (arr == null || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int len = arr.length;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];

        minSum = sum;
        for (int i = 0; i < len - k; i++) {
            sum += arr[k + i] - arr[i];
            minSum = Math.min(minSum, sum);

        }
        return minSum;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        Set<Integer> set = new HashSet<>();
        for(int right = 0; right < nums.length ; right++ ){
            if(set.contains(nums[right])){
               if(Math.abs(right-left)<= k)
                   return true;
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
        }
        return false;
    }

    /*Concise*/




    public boolean containsNearbyDuplicateUsingMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left =0, minLen = Integer.MAX_VALUE, sum=0;
        for(int right =0; right< nums.length ; right++){
            sum += nums[right];

            while(sum >= target){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }



    public static void main(String[] args) {

        int[]  arr = {1,1,1};
        int k = 3;

        System.out.println(minSubArrayLen(k,arr));

    }
}
