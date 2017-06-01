class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def __repr__(self):
        return self.data


def depth_list(root):
    result = []
    current = [root]
    while current:
        result.append(current)
        parent = current
        current = []
        for node in parent:
            if node.left:
                current.append(node.left)
            if node.right:
                current.append(node.right)
    return result


tree = Node('1')
tree.left = Node('21.1')
tree.right = Node('22.1')
tree.left.left = Node('31.21')
tree.left.right = Node('32.21')
tree.left.right.right = Node('42.32')
tree.right.left = Node('31.22')


print(depth_list(tree))
