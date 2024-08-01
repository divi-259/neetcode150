/*
Given a string s, find the length of the longest 
substring
 without repeating characters.
 Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/

public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> hset = new HashSet<>();
        int i=0, j=0;
        int max = 0;

        while(j<s.length()) {
            char ch = s.charAt(j);
            while (hset.contains(ch))
            {
                hset.remove(s.charAt(i++));
            }
            hset.add(ch);
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;

    }