class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for(String s: strs){
    
            for(char c: s.toCharArray()){
                count[c-97]+=1;
            }
            
            for(int i=0;i<26;i++){
                sb.append(count[i]);
                sb.append('#');
            }
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(s);
            sb.setLength(0);
            Arrays.fill(count, 0);
        }
        for(List<String> ls: map.values()){
            ans.add(ls);
        }
        return ans;
    }
    
}