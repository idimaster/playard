import unittest


class Heap:
    def __init__(self):
        self.__list = [0]

    def add(self, value):
        self.__list.append(value)
        pos = len(self.__list) - 1
        while pos >> 1 > 0 and value < self.__list[pos >> 1]:
            self.__list[pos] = self.__list[pos >> 1]
            pos >>= 1
        self.__list[pos] = value

    def min(self):
        if len(self.__list) > 1:
            return self.__list[1]
        return None

    def __min_child(self, pos):
        pos <<= 1
        if pos + 1 > len(self.__list) - 1:
            return pos  # one child
        if self.__list[pos] < self.__list[pos + 1]:
            return pos
        else:
            return pos + 1

    def pop(self):
        if len(self.__list) == 2:
            return self.__list.pop()
        result = self.__list[1]
        self.__list[1] = self.__list.pop()
        pos = 1
        while pos << 1 < len(self.__list):
            min_child = self.__min_child(pos)
            if self.__list[pos] > self.__list[min_child]:
                tmp = self.__list[pos]
                self.__list[pos] = self.__list[min_child]
                self.__list[min_child] = tmp
            pos = min_child
        return result


class HeapTest(unittest.TestCase):
    def testAdd(self):
        h = Heap()
        h.add(3)
        self.assertEqual(h.min(), 3)
        h.add(4)
        self.assertEqual(h.min(), 3)
        h.add(1)
        self.assertEqual(h.min(), 1)
        h.add(4)
        self.assertEqual(h.min(), 1)
        h.add(5)
        self.assertEqual(h.min(), 1)
        h.add(2)
        self.assertEqual(h.min(), 1)
        h.add(0)
        self.assertEqual(h.min(), 0)

    def testPop(self):
        h = Heap()
        h.add(3)
        h.add(4)
        h.add(9)
        h.add(1)
        h.add(0)
        h.add(2)
        self.assertEqual(h.pop(), 0)
        self.assertEqual(h.pop(), 1)
        self.assertEqual(h.pop(), 2)
        self.assertEqual(h.pop(), 3)
        self.assertEqual(h.pop(), 4)
        self.assertEqual(h.pop(), 9)
