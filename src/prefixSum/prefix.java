package prefixSum;

public class prefix {

    public static void main(String[] args) {

        int[]  arr = {2,1,5,1,3,2,6};
        int maxSum = sumOfNumbers(arr,3,5);

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

}
