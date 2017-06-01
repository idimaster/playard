from functools import reduce


class Node:
    def __init__(self, data=None, next=None):
            self.data = data
            self.next = next


def kthFromEnd(lst, k):
    head = lst
    i = k
    while lst:
        lst = lst.next
        i -= 1
        if i < 0:
            head = head.next
    return head


def printList(lst):
    while lst:
        print(lst.data, end=' ')
        lst = lst.next
    print()

lst = reduce(lambda node, data: Node(data, node), reversed([1, 5, 2, 2, 2, 2, 3, 4, 3, 5, 1]), None)

printList(kthFromEnd(lst, 5))
