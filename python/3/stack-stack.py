import unittest


class StackStack:
    def __init__(self, size):
        self.__size = size
        self.__data = []
        self.__data.append([])
        self.__index = 0

    def push(self, value):
        if len(self.__data[self.__index]) >= self.__size:
            self.__index += 1
            self.__data.append([])
        self.__data[self.__index].append(value)

    def pop(self):
        if len(self.__data[self.__index]) == 0:
            if self.__index > 0:
                self.__index -= 1
        return self.__data[self.__index].pop()

    def pop_index(self, index):
        if index > self.__index:
            raise IndexError('Index out of range')
        value = self.__data[index].pop()
        if len(self.__data[index]) == 0 and self.__index > 0:
            self.__data.pop(index)
            self.__index -= 1
        return value


class StackStackTest(unittest.TestCase):
    def testPushPop(self):
        s = StackStack(3)
        s.push(1)
        s.push(2)
        s.push(3)
        s.push(4)
        s.push(5)
        self.assertEqual(s.pop(), 5)
        self.assertEqual(s.pop(), 4)
        self.assertEqual(s.pop(), 3)
        self.assertEqual(s.pop(), 2)
        self.assertEqual(s.pop(), 1)

    def testPopIndex(self):
        s = StackStack(3)
        s.push(1)
        s.push(2)
        s.push(3)
        s.push(4)
        s.push(5)
        s.push(6)
        s.push(7)
        self.assertEqual(s.pop_index(0), 3)
        self.assertEqual(s.pop_index(1), 6)
        self.assertEqual(s.pop_index(1), 5)
        self.assertEqual(s.pop(), 7)
        self.assertEqual(s.pop(), 4)
        self.assertEqual(s.pop(), 2)
        self.assertEqual(s.pop(), 1)

    def testPopIndex2(self):
        s = StackStack(3)
        s.push(1)
        s.push(2)
        s.push(3)
        s.push(4)
        s.push(5)
        s.push(6)
        s.push(7)
        self.assertEqual(s.pop_index(1), 6)
        self.assertEqual(s.pop_index(1), 5)
        self.assertEqual(s.pop_index(1), 4)
        self.assertEqual(s.pop(), 7)
        self.assertEqual(s.pop(), 3)
        self.assertEqual(s.pop(), 2)
        self.assertEqual(s.pop(), 1)
