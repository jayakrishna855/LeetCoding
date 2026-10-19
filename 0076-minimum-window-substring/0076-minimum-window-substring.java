class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        HashMap<Character, Integer> dicT = new HashMap<>();
        for(char ch: t.toCharArray()){
            dicT.put(ch, dicT.getOrDefault(ch, 0)+1);
        }
        int required = dicT.size();
        int right = 0, left = 0, formed = 0;
        int[] ans = new int[]{-1,0,0};
        HashMap<Character, Integer> windowCnt = new HashMap<>();
        while(right < s.length()){
            char ch = s.charAt(right);
            windowCnt.put(ch, windowCnt.getOrDefault(ch, 0)+1);
            if(dicT.containsKey(ch) && dicT.get(ch).intValue() == windowCnt.get(ch).intValue()){
                formed++;
            }
            while(left<=right && formed == required){
                ch = s.charAt(left);
                if(ans[0] == -1 || (right-left+1)<ans[0]){
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowCnt.put(ch, windowCnt.get(ch)-1);
                if(dicT.containsKey(ch) && windowCnt.get(ch).intValue() < dicT.get(ch).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }

        return (ans[0]==-1)? "": s.substring(ans[1], ans[2]+1);
    }
}