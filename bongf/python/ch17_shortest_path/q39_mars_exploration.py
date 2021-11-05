import heapq
import sys
def solution():
    t = int(input())
    for _ in range(t):
        print(exploration_floyid())

def exploration_floyid():
    INF = int(1e9)
    n  = int(input())
    board = []
    for i in range(n):
        board.append(list(map(int, input().split(" "))))
            
    path = [[INF] * (n**2) for _ in range(n**2)]
    
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    for i in range(n):
        for j in range(n):
            s = i * n + j 
            for m in range(4):
                ni = i + dx[m]
                nj = j + dy[m]
                if(0<= ni < n and 0 <= nj < n):
                    e = ni * n + nj
                    path[s][e] = board[i][j]
    
    q = []
    heapq.heappush(q, (0, 0))
    distance = [INF] * (n ** 2)
    distance[0] = 0
    while q:
        dist, now = heapq.heappop(q)
        # print(dist, now)
        # print(path[now])
        if distance[now] < dist:
            continue
        destinations = path[now]
        for des, d in enumerate(destinations):
            cost = dist + d
            if distance[des] > cost :
                distance[des] = cost
                # print("update", cost, des)
                heapq.heappush(q, (cost, des))
    # print(distance)
    return distance[n**2 -1] + board[n-1][n-1]

def dongbin():
    input = sys.stdin.readline
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    for tc in range(int(input())):
        n = int(input())
        graph = []
        for i in range(n):
            graph.append(list(map(int, input().split())))
    
        INF = int(1e9)
        distance = [[INF] * n for _ in range(n)]
        x, y = 0, 0
        q = [(graph[x][y], x, y)]
        while q:
            dist, x, y = heapq.heappop(q)
            if distance[x][y] < dist : 
                continue

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if not (0<= nx < n and 0 <= ny < n):
                    continue
                cost = dist + graph[nx][ny]
                if(cost < distance[nx][ny]):
                    distance[nx][ny] = cost
                    heapq.heappush(q, (cost, nx, ny))

        print(distance[n-1][n-1])


solution()
# dongbin()
# 최대 노드의 개수 15625
# 확인해야 하는 경로의 개수 24417196
# print(125 * 125 * 10) ## 15625 
# print(15626 ** 2) ## 244171876
'''
1
3
5 5 4
3 9 1
3 2 7
'''
'''
1
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
'''
'''
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
'''
