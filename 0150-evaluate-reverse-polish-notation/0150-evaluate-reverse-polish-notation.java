class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                int op2 = st.pop(), op1 = st.pop();
                if(s.equals("+")) st.push(op1+op2);
                if(s.equals("-")) st.push(op1 - op2);
                if(s.equals("*")) st.push(op1 * op2);
                if(s.equals("/")) st.push(op1 / op2);
            }
            else st.push(Integer.parseInt(s));
        }
        return st.pop();
    }
}