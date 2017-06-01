# A 2D map is represented as an integer matrix where 0s are traversible and 1s are obstacles.
# Given a starting position (row, column) compute the size of reachable area.


def get_size(map, row, column):
    maxRow = len(map)
    maxCol = len(map[0])
    if map[row][column] == 1:
        return 0
    size = 0
    stack = [(row, column)]
    while stack:
        p = stack.pop()
        if map[p[0]][p[1]] == 0:
            size += 1
        map[p[0]][p[1]] = 2  # visited
        if p[0] >= 1 and map[p[0] - 1][p[1]] == 0:
            stack.append((p[0] - 1, p[1]))
        if p[1] >= 1 and map[p[0]][p[1] - 1] == 0:
            stack.append((p[0], p[1] - 1))
        if p[0] < maxRow - 1 and map[p[0] + 1][p[1]] == 0:
            stack.append((p[0] + 1, p[1]))
        if p[1] < maxCol - 1 and map[p[0]][p[1] + 1] == 0:
            stack.append((p[0], p[1] + 1))
    return size


map1 = [[0, 0, 0],
        [0, 0, 0],
        [0, 0, 0]]

print(get_size(map1, 0, 0))

map2 = [[0, 0, 0],
        [1, 1, 1],
        [0, 0, 0]]

print(get_size(map2, 0, 0))


map3 = [[0, 0, 0, 0, 0],
        [0, 1, 1, 1, 0],
        [0, 1, 0, 1, 0],
        [0, 1, 0, 1, 0],
        [0, 1, 1, 1, 0]]

print(get_size(map3, 0, 0))
print(get_size(map3, 2, 2))








