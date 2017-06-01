def comp(s):
    out = ''
    prev = None
    count = 0
    for c in s:
        if c == prev:
            count += 1
        else:
            if count != 0:
                out += prev + str(count)
            count = 1
            prev = c
    out += prev + str(count)
    if len(out) > len(s):
        return s
    return out

print(comp('aabcccccaaa'))
print(comp('abcdf'))
print(comp('afffffffffffffffffffffffffff'))
print(comp('aaaaaaaaaaaaaaaaf'))


