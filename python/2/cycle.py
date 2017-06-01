class Node:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


def cycle(lst):
    s = set()
    while lst:
        if lst in s:
            return True
        s.add(lst)
        lst = lst.next
    return False


def cycle2(lst):
    slow = fast = lst
    count = 0
    while fast and fast.next:
        fast = fast.next.next
        slow = slow.next
        count += 1
        if slow == fast:
            break
    if fast is None or fast.next is None:
        return False
    slow = lst
    while slow != fast:
        slow = slow.next
        fast = fast.next
    return fast


def cycle3(lst):
    while lst:
        if hasattr(lst, 'visited'):
            return True
        lst.visited = True
        lst = lst.next
    return False

lst = Node('a', Node('b', Node('c')))
n0 = Node('0')
n01 = Node('1')
n1 = Node('a')
n2 = Node('b')
n3 = Node('c')

n1.next = n2
n2.next = n3
n3.next = n1

n0.next = n01
n01.next = n1

print(cycle(lst))
print(cycle(n1))
print(cycle(n0))

print(cycle2(lst))
print(cycle2(n1))
print(cycle2(n0))

print(cycle3(lst))
print(cycle3(n1))
print(cycle3(n0))
