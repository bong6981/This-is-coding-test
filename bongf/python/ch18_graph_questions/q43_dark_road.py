import sys
input = sys.stdin.readline

def find_parent(parent, x):
    if(parent[x] != x):
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union(parent, x, y):
    x = find_parent(parent, x)
    y = find_parent(parent, y)
    if x < y :
        parent[y] = x 
    else : 
        parent[x] = y

def solution():
    n, m = map(int, input().split())
    road = []
    parent = [0] * n
    for i in range(n):
        parent[i] = i
    for _ in range(m):
        x, y, z = map(int, input().split())
        road.append((z, x, y))
    
    road.sort()
    result = 0 
    for r in road:
        z, x, y = r
        if find_parent(parent, x) != find_parent(parent, y) :
            union(parent, x, y)
        else:
            result += z
    return result

print(solution())

'''
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
'''
