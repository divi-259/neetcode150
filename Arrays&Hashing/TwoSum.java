/*
Problem: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Link: https://leetcode.com/problems/two-sum/description/
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(hmap.containsKey(target-nums[i])) {
                return new int[]{hmap.get(target-nums[i]), i};
            }
            hmap.put(nums[i],i);
        }

        return new int[]{-1,-1};

    }
}