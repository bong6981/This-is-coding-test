from collections import deque
def solution():
    s = int(input())
    graph = []
    x = -1
    y = -1
    for i in range(s):
        new_line = list(map(int, input().split(" ")))
        graph.append(new_line)
        for j in range(s):
            if new_line[j] == 9 :
                x = i
                y = j
    time = 0
    graph[x][y] = 0
    size = 2
    ate = 0
    # print(graph)
    while True:
        r = find_possible_route(graph, (x, y), size)
        # print(r)
        if r == None : 
            break
        n_time, nx, ny = r
        time += n_time
        ate += 1
        if(ate == size) :
            size += 1
            ate = 0
        graph[nx][ny] = 0 
        x = nx
        y = ny
        # print("=======")
        # print(graph)
        # print(size)
        # print((x, y))
        # print(ate)
    return time 

def find_possible_route(graph, start_position, size):
    graph_size = len(graph)
    x, y = start_position
    visited = [[0] * graph_size for _ in range(graph_size)]
    visited[x][y] = -1
    time = 0
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    q = deque()
    q.append((time, x, y))
    ## bfs 이렇게 쓰는 것이 맞는지 확인하기
    possible_routes = []
    while q:
        time, x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            n_time = time + 1
            # print(nx, ny)
            if 0<=nx<graph_size and 0<=ny<graph_size and visited[nx][ny] != -1 :
                # print(size)
                if graph[nx][ny] == size or graph[nx][ny] == 0 :
                    q.append((n_time, nx, ny))
                    # print(q)
                    visited[nx][ny] = -1 
                    continue
                if graph[nx][ny] < size :
                    possible_routes.append((n_time, nx, ny))
                    # print(possible_routes)
                    visited[nx][ny] = -1 
    if len(possible_routes) == 0 :
        return None
    possible_routes.sort()
    # print(possible_routes)
    return possible_routes[0]
             
print(solution())
