class Solution {
    public void getAllCombs(int n, List<String> ans, int open, int close, StringBuilder sb ){
        if(open == n && close == n){
            ans.add(new String(sb.toString()));
            return;
        }
        if(open>n || close>n || close>open){
            return;
        }
        sb.append('(');
        getAllCombs(n, ans,open+1,close, sb);
        sb.setLength(sb.length()-1);
        if(sb.length()>=1){
            sb.append(')');
            getAllCombs(n, ans,open,close+1, sb);
            sb.setLength(sb.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        getAllCombs(n, ans, 0, 0, new StringBuilder(""));
        return ans;
    }
}