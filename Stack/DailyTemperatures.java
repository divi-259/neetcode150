class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int ans[] = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1; i<temp.length; i++) {
            while(!st.isEmpty() && temp[i] > temp[st.peek()]) {
                ans[st.peek()] = i-st.peek();
                st.pop(); 
            }
            st.push(i);
        }
        // for all the remaining elemnets in stack there is no answer
        while(!st.isEmpty()) {
            ans[st.pop()] = 0;
        }

        return ans;
    }
}
