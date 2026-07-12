class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] arr2 = arr.clone();
        int[] rank = new int[n];
        Arrays.sort(arr2);
        Map<Integer,Integer> map = new HashMap<>();
        int j = 1;
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr2[i])){
                map.put(arr2[i], j++);
            }
        }
        for(int i=0;i<n;i++){
            rank[i] = map.getOrDefault(arr[i],0);
        }
        return rank;
    }
}