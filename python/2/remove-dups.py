
from functools import reduce


class Node:
    def __init__(self, data=None, next=None):
            self.data = data
            self.next = next


def removeDups(lst):
    keys = set()
    keys.add(lst.data)
    result = head = lst
    lst = lst.next
    while lst:
        if lst.data not in keys:
            keys.add(lst.data)
            head.next = lst
            head = head.next
        lst = lst.next
    head.next = None
    return result


def removeDups2(lst):
    result = head = lst
    while head:
        lst = head.next
        prev = head
        while lst:
            if head.data == lst.data:
                prev.next = lst.next
            else:
                prev = lst
            lst = lst.next
        head = head.next
    return result


def printList(lst):
    while lst:
        print(lst.data, end=' ')
        lst = lst.next
    print()
lst = reduce(lambda node, data: Node(data, node), reversed([1, 2, 3, 4, 5]), None)
lst2 = reduce(lambda node, data: Node(data, node), reversed([1, 5, 2, 2, 2, 2, 3, 4, 3, 5, 1]), None)

printList(removeDups(lst))
printList(removeDups(lst2))

lst = reduce(lambda node, data: Node(data, node), reversed([1, 2, 3, 4, 5]), None)
lst2 = reduce(lambda node, data: Node(data, node), reversed([1, 5, 2, 2, 2, 2, 2, 3, 4, 3, 5, 1]), None)
printList(removeDups2(lst))
printList(removeDups2(lst2))
