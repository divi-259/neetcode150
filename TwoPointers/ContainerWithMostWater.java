/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Link: https://leetcode.com/problems/container-with-most-water/description/

*/

public int maxArea(int[] heights) {
        
        int max = 0;

        int left = 0, right = heights.length-1;

        while(left < right) {

            int ans = (right-left)*(Math.min(heights[left], heights[right]));
            max = Math.max(ans, max);

            if(heights[left] > heights[right])
                right--;
            else left++;
        }

        return max;
