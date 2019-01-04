import java.util.Arrays;
import java.util.Random;

public class MaxSpanProblem {

    public static void main(String[] args) {
        Random r = new Random();

        int[] testArray = new int[10];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = r.nextInt(5) + 1;
        }
        System.out.println(Arrays.toString(testArray));

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            maxSpan(testArray);
        }

        long stopTime = System.currentTimeMillis();
        long runTime = stopTime - startTime;
        System.out.println(maxSpan(testArray));
        System.out.printf("Run time maxSpan: %d milliseconds%n", runTime);

    }

    public static int maxSpan(int[] nums) {
        int span = 0;

        for (int i = 0; i < nums.length; i++) {

            // set j to the last index of nums
            int j = nums.length -1;

            // if the distance from the current number to the end of the array
            // is less than the span, we can exit the loop early
            if (j - i < span) {
                return span;
            }

            // look for nums[i] while moving backwards through the array
            while (nums[i] != nums[j]) {
                j--;
            }

            int maxSoFar = j - i + 1;

            if ( maxSoFar > span) {
                span = maxSoFar;
            }
        }

        return span;
    }

    public static int maxSpanNoEarlyExit(int[] nums) {
        int span = 0;

        for (int i = 0; i < nums.length; i++) {

            // set j to the last index of nums
            int j = nums.length -1;

            // look for nums[i] while moving backwards through the array
            while (nums[i] != nums[j]) {
                j--;
            }

            int maxSoFar = j - i + 1;

            if ( maxSoFar > span) {
                span = maxSoFar;
            }
        }

        return span;
    }

}
