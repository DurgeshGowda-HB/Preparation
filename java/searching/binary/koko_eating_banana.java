package searching.binary;

public class koko_eating_banana {

public static void main(String[] args) {



    }

    public int minEatingSpeed(int[] piles, int h) {


        int left = 1;
        int right = Integer.MIN_VALUE; 
        for(int num : piles){
            if(num > right){
                right = num;
            }
        }
        

        while(left < right){

            int mid = left + (right - left) /2;

            int hour = 0;

        for(int num : piles){
            hour += (num + mid - 1)/mid;
        }

        if(hour <= h){
            right = mid;
        }else{
            left = mid + 1;
        }

        }
        return left;
    }
    
}