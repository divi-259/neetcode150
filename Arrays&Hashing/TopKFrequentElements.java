/*
Problem: Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Link: https://leetcode.com/problems/top-k-frequent-elements/description/


*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums) {
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->hmap.get(b)-hmap.get(a));
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            pq.offer(entry.getKey());
        }

        int ans[] = new int[k];
        int ind = 0;
        while(!pq.isEmpty() && ind<k) {
            ans[ind] = pq.remove();
            ind++;
        }

        return ans;


    }
}