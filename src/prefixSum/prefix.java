package prefixSum;

public class prefix {

    public static void main(String[] args) {

        int[]  arr = {1,7,3,6,5,6};
        int maxSum = findPivotIndex(arr);

    }

    public static int sumOfNumbers(int[] nums, int start, int end) {

        if (start < 0 || end < 0 || start >= nums.length || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int result;
        if (start == 0) {
            result = prefix[end];
        } else {
            result = prefix[end] - prefix[start - 1];
        }

        System.out.println("Sum from index " + start + " to " + end + " is: " + result);
        return result;
    }

    public static int findPivotIndex(int[] nums) {

        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int totalSum = prefix[n - 1];

        for (int i = 0; i < n; i++) {
            int leftSum = (i == 0) ? 0 : prefix[i - 1];
            int rightSum = totalSum - prefix[i];

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }


}
