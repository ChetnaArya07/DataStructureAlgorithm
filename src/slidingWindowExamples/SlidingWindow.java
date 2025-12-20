package slidingWindowExamples;

import java.util.Arrays;

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


    public static void main(String[] args) {
        /*
        int[]  arr = {2,1,5,1,3,2,6};
        int k = 3;
        int maxSum = maximumSumOfArraySizeK(arr,k);

        System.out.println("maxSum for subArray length "+k+" is : "+maxSum);

        int[] arr1 = {1, 3, 2, 6, -1, 4, 1, 8, 2};
         k = 5;

        double[] average = averageOfSubArraySizeK(arr1,k);

        System.out.println("average for subArray length "+k+" is : "+ Arrays.toString(average));
        */

        int[]  arr = {2,1,5,1,3,2,6};
        int k = 2;
        int maxSum = minimumSumOfArraySizeK(arr,k);

        System.out.println("minimum sum for subArray length "+k+" is : "+maxSum);

    }
}
