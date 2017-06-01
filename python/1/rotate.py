def rotate(m):
    for i in range(len(a)):
        for j in range(i+1, len(a)):
            t = m[i][j]
            m[i][j] = m[j][i]
            m[j][i] = t


def rotate2(m):
    return [[row[i] for row in m] for i in range(len(m))]

a = [[y for y in range(8)] for x in range(8)]
print(a)
rotate(a)
print(a)
print(rotate2(a))
print(a[0:8][0:8])
