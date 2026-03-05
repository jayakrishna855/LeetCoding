class Solution {
    public int minOperations(String s) {
        if(s.length()==1) return 0;
        int min = Integer.MAX_VALUE;
        char fc = s.charAt(0);
        int i = 1;
        int op = 0;
        if(fc == '0'){
            while(i<s.length()){
                char ch = s.charAt(i);
                if(i%2 == 0){
                    if(ch != '0') op++;
                }
                else{
                    if(ch != '1') op++;
                }
                i++;
            }
            min = Math.min(min, op);
            op = 1;
            i = 1;
            while(i<s.length()){
                char ch = s.charAt(i);
                if(i%2 == 0){
                    if(ch != '1') op++;
                }
                else{
                    if(ch != '0') op++;
                }
                i++;
            }
            min = Math.min(min, op);

        }
        else{
            while(i<s.length()){
                char ch = s.charAt(i);
                if(i%2 == 0){
                    if(ch != '1') op++;
                }
                else{
                    if(ch != '0') op++;
                }
                i++;
            }
            min = Math.min(min, op);
            op = 1;
            i = 1;
            while(i<s.length()){
                char ch = s.charAt(i);
                if(i%2 == 0){
                    if(ch != '0') op++;
                }
                else{
                    if(ch != '1') op++;
                }
                i++;
            }
            min = Math.min(min, op);

        }
        return min;
    }
}