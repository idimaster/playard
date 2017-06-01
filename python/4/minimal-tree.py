class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def min_tree(lst, start=None, end=None):
    if start is None:
        start = 0
        end = len(lst) - 1
    if end < start:
        return None
    pos = (end + start) // 2
    node = Node(lst[pos])
    node.left = min_tree(lst, start, pos - 1)
    node.right = min_tree(lst, pos + 1, end)
    return node

lst = [1, 2, 3, 4, 5, 6, 7, 8, 9]

tree = min_tree(lst)
