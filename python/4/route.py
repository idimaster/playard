from collections import deque


def find_route_dfs(graph, start, end, path=[]):
    path = path + [start]
    if start == end:
        return path
    if start not in graph:
        return None
    for node in graph[start]:
        if node not in path:
            newpath = find_route_dfs(graph, node, end, path)
            if newpath:
                return newpath
    return None


def find_route_bfs(graph, start, end):
    if start not in graph:
        return None
    queue = deque([(start, [start])])
    visited = set(start)
    while queue:
        (v, path) = queue.popleft()
        for next in graph[v]:
            if next not in visited:
                if next == end:
                    return path + [next]
                visited.add(next)
                queue.append((next, path + [next]))
    return None


def find_route_bfs2(graph, start, end):
    if start not in graph:
        return None
    if end not in graph:
        return None
    queue_left = deque([start])
    visited_left = {start: [start]}
    queue_right = deque([end])
    visited_right = {end: [end]}
    while queue_left and queue_right:
        if queue_left:
            v = queue_left.popleft()
            for next in graph[v]:
                if next not in visited_left:
                    if next in visited_right:
                        return visited_left[v] + visited_right[next]
                    visited_left[next] = visited_left[v] + [next]
                    queue_left.append(next)
        if queue_right:
            v = queue_right.popleft()
            for next in graph[v]:
                if next not in visited_right:
                    if next in visited_left:
                        return visited_left[next] + visited_right[v]
                    visited_right[next] = [next] + visited_right[v]
                    queue_right.append(next)
    return None

graph = {'A': ['B', 'C'],
         'B': ['C', 'D'],
         'C': ['D'],
         'D': ['C'],
         'E': ['F'],
         'F': ['C']}

print(find_route_dfs(graph, 'A', 'D'))
print(find_route_bfs(graph, 'A', 'D'))
print(find_route_bfs2(graph, 'A', 'D'))

