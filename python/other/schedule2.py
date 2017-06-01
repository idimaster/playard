from datetime import datetime


class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end


class Calendar:
    def __init__(self, lst):
        self.lst = iter(lst)

    def __iter__(self):
        return self

    def __next__(self):
        return next(self.lst)


class Merge:
    def __init__(self, cal1, cal2):
        self.cal1 = iter(cal1)
        self.cal2 = iter(cal2)
        self.ii1 = None
        self.ii2 = None
        self.last = self.__get_next()

    def __iter__(self):
        return self

    def __get_next(self):
        end1 = end2 = False
        if self.ii1 is None:
            try:
                self.ii1 = next(self.cal1)
            except StopIteration:
                end1 = True
        if self.ii2 is None:
            try:
                self.ii2 = next(self.cal2)
            except StopIteration:
                end2 = True
        if end1 and end2:
            return None
        if end1 or end2:
            res = self.ii1 if self.ii2 is None else self.ii2
            self.ii1 = self.ii2 = None
            return res
        if self.ii1.start < self.ii2.start:
            res = self.ii1
            self.ii1 = None
        else:
            res = self.ii2
            self.ii2 = None
        return res

    def __next__(self):
        if self.last is None:
            raise StopIteration
        nxt = self.__get_next()
        while nxt and self.last.end >= nxt.start:
            if nxt.end > self.last.end:  # merge
                self.last.end = nxt.end
            nxt = self.__get_next()
        res = self.last
        self.last = nxt
        return res


class Inverse:
    START = datetime(1700, 1, 1)
    END = datetime(6000, 1, 1)

    def __init__(self, cal):
        self.cal = iter(cal)
        self.last = Inverse.START

    def __iter__(self):
        return self

    def __next__(self):
        if self.last is None:
            raise StopIteration
        try:
            interv = next(self.cal)
            res = Interval(self.last, interv.start)
            self.last = interv.end
        except StopIteration:
            res = Interval(self.last, Inverse.END)
            self.last = None
        return res


s1 = [Interval(datetime(2016, 12, 1, 12, 30), datetime(2016, 12, 1, 13, 30)),
      Interval(datetime(2016, 12, 2, 12, 30), datetime(2016, 12, 2, 13, 30)),
      Interval(datetime(2016, 12, 2, 15, 30), datetime(2016, 12, 2, 22, 30)),
      Interval(datetime(2016, 12, 3, 12, 30), datetime(2016, 12, 3, 13, 30))]

s2 = [Interval(datetime(2016, 12, 1, 14, 30), datetime(2016, 12, 1, 15, 30)),
      Interval(datetime(2016, 12, 2, 13, 40), datetime(2016, 12, 2, 14, 30)),
      Interval(datetime(2016, 12, 2, 18, 30), datetime(2016, 12, 2, 20, 30)),
      Interval(datetime(2016, 12, 3, 14, 30), datetime(2016, 12, 3, 15, 30))]

s3 = [Interval(datetime(2016, 12, 1, 14, 30), datetime(2016, 12, 1, 15, 30)),
      Interval(datetime(2016, 12, 2, 13, 40), datetime(2016, 12, 2, 14, 30)),
      Interval(datetime(2016, 12, 3, 14, 30), datetime(2016, 12, 3, 15, 30))]

c1 = Calendar(s1)
c2 = Calendar(s2)
c3 = Calendar(s3)

m = Merge(Merge(c1, c2), c3)

for i in m:
    print(i.start, i.end)

print()

inv = Inverse(m)
for i in inv:
    print(i.start, i.end)
