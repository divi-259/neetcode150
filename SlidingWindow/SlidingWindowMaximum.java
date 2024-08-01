/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Link: https://leetcode.com/problems/sliding-window-maximum/description/ 
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

    int n = nums.length;
     int ans[] = new int[n-k+1];

    // dequeu is storing indices 
     Deque<Integer> dq = new ArrayDeque<>();
     int r = 0;
     int index = 0;

     while(r < n) {
        // so if the current element is greater than the ones already in the deque - keep removing the last element in the deque
        while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r] )
            dq.pollLast();
        dq.offer(r); // now add our good ol element here

        if(index > dq.peekFirst()) {
            dq.pollFirst(); // remove the numbers which are out of the window k
        }

        if(r+1>=k) { // we have a relevant window 
            ans[index++] = nums[dq.peekFirst()];
        }
        r++;
     }

    return ans;
    }
}
