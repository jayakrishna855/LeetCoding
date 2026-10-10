class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() == 0) return 0;
        int ans = 1, left = 0, right = 0;
        for(char c: s.toCharArray()){
            map.put(c, -1);
        }
        for(right=0;right<s.length();right++){
            if(map.get(s.charAt(right))!=-1){
                ans = Math.max(ans, (right-left));
                int newleft = map.get(s.charAt(right))+1;
                while(left<newleft){
                    map.put(s.charAt(left), -1);
                    //map[s.charAt(left)-97] = -1;
                    left++;
                }
                left = newleft;
                //map[s.charAt(right)-97] = right;
               
            }
            map.put(s.charAt(right), right);
            // else{
            //     map[s.charAt(right)-97]= right;
            // }
        }
        ans = Math.max(ans, (right-left));

        return ans;


    }
}