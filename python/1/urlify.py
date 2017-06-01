def url(s):
    pos = set()
    for i in range(len(s)):
        if s[i] == ' ':
            pos.add(i)
    newLen = len(s) + len(pos)*2
    nStr = [None] * newLen
    j = newLen - 1
    for i in reversed(range(len(s))):
        if i in pos:
            nStr[j] = '0'
            nStr[j - 1] = '2'
            nStr[j - 2] = '%'
            j -= 3
        else:
            nStr[j] = s[i]
            j -= 1
    return ''.join(nStr)

print(url('test string 3  4'))


def url2(s):
    return s.replace(' ', '%20')

print(url2('test string 3  4'))
