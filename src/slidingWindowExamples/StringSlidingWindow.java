package slidingWindowExamples;

import java.util.HashSet;
import java.util.Set;

public class StringSlidingWindow {

    public static void main(String[] args) {
        String s = "abcaabcbb";
        System.out.println(lengthOfLongestSubStringAtMostK(s,2));
    }

    public static int lengthOfLongestSubString(String str){
        int len = str.length();
        int left = 0;
        int maxLen =0;
        int[] freq = new int[128];

        for(int right=0;right<len;right++){
            char ch = str.charAt(right);
            freq[ch]++;

            while(freq[ch] > 1){
                freq[str.charAt(left)]--;
                left++;
            }

            maxLen =  Math.max(maxLen, right-left+ 1);
        }

        return maxLen;
    }

    public static int lengthOfLongestSubStringAtMostK(String str, int k){
        if (k == 0) return 0;
        int len = str.length();
        int left = 0;
        int maxLen =0, distinct = 0;
        int[] freq = new int[128];

        for(int right=0;right<len;right++){
            char ch = str.charAt(right);
            if(freq[ch] == 0) distinct++;
            freq[ch]++;

            // Shrink if distinct characters exceed k
            while(distinct > k){
                char lc = str.charAt(left);
                freq[lc]--;
                if(freq[lc] == 0) distinct--;
                left++;
            }

            maxLen =  Math.max(maxLen, right-left+ 1);
        }

        return maxLen;
    }

    public static boolean permutationInAnaGram(String str, String k){
        int len = str.length();
        int left = 0;
        int maxLen =0, count = k.length();
        int[] freq = new int[128];

        for(char ch : k.toCharArray()){
            freq[ch]++;
        }

        for(int right=0;right<len;right++){
            char ch = str.charAt(right);
            if(freq[ch] > 0) count--;
            freq[ch]--;

            // Shrink if distinct characters exceed k
            while(right - left + 1 > k.length()){
                char lc = str.charAt(left);
                if(freq[lc] >= 0) count++;
                freq[lc]++;
                left++;
            }

            if(count == 0)
                return true;
        }

        return false;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for(int right= 0; right< s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }




}
