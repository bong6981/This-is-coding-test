## 시간초과 
def solution():
    n, k = map(int, input().split())
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))
    s, x, y = map(int, input().split())

    time = 0
    # 상, 우, 하, 좌
    moves = [(-1, 0), (0, 1), (1,0), (0, -1)]
    while time != s : 
        temp = []
        for i in range(n):
            for j in range(n):
                if(graph[i][j] == 0):
                    value = 0 
                    for move in moves :
                        nx, ny = move
                        newx = i + nx
                        newy = j + ny
                        if(0<=newx<n and 0<= newy < n and graph[newx][newy] != 0):
                            if(value == 0):
                                value = graph[newx][newy]
                            else:
                                value = min(value, graph[newx][newy])
                    temp.append([i, j, value])
        for i, j, value in temp : 
            graph[i][j] = value
        time += 1

    return graph[x-1][y-1]

from collections import deque
def dongbin():
    n, k = map(int, input().split())
    graph = []

    # 동빈쓰는 바이러스에 대한 정보를 따로 담음 
    data = []
    for i in range(n):
        graph.append(list(map(int, input().split())))
        for j in range(n):
            if graph[i][j] != 0 :
                #바이러스의 종류, 시간, 위치x, 위치y 
                data.append((graph[i][j], 0, i, j))
    #바이러스의 레벨이 낮은 순으로 정렬
    data.sort()
    #하나씩 빼줘야 되서 queue 
    q = deque(data)

    targets, targetx, targety = map(int, input().split())

    time = 0
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]         
    while q: 
        virus, s, x, y = q.popleft()
        if(s==targets):
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if(0<=nx<n and 0<=ny<n):
                if graph[nx][ny] == 0 :
                    graph[nx][ny] = virus
                    q.append([virus, s+1, nx, ny])
    return graph[targetx-1][targety-1]

# print(solution())
print(dongbin())

