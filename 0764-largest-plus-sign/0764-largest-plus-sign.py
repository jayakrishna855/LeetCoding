class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: List[List[int]]) -> int:
        g = [[min(i, n - 1 - i, j, n - 1 - j) + 1 for j in range(n)] for i in range(n)]
        for x, y in mines:
            for i in range(n):
                g[i][y] = min(g[i][y], abs(i - x))
                g[x][i] = min(g[x][i], abs(i - y))
        return max([max(row) for row in g])