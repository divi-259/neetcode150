/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Link: https://leetcode.com/problems/longest-repeating-character-replacement/description/
*/

public int characterReplacement(String s, int k) {
        
        // keeping the max value in the hindsight

        int arr[] = new int[26];
        int ans = -1;
        int max = -1;
        int i=0,j=0;

        while(j < s.length()) {
            arr[s.charAt(j)-'A']++;

            max = Math.max(max, arr[s.charAt(j)-'A']);

            // how many chars other than max freq
            while(j-i+1 - max > k) {
                arr[s.charAt(i)-'A']--; // keep removing 
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }

        return ans;