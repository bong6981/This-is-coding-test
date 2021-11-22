p = [[2, 2, 2], [2, 2, 1], [1,2,3], [1, 3, 2]]
p.sort(key=lambda x: (x[0], -x[1], x[2]))
print(p)
