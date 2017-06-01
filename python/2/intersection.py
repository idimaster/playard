class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


def check(lst1, lst2):
    while lst1:
        head = lst2
        while head:
            if head == lst1:
                return True
            head = head.next
        lst1 = lst1.next
    return False


def check2(lst1, lst2):
    s = set()
    while lst1:
        s.add(lst1)
        lst1 = lst1.next
    while lst2:
        if lst2 in s:
            return True
        lst2 = lst2.next
    return False


def check3(lst1, lst2):
    while lst1.next:
        lst1 = lst1.next
    while lst2.next:
        lst2 = lst2.next
    return lst1 == lst2


lst = Node('a', Node('b', Node('c')))
lst0 = Node('a', Node('b', Node('c')))
lst1 = Node('d', Node('f', lst))
lst2 = Node('k', Node('l', Node('m', lst)))


print(check(lst1, lst2))
print(check(lst, lst0))

print(check2(lst1, lst2))
print(check2(lst, lst0))

print(check3(lst1, lst2))
print(check3(lst, lst0))
