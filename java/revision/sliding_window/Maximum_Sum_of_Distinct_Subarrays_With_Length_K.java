package revision.sliding_window;
import java.util.HashMap;
public class Maximum_Sum_of_Distinct_Subarrays_With_Length_K {

    public static void main(String[] args) {

        int[] arr = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(maximumsubarraysum(arr, k));
        
    }

    public static long maximumsubarraysum(int[] nums, int k){

        HashMap<Integer, Integer> map = new HashMap<>();

        int start =0;
        long sum = 0;
        long maxsum = 0;

        for(int end=0; end<nums.length; end++){

            // creating the first window sum
            sum += nums[end];
            map.put(nums[end], map.getOrDefault(nums[end], 0) +1);

            // if size become > k then remove the starting 
            if( end - start + 1 > k){
                sum -=nums[start];

                // getting the frequency if only one remove completely or remove one by one
                int count = map.get(nums[start]);
                if(count == 1){
                    map.remove(nums[start]);
                }else{
                    map.put(nums[start], count -1);
                }

                start++;
            }

             // Window must have exactly k elements
            // map.size() == k means all k elements are distinct
            if(end - start + 1 == k && map.size() == k){
                maxsum = Math.max(maxsum ,sum);
            }


        }
        return maxsum;
    }
    
}
