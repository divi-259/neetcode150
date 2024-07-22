/*
Problem Statement: Given an integer array nums, return true if any value appears at least twice in the array, 
and return false if every element is distinct.

ProblemLink: https://leetcode.com/problems/contains-duplicate/description/

*/


class Solution {
    public boolean containsDuplicate(int[] nums) {        
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(hset.contains(nums[i])) 
                return true;
            else hset.add(nums[i]);
        }
        return false;
    }
}

// Space = O(n) , Time = O(n)