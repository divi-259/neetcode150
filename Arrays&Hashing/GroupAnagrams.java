/*
Problem: Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Link: https://leetcode.com/problems/group-anagrams/description/

*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Base case
        if(strs==null || strs.length==0)
            return new ArrayList<>();

        Map<String, List<String>> hmap = new HashMap<>();
        for(String s: strs) {
            char arr1[] = s.toCharArray();
            Arrays.sort(arr1);
            String keyst = String.valueOf(arr1);
            if(!hmap.containsKey(keyst))
                hmap.put(keyst, new ArrayList<>());
            hmap.get(keyst).add(s);
        }

        return new ArrayList<>(hmap.values());
        
    }
}