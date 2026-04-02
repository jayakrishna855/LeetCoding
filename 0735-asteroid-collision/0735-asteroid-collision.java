class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int as: asteroids){
            if(st.empty()){
                st.push(as);
            }
            else{
                int top = st.peek();
                if(top>0){
                    if(as<0){
                        while(!st.empty() && top>0 && top<=Math.abs(as)){
                            st.pop();
                            if(top == Math.abs(as) || st.empty()){
                                break;
                            }
                            top = st.peek();
                        }
                        if(top >= Math.abs(as)) continue;
                        else{
                            st.push(as);
                        }
                    }
                    else{
                        st.push(as);
                    }
                }
                else{
                    st.push(as);
                }
            }
        }
        
        int[] ans = new int[st.size()];
        int i=1, n = st.size();
        while(!st.empty()){
            ans[n-i] = st.pop();
            i++;
        }
        return ans;
    }
}