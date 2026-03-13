class Solution {
    public void getCombinations(int[] candidates, int target, int idx, List<Integer> list, List<List<Integer>> ans){
        if(target<=0 || idx>=candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(candidates[idx]);
        getCombinations(candidates, target-candidates[idx], idx+1, list, ans);
        list.remove(list.size()-1);
        int next = idx+1;
        while (next < candidates.length && candidates[next] == candidates[idx]) next++;
        getCombinations(candidates, target, next, list, ans);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getCombinations(candidates, target, 0, list, ans);
        return ans;
    }
}