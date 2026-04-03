class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int n: nums){
            int count = 1, left = 0, right = 0;
            if(map.containsKey(n)) continue;
            if(map.containsKey(n-1)){
                left = map.get(n-1);
                count+=left;
                
            }
            if(map.containsKey(n+1)){
                right = map.get(n+1);
                count+= right;
                
            }
            map.put(n, count);
            map.put(n-left, count);
            map.put(n+right, count);
            max = Math.max(max, count);
        }
        return max;
    }
}