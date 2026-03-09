class Solution {
    public String decimalToBinary(int n, int len){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%2);
            n = n/2;
        }
        while(sb.length()<len){
            sb.append('0');
        }
        return sb.reverse().toString();
        
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(String num: nums){
            set.add(Integer.parseInt(num, 2));
        }
        int uno = 0;
        for(int i=0;i<Math.pow(2,n);i++){
            if(!set.contains(i)){
                uno = i;
            }
        }
        return decimalToBinary(uno, n);
    }
}