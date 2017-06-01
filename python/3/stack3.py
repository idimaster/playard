import unittest


class Stack:
    COUNT = 3

    def __init__(self, size):
        self.__size = size
        self.__data = [None] * size
        self.__sSize = size // Stack.COUNT
        self.__index = [None] * Stack.COUNT
        for i in range(Stack.COUNT):
            index = i * self.__sSize
            self.__index[i] = [index, index]

    def pop(self, index):
        if index >= Stack.COUNT:
            raise ValueError('Index cannot be more than {}'.format(Stack.COUNT))
        index = self.__index[index]
        if index[0] == index[1]:
            raise IndexError('pop from empty stack')
        index[1] -= 1
        return self.__data[index[1]]

    def push(self, index, value):
        if index >= Stack.COUNT:
            raise ValueError('Index cannot be more than {}'.format(Stack.COUNT))
        index = self.__index[index]
        if index[1] - index[0] > self.__sSize - 1:
            raise IndexError('No capacity for new element')
        self.__data[index[1]] = value
        index[1] += 1


class StackTests(unittest.TestCase):

    def testPush(self):
        s = Stack(15)
        s.push(0, 5)
        s.push(0, 3)
        s.push(0, 2)
        self.assertEqual(s.pop(0), 2)
        self.assertEqual(s.pop(0), 3)
        self.assertEqual(s.pop(0), 5)

    def testIndex(self):
        s = Stack(9)
        with self.assertRaises(ValueError):
            s.push(4, 4)

    def testIndexOut(self):
        s = Stack(9)
        s.push(1, 4)
        s.push(1, 4)
        s.push(1, 4)
        with self.assertRaises(IndexError):
            s.push(1, 4)

    def testEmpty(self):
        s = Stack(9)
        s.push(1, 4)
        s.pop(1)
        with self.assertRaises(IndexError):
            s.pop(1)

    def testOverlap(self):
        s = Stack(9)
        s.push(1, 11)
        s.push(1, 12)
        s.push(1, 13)
        s.push(2, 21)
        s.push(2, 22)
        s.push(2, 23)
        s.push(0, 1)
        s.push(0, 2)
        s.push(0, 3)
        self.assertEqual(s.pop(1), 13)
        self.assertEqual(s.pop(1), 12)
        self.assertEqual(s.pop(1), 11)
        self.assertEqual(s.pop(0), 3)
        self.assertEqual(s.pop(0), 2)
        self.assertEqual(s.pop(0), 1)

