/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Link: https://leetcode.com/problems/longest-consecutive-sequence/description/
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num : nums)
            hset.add(num);

        int maxlen = 0, currlen = 0;
        for(int i=0; i<nums.length; i++) {
            if(!hset.contains(nums[i]-1))
            {
                currlen = 0;
                int num = nums[i];
                // nums[i] is the start of the consecutive series
                while(hset.contains(num++)) {
                    currlen++;
                }
                maxlen = Math.max(currlen, maxlen);
            }
        }

        return maxlen;


    }
}
