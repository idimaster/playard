def zero(m):
    rows = set()
    cols = set()
    for i in range(len(m)):
        for j in range(len(m[0])):
            if m[i][j] == 0:
                rows.add(i)
                cols.add(j)
    for i in rows:
        for j in range(len(m[0])):
            m[i][j] = 0
    for j in cols:
        for i in range(len(m)):
            m[i][j] = 0

a = [[y + 1 for y in range(8)] for x in range(8)]
zero(a)
print(a)
a[1][1]=0
a[2][5]=0
print(a)
zero(a)
print(a)
