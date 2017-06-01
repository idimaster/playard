class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def check(tree):
    if tree is None:
        return True
    if abs(depth(tree.left) - depth(tree.right)) > 1:
        return False
    return check(tree.left) and check(tree.right)


def depth(tree):
    if tree:
        return max(depth(tree.left), depth(tree.right)) + 1
    return 0


def check2(tree):
    if tree is None:
        return 0
    left = check2(tree.left)
    if left is None:
        return None
    right = check2(tree.right)
    if right is None:
        return None
    if abs(right - left) > 1:
        return None
    return max(right, left) + 1


tree1 = Node(2)
tree1.left = Node(3)
tree1.left.left = Node(4)
tree1.left.left.left = Node(5)
tree1.right = Node(4)
tree1.right.left = Node(4)
tree1.right.right = Node(4)

print(check(tree1))
print(check2(tree1))

tree1.right.right = Node(4)
tree1.right.right.right = Node(4)
tree1.right.right.right.left = Node(4)
print(check(tree1))
print(check2(tree1))

tree1.right.right.right.left.right = Node(4)
print(check(tree1))
print(check2(tree1))

tree2 = Node(4)
tree2.left = Node(4)
tree2.right = Node(4)
tree2.left.right = Node(4)
tree2.right.right = Node(4)
print(check(tree2))
print(check2(tree2))

