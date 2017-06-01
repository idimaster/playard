def isPolPerm(s):
    counts = {}
    for ch in s:
        if ch.isalpha():
            counts[ch] = counts.get(ch, 0) + 1
    odd = False
    for v in counts.values():
        if v % 2 == 1:
            if odd:
                return False
            else:
                odd = True
    return True

print(isPolPerm('tact coa'))





