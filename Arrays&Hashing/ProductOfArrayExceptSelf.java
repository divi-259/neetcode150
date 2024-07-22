/*
Problem: Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Link: https://leetcode.com/problems/product-of-array-except-self/description/
*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = 1;
        for(int i=1; i<n; i++) {
            ans[i] = ans[i-1] * nums[i-1]; // we are leaving this current element when multiplying
        }

        int right = 1; 
        for(int i=n-1; i>=0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;

    }
}