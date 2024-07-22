/*
Problem: Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Link: https://leetcode.com/problems/encode-and-decode-strings/

*/
class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append('@').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i =0;
        while(i<str.length()) {
            int j = i;
            while(str.charAt(j)!='@') {
                j++;
            }
            int count = Integer.valueOf(str.substring(i,j));
            list.add(str.substring(j+1, j+count+1));
            i = j + count + 1;
            
        }
        return list;
    }
}