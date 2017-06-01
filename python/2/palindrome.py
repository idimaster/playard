from functools import reduce


class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


def reverse(lst):
    head = None
    while lst:
        head = Node(lst.data, head)
        lst = lst.next
    return head


def palindrome(lst):
    rev = reverse(lst)
    while lst:
        if lst.data != rev.data:
            return False
        lst = lst.next
        rev = rev.next
    return True


def palindrome2(lst):
    count = 0
    head = slow = lst
    rev = None
    while head:
        if count % 2 == 1:
            rev = Node(slow.data, rev)
            slow = slow.next
        count += 1
        head = head.next
    if count % 2 == 1:
        slow = slow.next
    while slow:
        if slow.data != rev.data:
            return False
        slow = slow.next
        rev = rev.next
    return True


lst = reduce(lambda node, data: Node(data, node), reversed([1, 5, 2, 2, 2, 2, 3, 4, 3, 5, 1]), None)
lst1 = reduce(lambda node, data: Node(data, node), reversed([1, 5, 3, 4, 3, 5, 1]), None)
lst2 = reduce(lambda node, data: Node(data, node), reversed([1, 5, 3, 3, 5, 1]), None)

print(palindrome(lst))
print(palindrome(lst1))
print(palindrome(lst2))
print(palindrome2(lst))
print(palindrome2(lst1))
print(palindrome2(lst2))
