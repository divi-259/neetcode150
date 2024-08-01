/*
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Link: https://leetcode.com/problems/minimum-window-substring/description/
*/

class Solution {
    public String minWindow(String s, String t) {
        // putting all chars of string t in the hashmap
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char ch : t.toCharArray()) {
            hmap.put(ch, hmap.getOrDefault(ch,0)+1);
        }
        int left = 0;
        int minlen = Integer.MAX_VALUE;
        int startIndex = 0; // start index of the answer substring
        int total = 0; // total number of matched character in string s

        for(int right=0; right<s.length(); right++) {
            char ch = s.charAt(right);
            if(hmap.containsKey(ch)) {
                hmap.put(ch, hmap.get(ch)-1);
                if(hmap.get(ch)==0)
                    total++; // all count matched for this char in string s
            }

            while(total==hmap.size()) {
                if(minlen > right-left+1) {
                    minlen = right-left+1;
                    startIndex = left; // start index for the substring
                }
                

                char start = s.charAt(left++);
                if(hmap.containsKey(start)) {
                    if(hmap.get(start)==0)
                        total--; // now we are one less on total match
                    hmap.put(start, hmap.get(start)+1); // restoring the hashmap with the t strings original count
                }


            }

            
        }
        return minlen > s.length() ? "" : s.substring(startIndex, startIndex+minlen);

    }
}