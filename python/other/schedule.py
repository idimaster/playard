import datetime
import unittest


def is_conflict(s1, s2):
    si1 = iter(s1)
    si2 = iter(s2)
    try:
        i1 = next(si1)
        i2 = next(si2)
        while True:
            if i1[1] < i2[0]:
                i1 = next(si1)
            elif i2[1] < i1[0]:
                i2 = next(si2)
            else:
                return True
    except StopIteration:
        pass
    return False


def get_first_available(s1, s2):
    si1 = iter(s1)
    si2 = iter(s2)
    try:
        i1 = next(si1)
        i2 = next(si2)
        while True:
            if i1[1] < i2[0]:
                return i1[1], i2[0]
            elif i2[1] < i1[0]:
                return i2[1], i1[0]
            elif i2[1] < i1[1]:
                i2 = next(si2)
            else:
                i1 = next(si1)
    except StopIteration:
        pass
    return None


def get_all_available(s1, s2):
    si1 = iter(s1)
    si2 = iter(s2)
    try:
        i1 = next(si1)
        i2 = next(si2)
        while True:
            if i1[1] < i2[0]:
                yield i1[1], i2[0]
                i1 = next(si1)
            elif i2[1] < i1[0]:
                yield i2[1], i1[0]
                i2 = next(si2)
            elif i2[1] < i1[1]:
                i2 = next(si2)
            else:
                i1 = next(si1)
    except StopIteration:
        pass
    return None

s1 = [(datetime.datetime(2016, 12, 1, 12, 30), datetime.datetime(2016, 12, 1, 13, 30)),
      (datetime.datetime(2016, 12, 2, 12, 30), datetime.datetime(2016, 12, 2, 13, 30)),
      (datetime.datetime(2016, 12, 2, 15, 30), datetime.datetime(2016, 12, 2, 22, 30)),
      (datetime.datetime(2016, 12, 3, 12, 30), datetime.datetime(2016, 12, 3, 13, 30))]

s2 = [(datetime.datetime(2016, 12, 1, 14, 30), datetime.datetime(2016, 12, 1, 15, 30)),
      (datetime.datetime(2016, 12, 2, 13, 40), datetime.datetime(2016, 12, 2, 14, 30)),
      (datetime.datetime(2016, 12, 2, 18, 30), datetime.datetime(2016, 12, 2, 20, 30)),
      (datetime.datetime(2016, 12, 3, 14, 30), datetime.datetime(2016, 12, 3, 15, 30))]

s3 = [(datetime.datetime(2016, 12, 1, 14, 30), datetime.datetime(2016, 12, 1, 15, 30)),
      (datetime.datetime(2016, 12, 2, 13, 40), datetime.datetime(2016, 12, 2, 14, 30)),
      (datetime.datetime(2016, 12, 3, 14, 30), datetime.datetime(2016, 12, 3, 15, 30))]


class TestSchedule(unittest.TestCase):
    def testConflict(self):
        self.assertTrue(is_conflict(s1, s2))
        self.assertFalse(is_conflict(s1, s3))

    def testFirstAvail(self):
        self.assertEqual(get_first_available(s1, s2), (datetime.datetime(2016, 12, 1, 13, 30), datetime.datetime(2016, 12, 1, 14, 30)))
        self.assertEqual(get_first_available(s1, s3), (datetime.datetime(2016, 12, 1, 13, 30), datetime.datetime(2016, 12, 1, 14, 30)))

    def testAllAvail(self):
        for x in get_all_available(s1, s2):
            print(x)
        print()
        for x in get_all_available(s1, s3):
            print(x)
