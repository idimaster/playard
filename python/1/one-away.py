def isOneAway(s1, s2):
    if len(s1) == len(s2):
        # check replace
        replace = False
        for c1, c2 in zip(s1, s2):
            if c1 != c2:
                if replace:
                    return False
                else:
                    replace = True
        return True
    elif len(s1) == len(s2) + 1:
        # check delete
        delete = 0
        i = 0
        for c1 in s2:
            if c1 != s1[i + delete]:
                if delete == 0:
                    delete = 1
                else:
                    return False
            i += 1
        return True
    elif len(s1) + 1 == len(s2):
        # check insert
        insert = 0
        i = 0
        for c1 in s1:
            if c1 != s1[i + insert]:
                if insert == 0:
                    insert = 1
                else:
                    return False
            i += 1
        return True
    return False

print(isOneAway('pal', 'pale'))
print(isOneAway('pale', 'ple'))
print(isOneAway('pales', 'pale'))
print(isOneAway('pale', 'bale'))
print(isOneAway('pale', 'bake'))
