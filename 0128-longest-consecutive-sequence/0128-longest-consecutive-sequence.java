class Solution {
    public int longestConsecutive(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       int longest = 0;
       for(int num: nums){
        int count = 1, left = 0, right = 0;
        if(map.containsKey(num)) continue;
        if(map.containsKey(num-1)){
            left+=map.get(num-1);
            count+=left;
        }
        if(map.containsKey(num+1)){
            right+=map.get(num+1);
            count+=right;
        }
        map.put(num, count);
        map.put(num-left, count);
        map.put(num+right, count);
        longest = Math.max(longest, count);
       }

       return longest;
    }
}