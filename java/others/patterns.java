package others;

public class patterns{
    public static void main(String[] args) {
        pattern1(5);
        pattern2(4);
        pattern3(5);
    }

    // here just star pattern printing 
    static void pattern1(int n){
        for(int row=1; row<=n; row++){
            for(int cal=1; cal<=n; cal++){
                System.out.print("* ");
            }
            System.out.println();
        }

        //O/P
        // * * * * * 
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *

    }


    static void pattern2(int n){
        for(int row=1; row<=n; row++){
            for(int cal=1; cal<=row; cal++){
                System.out.print("* ");
            }
            System.out.println();
         }

        //O/P
        // *
        // * *
        // * * *
        // * * * *
    }

    static void pattern3(int n){
        for(int row=1; row<=n; row++){
            for(int cal=n; cal>=row; cal--){
                System.out.print("* ");
            }
            System.out.println();
         }

        //O/P
        // * * * *
        // * * *
        // * *
        // *
    }
    
}
