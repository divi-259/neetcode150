class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backtrack(0,0,n,"");
        return ans;
    }

    public void backtrack(int open, int close, int n, String temp) {
        if(temp.length()==2*n) {
            ans.add(temp);
            return;
        }
        if(open < n) {
            backtrack(open+1, close, n, temp+"(");
        }
        if(close < open) {
            backtrack(open, close+1, n, temp+")");
        }
        
    }
}
