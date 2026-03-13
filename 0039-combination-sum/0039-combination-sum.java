class Solution {
    public void getCombinations(int[] candidates, int index, int target, List<List<Integer>> ans, List<Integer> list ){
        if(target<=0 || index>= candidates.length){
            if(target == 0){
               ans.add(new ArrayList<>(list));
            }
           return; 
        }
        
        list.add(candidates[index]);
        getCombinations(candidates, index,target-candidates[index], ans, list);
        list.remove(list.size()-1);
        getCombinations(candidates,index+1, target, ans, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getCombinations(candidates, 0, target, ans, list);
        return ans;
    }
}