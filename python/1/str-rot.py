def rot(s1, s2):
    if len(s1) != len(s2):
        return False
    return True if (s1 + s1).find(s2) != -1 else False

print(rot('waterbottle', 'erbottlewat'))
