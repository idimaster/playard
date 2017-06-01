# interpretations of a number string?
#a=1,b=2,…,z=26

#“11” = 2 (aa, k)
#“111” = 3 (aaa, ak, ka)
#'90' = 0
#'20' = 1 (t)


def getNumber(str):
    if len(str) == 0:
        return 1
    c = int(str[0])
    c2 = int(str[:2])
    count = 0
    if 0 < c <= 26 and len(str) >= 1:
        count += getNumber(str[1:])
    if 0 < c2 <= 26 and len(str) >= 2:
        count += getNumber(str[2:])
    return count

print(getNumber('111'))
print(getNumber('11'))
print(getNumber('90'))
print(getNumber('20'))
print(getNumber('123'))
print(getNumber('123456789'))
print(getNumber('1212121212'))
