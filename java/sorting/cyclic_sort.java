package sorting;

import java.util.Arrays;

public class cyclic_sort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 7, 9, 1, 3, 6, 8};
        int[] ans = cyclic(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] cyclic(int[] arr){
        // if the value is not on it's correct index and place it in correct 
        // array must range of 1 to N or 0 to N not in random range
        int i=0;
        while(i<arr.length){
            int correct_index = arr[i]-1;
            if(arr[i] != arr[correct_index]){

                int temp = arr[i];
                arr[i] = arr[correct_index];
                arr[correct_index] = temp;

            }else{
                i++;
            }
        }
        return arr;
    }
    
}
