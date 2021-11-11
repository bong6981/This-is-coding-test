import sys
input = sys.stdin.readline
# https://www.acmicpc.net/problem/2887

def find_p(parents, x):
    if(parents[x] != x):
        parents[x] = find_p(parents, parents[x])
    return parents[x]

def union(parents, x, y):
    x = find_p(parents, x)
    y = find_p(parents, y)
    if x < y :
        parents[y] = x
    else :
        parents[x] = y

def dongbin():
    n = int(input())
    edges = []
    parent = [0] * n
    result = 0 

    x = []
    y = []
    z = []

    for i in range(n):
        x1, y1, z1 = map(int, input().split(" "))
        parent[i] = i
        x.append((x1, i))
        y.append((y1, i))
        z.append((z1, i))

    x.sort()
    y.sort()
    z.sort()

    for i in range(n-1):
        edges.append((x[i+1][0] - x[i][0], x[i][1], x[i+1][1]))
        edges.append((y[i+1][0] - y[i][0], y[i][1], y[i+1][1]))
        edges.append((z[i+1][0] - z[i][0], z[i][1], z[i+1][1]))
    
    edges.sort()
    for edge in edges:
        cost, a, b = edge
        if find_p(parent, a) != find_p(parent, b):
            union(parent, a, b)
            result += cost
    return result

print(dongbin())


# 메모리 초과 
def solution_fail():
    n = int(input())
    planets = [0] * n 
    parent = [0] * n
    for i in range(n):
        x, y, z = map(int, input().split(" "))
        planets[i] = (x, y, z)
        parent[i] = i

    roads = [] 
    for i in range(n-1):
        for j in range(i+1, n):
            x1, y1, z1 = planets[i]
            x2, y2, z2 = planets[j]
            distance = min(abs(x2-x1), abs(y2-y1), abs(z2-z1))
            roads.append((distance, i, j))
    roads.sort()
    result = 0
    for path in roads:
        distance, i, j = path 
        if find_p(parent, i) != find_p(parent, j):
            union(parent, i, j)
            result += distance
    return result
