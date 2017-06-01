from functools import reduce


class Node:
    def __init__(self, data=None, next=None):
            self.data = data
            self.next = next


def delete(lst, value):
    head = lst
    prev = lst
    lst = lst.next
    while lst:
        if lst.data == value:
            prev.next = lst.next
            value = None  # remove only one node
        prev = lst
        lst = lst.next
    return head


def printList(lst):
    while lst:
        print(lst.data, end=' ')
        lst = lst.next
    print()

lst = reduce(lambda node, data: Node(data, node), reversed([1, 5, 2, 2, 2, 2, 3, 4, 3, 5, 1]), None)

printList(delete(lst, 5))
