class Solution {
    public String smallestSubsequence(String s) {
        int[] letters=new int[26];
        for(int i=0;i<s.length();i++){
            letters[s.charAt(i)-'a']=i;
        }
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[26];
        for(int i=0;i<s.length();i++){
            int cidx=s.charAt(i)-'a';
            if(visited[cidx]){
                continue;
            }
            while(!st.isEmpty() && st.peek()>cidx && i<letters[st.peek()]){
                    visited[st.pop()]=false;
                    
            }
            st.push(cidx);
            visited[cidx]=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
        return sb.reverse().toString();
     
    }
}