/*
Problem: Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Link: https://leetcode.com/problems/trapping-rain-water/description/

*/

public int trap(int[] height) {
        
        int left = 0, right = height.length-1;
        int leftmax = height[left];
        int rightmax = height[right];
        int ans = 0;

        // we are determining how much water each block can hold
        while(left < right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);

            if(leftmax < rightmax) {
                if(leftmax-height[left] > 0)
                ans += leftmax-height[left];
                left++;
            }
            else {
                if(rightmax-height[right] > 0)
                ans+= rightmax-height[right]; 
                right--;
                }

        }
        return ans;