def perm(s1, s2):
    if len(s1) != len(s2):
        return False
    ss1 = sorted(s1.lower())
    ss2 = sorted(s2.lower())
    return ss1 == ss2

print(perm('dog', 'God'))

