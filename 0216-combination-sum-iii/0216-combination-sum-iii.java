class Solution {
    List<List<Integer>> ans;
    public void getAllcombinations(int k, int n, List<Integer> vcomb, int idx){
        if(n==0 && vcomb.size() == k){
            ans.add(new ArrayList<Integer>(vcomb));
            return;
        }

        for(int i=idx+1;i<=9;i++){
            if(n-i>=0){
                vcomb.add(i);
                getAllcombinations(k, n-i, vcomb, i);
                vcomb.remove(vcomb.size()-1);
            }
            else{
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> vcomb = new ArrayList<>();
        ans = new ArrayList<>();
        getAllcombinations(k, n, vcomb, 0);  
        return ans; 
    }
}