/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Link: https://leetcode.com/problems/permutation-in-string/description/

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length())
            return false;
        
        int count[] = new int[26];
        for(int i=0; i<s1.length(); i++) {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        int i = 0, j = s1.length();
        while(j<s2.length()) {
            if(checkZeros(count))
                return true;
            count[s2.charAt(j)-'a']--;
            count[s2.charAt(i)-'a']++;
            i++; j++;
        }
        if(checkZeros(count))
            return true;
        return false;
    }

    private boolean checkZeros(int count[]) {
        for(int i=0; i<count.length; i++) {
            if(count[i]!=0)
                return false;
        }
        return true;
    }
}
