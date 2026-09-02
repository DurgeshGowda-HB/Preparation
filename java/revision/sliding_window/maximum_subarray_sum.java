package revision.sliding_window;

public class maximum_subarray_sum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;

        System.out.println(maxi(arr, target));
    }

// 	MINIMUM SIZE
// → condition: sum >= target
// → need minimum length
// → valid → update → shrink


// MAXIMUM SIZE
// → condition: sum <= target
// → need maximum length
// → invalid → shrink → valid → update


// Both use sliding window.
// Main difference = when we update.

    static int maxi(int[] arr, int target) {

        int start = 0;
        int sum = 0;
        int min_length = Integer.MAX_VALUE;

        for (int end = 0; end < arr.length; end++) {

            sum += arr[end];

            while (sum >= target) {

                min_length = Math.min(min_length, end - start + 1);

                sum -= arr[start];
                start++;
            }
        }

        return min_length;
    }

    static int mini(int[] arr, int target) {

        int start = 0;
        int sum = 0;

        int max_length = 0; // min_length → max_length

        for (int end = 0; end < arr.length; end++) {

            sum += arr[end];

            while (sum > target) {

                sum -= arr[start];
                start++;
            }

            max_length = Math.max(max_length, end - start + 1);
        }

        return max_length; 
    }
}
