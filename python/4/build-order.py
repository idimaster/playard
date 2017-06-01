def build_graph(projects, deps):
    g = {}
    for p in projects:
        g[p] = (set(), set())
    for d in deps:
        g[d[0]][0].add(d[1])
        g[d[1]][1].add(d[0])
    return g


def build_order(projects, deps):
    g = build_graph(projects, deps)
    result = []
    while g:
        buff = []
        for p in g:
            if len(g[p][1]) == 0:
                buff.append(p)
        for p in buff:
            for out in g[p][0]:
                g[out][1].remove(p)
            del g[p]
        if len(buff) == 0:
            return None  # cycle detected
        result.extend(buff)
    return result


def build_order2(projects, deps):
    g = build_graph(projects, deps)
    result = []
    for p in g:
        visited = set()
        if dsf(g, p, result, visited, p):
            return None  # detected cycle
    return reversed(result)


def dsf(graph, n, path, visited, start):
    for node in graph[n][0]:
        if node not in visited:
            if node == start:
                return True
            visited.add(node)
            if dsf(graph, node, path, visited, start):
                return True
    if n not in path:
        path.append(n)
    return False


projects = ['a', 'b', 'c', 'd', 'e', 'f', 'g']
deps = [('a', 'd'), ('f', 'b'), ('b', 'd'), ('f', 'a'), ('d', 'c')]
deps2 = [('f', 'c'), ('f', 'b'), ('f', 'a'), ('b', 'a'), ('b', 'e'), ('d', 'g'), ('a', 'e')]
deps3 = [('a', 'b'), ('b', 'c'), ('c', 'd'), ('d', 'a')]

print(build_order(projects, deps))
print(build_order(projects, deps2))
print(build_order(projects, deps3))

print(build_order2(projects, deps))
print(build_order2(projects, deps2))
print(build_order2(projects, deps3))
