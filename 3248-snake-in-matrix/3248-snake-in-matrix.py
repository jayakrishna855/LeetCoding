class Solution:
    def finalPositionOfSnake(self, n: int, commands: List[str]) -> int:
        grid = []
        pos = [0, 0]
        i = 0
        for row in range(n):
            new_row = []
            for col in range(n):
                new_row.append(i)
                i += 1
            grid.append(new_row)
        for command in commands:
            if command == 'UP':
                pos[0] -= 1
            elif command == 'DOWN':
                pos[0] += 1
            elif command == 'RIGHT':
                pos[1] += 1
            else:
                pos[1] -= 1
        return grid[pos[0]][pos[1]]

        