class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0;
        if(m==1 && n==1) return matrix[0][0] == target;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==target || matrix[i][n-1]==target) return true;
            else{
                if(target>matrix[i][0] && target<matrix[i][n-1]) r=i;
            }
        }
        int cl = 0, ch = n;
        while(cl<ch){
            int mid = (cl+ch)/2;
            if(matrix[r][mid] == target) return true;
            else if(matrix[r][mid]>target) ch = mid;
            else cl = mid+1;
        }
        return false;
    }
}