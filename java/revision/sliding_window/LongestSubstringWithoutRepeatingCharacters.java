package revision.sliding_window;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

         String s = "abcabcbb";

         substring(s);
        
    }
    
    static void substring(String s) {
        
        HashSet<Character> set = new HashSet<>();
        
        int start = 0;
        int maxlen = 0;
        
        for(int end = 0; end<s.length(); end++) {
            
            while(set.contains(s.charAt(end))) {
                
                set.remove(s.charAt(start));
                start++;
                
            }
            
            set.add(s.charAt(end));
            
            maxlen = Math.max(maxlen, end-start+1);
            
        }
        System.out.println(maxlen);
    }

}
