n = int(input())
a = []

for i in range(n-1):
    exchanged = 0
    for j in range(n-1, i, -1):
        if a[j-1] > a[j]:
            a[j-1], a[j] = a[j], a[j-1]
            exchanged += 1
    if exchanged == 0:
        break
