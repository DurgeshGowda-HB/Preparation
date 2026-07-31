package questions.string;

public class longest_common_prefix {

    public static void main(String[] args) {

        String[] words = {"flower","flow","flight"};

        String ans = longest_common_prefix(words);
        System.out.println(ans);
        
    }

    public static String longest_common_prefix(String[] strs) {

        String prefix = strs[0];

        for(int i=1; i<strs.length; i++){

            while(!strs[i].startsWith(prefix)){

                prefix = prefix.substring(0, prefix.length()-1);
                
                if(prefix.isEmpty()){
                    return "";
                }
            }

        }
        return prefix;
    }
}
        