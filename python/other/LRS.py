def lcp(str1, str2):
    n = min(len(str1), len(str2))
    for i in range(n):
        if str1[i] != str2[i]:
            return str1[0:i]
    return str1[0:n]


def slelectLRS(str):
    suff = []
    for i in range(len(str)):
        suff.append(str[i:])
    suff.sort()
    lrs = ''
    for i in range(len(suff) - 1):
        pref = lcp(suff[i], suff[i + 1])
        if len(pref) > len(lrs):
            lrs = pref
    return lrs

print(slelectLRS('abcabcd'))
print(range(4))
