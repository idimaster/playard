from functools import reduce


class Node:
    def __init__(self, data=None, next=None):
            self.data = data
            self.next = next

def getNum(lst):
    if lst is None:
        return 0
    return lst.data


def sum(lst1, lst2):
    result = end = None
    carry = 0
    while lst1 or lst2:
        data = getNum(lst1) + getNum(lst2) + carry
        if data > 9:
            carry = data // 10
            data %= 10
        else:
            carry = 0
        node = Node(data)
        if end is None:
            result = end = node
        else:
            end.next = node
            end = node
        if lst1:
            lst1 = lst1.next
        if lst2:
            lst2 = lst2.next
    return result


def reverse(lst):
    head = None
    while lst:
        head = Node(lst.data, head)
        lst = lst.next
    return head

def print_lst(lst):
    while lst:
        print(lst.data, end=' ')
        lst = lst.next
    print()

lst1 = reduce(lambda node, data: Node(data, node), reversed([1, 5, 2, 2, 2, 2, 3, 4, 3, 5, 1]), None)
lst2 = reduce(lambda node, data: Node(data, node), reversed([1, 5, 2, 2, 2, 3, 4, 3, 5, 1]), None)

print_lst(sum(lst1, lst2))

print_lst(reverse(lst1))
print_lst(reverse(lst2))

print_lst(reverse(sum(reverse(lst1), reverse(lst2))))
