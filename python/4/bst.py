import unittest


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def validate(root, min=None, max=None):
    if root is None:
        return True
    if (min is not None and root.data < min) or (max is not None and root.data > max):
        return False
    return validate(root.left, min, root.data) and validate(root.right, root.data, max)


class TestBST(unittest.TestCase):
    def test1(self):
        t1 = Node(5)
        t1.left = Node(2)
        t1.right = Node(9)
        self.assertTrue(validate(t1))

    def test2(self):
        t1 = Node(5)
        t1.left = Node(6)
        t1.right = Node(9)
        self.assertFalse(validate(t1))

    def test3(self):
        t1 = Node(20)
        t1.left = Node(10)
        t1.right = Node(30)
        t1.left.right = Node(25)
        self.assertFalse(validate(t1))

    def test4(self):
        t1 = Node(20)
        t1.left = Node(10)
        t1.right = Node(30)
        t1.left.left = Node(5)
        t1.left.right = Node(15)
        t1.left.left.left = Node(3)
        t1.left.left.right = Node(7)
        self.assertTrue(validate(t1))
