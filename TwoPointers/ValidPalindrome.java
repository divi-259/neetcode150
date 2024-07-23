/*

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Link: https://leetcode.com/problems/valid-palindrome/description/
*/

class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if((ch>=65 && ch<=90) || (ch>=97 && ch<=122) || (ch>=48 && ch<=57))
                sb.append(Character.toLowerCase(ch));
        }
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        if(str1.equals(str2))
            return true;
        else return false;

    }
}