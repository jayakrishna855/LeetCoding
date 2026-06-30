class Solution {
    private boolean hasAll3s(int[] count){
        int chrs = 0;
        for(int i=0;i<26;i++){
            if(count[i]>0) chrs+=1;
        }
        return (chrs==3)? true: false;
    }
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int i = 0, n = s.length(), ans = 0;

        // while(j<n){
        //     if(hasAll3s(count)){
        //         // ans+=1;
        //         // int rem = (n-j-1)>0? n-j-1: 0;
        //         // ans+=rem;
        //         // count[s.charAt(i)-97]-=1;
        //         // i++;
        //         while(i<j && hasAll3s(count)){
        //             ans+=1;
        //             int rem = (n-j-1)>0? n-j-1: 0;
        //             ans+=rem;
        //             count[s.charAt(i)-97]-=1;
        //             i++;
        //         }
        //     }
        //     else{
        //         count[s.charAt(j)-97]+=1;
        //         j++;
        //     }
        // }
        // while(i<j && hasAll3s(count)){
        //     ans+=1;
        //     int rem = (n-j-1)>0? n-j-1: 0;
        //     ans+=rem;
        //     count[s.charAt(i)-97]-=1;
        //     i++;
        // }
        for(int j=0;j<n;j++){
            count[s.charAt(j)-'a']+=1;
            while(count[0]>0 && count[1]>0 && count[2]>0){
                ans+=(n-j);
                count[s.charAt(i)-'a']-=1;
                i++;
            }
        }
        return ans;
    }
}