class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr=new int[26];
        
        
        for(int i=0;i<text.length();i++){
            arr[text.charAt(i)-97]+=1;
        }
        
        String s="ballon";
        
        int ans=Integer.MAX_VALUE;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='l' || s.charAt(i)=='o'){
                 if(arr[s.charAt(i)-97]<2){
                     return 0;
                 }
                else{
                    ans=Math.min(ans,arr[s.charAt(i)-97]/2);
                }
            }
            ans=Math.min(arr[s.charAt(i)-97],ans);
        }
        
        return ans;
    }
}