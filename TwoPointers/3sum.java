/*
Problem: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Link: https://leetcode.com/problems/3sum/description/

*/

public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0)
                break; // no point of going forward as all the sums will be more than 0

            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            
            
            int j = i+1;
            int k = nums.length-1;

            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];

                if(sum > 0) {
                    k--;
                }
                else if(sum < 0) {
                    j++;
                }
                else {
                    ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++; k--;
                    while(j<k && nums[j]==nums[j-1]) // another way to avoid duplicates
                        j++;
                }
            }
        }

        return ans;