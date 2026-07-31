package questions.string;

public class find_first_index_of_occurrence_of_string {

    public static void main(String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    static int strStr(String haystack, String needle) {

        for(int i=0; i<=haystack.length() - needle.length(); i++){

            int j=0;

            while(j<needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }

            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }
    
}
