def cycle(g):
    for n in g:
        if dfs(g, n):
            return True
    return False


def dfs(g, n):
    if n not in g:
        return False
    v = set(n)
    stack = [n]
    while stack:
        node = stack.pop()
        for next in g[node]:
            if next == n:
                return True
            if next not in v:
                v.add(next)
                stack.append(next)
    return False

graph = {'A': ['B', 'C'],
         'B': ['C', 'D'],
         'C': ['D'],
         'D': ['C'],
         'E': ['F'],
         'F': ['C']}

print(cycle(graph))

graph1 = {'A': ['B', 'C'],
         'B': ['E', 'F'],
         'C': ['D'],
         'D': ['K'],
         'J': ['F'],
         'F': ['C'],
         'K': [],
         'E': []
          }

print(cycle(graph1))

