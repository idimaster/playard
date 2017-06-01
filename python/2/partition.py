from functools import reduce


class Node:
    def __init__(self, data=None, next=None):
            self.data = data
            self.next = next


def partition(lst, value):
    head = end = None
    while lst:
        if lst.data < value:
            head = Node(lst.data, head)
        else:
            node = Node(lst.data)
            if end is None:
                head = end = node
            else:
                end.next = node
                end = node
        lst = lst.next
    return head


def print_lst(lst):
    while lst:
        print(lst.data, end=' ')
        lst = lst.next
    print()

lst = reduce(lambda node, data: Node(data, node), reversed([1, 5, 2, 2, 2, 2, 3, 4, 3, 5, 1]), None)

print_lst(partition(lst, 3))
