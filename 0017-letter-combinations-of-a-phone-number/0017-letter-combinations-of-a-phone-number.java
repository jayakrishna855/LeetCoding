class Solution {
    Map<Integer, String> map;

    public void getAllCombs(String digits, int idx, StringBuilder sb, List<String> ans){
        if(idx>=digits.length()){
            ans.add(new String(sb.toString()));
            return;
        }
        String letters = map.get(Character.getNumericValue(digits.charAt(idx)));
        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            getAllCombs(digits, idx+1, sb, ans);
            sb.setLength(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getAllCombs(digits, 0, sb, ans);
        return ans;
        
    }
}