import  unittest


class Stack:
    def __init__(self):
        self.__data = []
        self.__min = None

    def push(self, value):
        self.__data.append((value, self.__min))
        if self.__min is None:
            self.__min = value
        elif self.__min > value:
            self.__min = value

    def pop(self):
        val = self.__data.pop()
        self.__min = val[1]
        return val[0]

    def min(self):
        return self.__min


class StackTest(unittest.TestCase):
    def testPushPop(self):
        s = Stack()
        s.push(1)
        s.push(3)
        s.push(4)
        self.assertEqual(s.pop(), 4)
        self.assertEqual(s.pop(), 3)
        self.assertEqual(s.pop(), 1)

    def testMin(self):
        s = Stack()
        s.push(1)
        self.assertEqual(s.min(), 1)
        s.push(3)
        self.assertEqual(s.min(), 1)
        s.push(4)
        self.assertEqual(s.min(), 1)
        s.push(-1)
        self.assertEqual(s.min(), -1)
        s.push(2)
        self.assertEqual(s.min(), -1)
        s.push(-5)
        self.assertEqual(s.min(), -5)

        self.assertEqual(s.pop(), -5)
        self.assertEqual(s.min(), -1)

        self.assertEqual(s.pop(), 2)
        self.assertEqual(s.min(), -1)

        self.assertEqual(s.pop(), -1)
        self.assertEqual(s.min(), 1)

        self.assertEqual(s.pop(), 4)
        self.assertEqual(s.min(), 1)

        self.assertEqual(s.pop(), 3)
        self.assertEqual(s.min(), 1)

        self.assertEqual(s.pop(), 1)
        self.assertEqual(s.min(), None)
