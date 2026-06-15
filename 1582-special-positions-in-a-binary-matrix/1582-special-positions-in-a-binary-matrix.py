class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        rows, cols = len(mat), len(mat[0])
        row_sums = [sum(row) for row in mat]
        col_sums = [sum(col) for col in zip(*mat)]
        
        count = 0
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 1 and row_sums[r] == 1 and col_sums[c] == 1:
                    count += 1
                    
        return count
        