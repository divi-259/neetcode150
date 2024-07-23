/*
Problem: Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Link: https://leetcode.com/problems/top-k-frequent-elements/description/
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums) {
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        } // O(n)

        // we are maintianing the heap size as k only, so as to not increase the time complexity
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->hmap.get(a)-hmap.get(b));
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            pq.offer(entry.getKey());
            if(pq.size() > k)
                pq.remove();
        }

        int ans[] = new int[k];
        int ind = 0;
        while(!pq.isEmpty()) {
            ans[ind] = pq.remove();
            ind++;
        }

        return ans;
    }
}

// Time complexity  = O(nlogk) - as the size of the heap will always remain below k

// Qucik Select - k times - n = O(kn)