def unique(string):
    chars = set()
    for char in string:
        if char in chars:
            return False
        chars.add(char)
    return True

print(unique('sdsdgsdfghj'))
print(unique('abcdd'))
print(unique('adbcd'))
print(unique('addbc'))
print(unique('adbdc'))
print(unique('abcdef'))


def unique2(s):
    l = len(s)
    for i in range(l):
        for j in range(l-i-1):
            if s[i] == s[j+i+1]:
                return False
    return True

print('v2')
print(unique2('sdsdgsdfghj'))
print(unique2('abcdd'))
print(unique2('adbcd'))
print(unique2('addbc'))
print(unique2('adbdc'))
print(unique2('abcdef'))


def unique3(s):
    l = len(s)
    sort = sorted(s)
    for i in range(l-1):
        if sort[i] == sort[i+1]:
            return False
    return True

print('v3')
print(unique3('sdsdgsdfghj'))
print(unique3('abcdd'))
print(unique3('adbcd'))
print(unique3('addbc'))
print(unique3('adbdc'))
print(unique3('abcdef'))