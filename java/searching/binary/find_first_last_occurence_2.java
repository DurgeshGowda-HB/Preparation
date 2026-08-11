package searching.binary;
import java.util.Arrays;

public class find_first_last_occurence_2{
    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchrange(nums, target)));

    }

    public static int[] searchrange(int[] nums, int target) {

        int first = first(nums, target);
        int last = last(nums, target);

        return new int[]{first, last};

    }

    public static int first(int nums[], int target){

        int left = 0;
        int right = nums.length-1;
        int first = -1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(target == nums[mid]){
                first = mid;
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return first;
    }


    public static int last(int nums[], int target){

        int left = 0;
        int right = nums.length-1;
        int last = -1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(target == nums[mid]){
                last = mid;
                left = mid + 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return last;
    }


}