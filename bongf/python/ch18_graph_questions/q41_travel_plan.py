import sys
input = sys.stdin.readline
n, m = map(int, input().split())
parent = [0] * (n+1)
for i in range(1, n+1):
    parent[i] = i

def find_parent(x):
    if(parent[x] != x):
        parent[x] = find_parent(parent[x])
    return parent[x]

def union(x, y):
    x = find_parent(x)
    y = find_parent(y)
    if x < y : 
        parent[y] = x
    else:
        parent[x] = y

for i in range(1, n+1):
    data = list(map(int, input().split()))
    for j  in range(n):
        if data[j] == 1:
            union(i, j+1)

plan = list(map(int, input().split()))
can_go = True

print(parent)

for i in range(m-1):
    if find_parent(plan[i]) != find_parent(plan[i+1]):
        print(i, i+1)
        can_go = False

if can_go :
    print("YES")
else:
    print("NO")

'''
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0 
2 3 4 3
'''
