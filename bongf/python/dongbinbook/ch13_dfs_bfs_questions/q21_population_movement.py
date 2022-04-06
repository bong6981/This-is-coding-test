from collections import deque

## dfs를 queue로 개선해줘도 시간 초과, 그리고 동빈이 같이 해도 시간초과  
n, l, r = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def find_union(x, y) :
    arr = [(x, y)]
    visited[x][y] = True 
    q = deque()
    q.append((x,y))
    todivde = graph[x][y]
    count = 1 

    while q : 
        x, y = q.popleft() 
        for m in range(4):
            nx = x + dx[m]
            ny = y + dy[m]

            if(0<=nx<n and 0<=ny<n):
                if not visited[nx][ny] and (l <= abs(graph[x][y] - graph[nx][ny]) <= r):
                    visited[nx][ny] = True
                    arr.append((nx, ny))
                    q.append((nx,ny))
                    todivde += graph[nx][ny]
                    count += 1 
    
    for x in arr : 
        i, j = x 
        graph[i][j] = todivde // count
    
    return arr 


day = 0

while True :
    visited = [[False] * n for _ in range(n)]
    unions = []
    for i in range(n):
        for j in range(n):
            if not visited[i][j] :
                union = find_union(i, j)
                if len(union) >= 2 :
                    unions.append(union)
    if unions == [] :
        break
    day += 1

print(day)


# n, l, r = map(int, input().split())
# graph = []
# for _ in range(n):
#     graph.append(list(map(int, input().split())))

# def find_union(x, y) :
#     arr = [(x, y)]
#     dx = [-1, 0, 1, 0]
#     dy = [0, 1, 0, -1]
#     visited[x][y] = True 

#     for m in range(4):
#         nx = x + dx[m]
#         ny = y + dy[m]
#         if(0<=nx<n and 0<=ny<n):
#             if(l <= abs(graph[x][y] - graph[nx][ny]) <= r) and not visited[nx][ny]:
#                 arr.extend(find_union(nx, ny))
#     return arr

# day = 0

# while True :
#     visited = [[False] * n for _ in range(n)]
#     unions = [] 
#     index = 0 
#     for i in range(n):
#         for j in range(n):
#             if not visited[i][j] :
#                 union = find_union(i, j)
#                 if len(union)>= 2 :
#                     unions.append(union)

#     if index == n * n :
#         break 

#     if unions == [] :
#         break

#     for union in unions :
#         todivde = 0 
#         for x,y in union : 
#             todivde += graph[x][y]
#         if(todivde == 0):
#             continue
#         average = todivde // len(union)
#         for x,y in union :
#             graph[x][y] = average
#     day += 1

# print(day)
