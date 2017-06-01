import unittest


class Node:
    def __init__(self, data, parent=None):
        self.data = data
        self.left = None
        self.right = None
        self.parent = parent


def successor(node):
    if node is None:
        return None
    if node.right:
        node = node.right
        while node.left:
            node = node.left
        return node
    else:
        t = node
        node = node.parent
        while node and node.left != t:
            t = node
            node = node.parent
        return node


class TestSuccessor(unittest.TestCase):
    def setUp(self):
        self.t1 = Node(20)
        self.t1.left = Node(10, self.t1)
        self.t1.right = Node(30, self.t1)
        self.t1.left.left = Node(5, self.t1.left)
        self.t1.left.right = Node(15, self.t1.left)
        self.t1.left.right.right = Node(17, self.t1.left.right)
        self.t1.left.left.left = Node(3, self.t1.left.left)
        self.t1.left.left.right = Node(7, self.t1.left.left)

    def test1(self):
        node = successor(self.t1.left)
        self.assertEqual(node.data, 15)

    def test2(self):
        node = successor(self.t1.left.left)
        self.assertEqual(node.data, 7)

    def test3(self):
        node = successor(self.t1)
        self.assertEqual(node.data, 30)

    def test4(self):
        node = successor(self.t1.right)
        self.assertIsNone(node)

    def test5(self):
        node = successor(self.t1.left.right.right)
        self.assertEqual(node.data, 20)

