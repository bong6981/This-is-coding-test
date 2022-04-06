def solution():
    n, m, k = map(int, input().split())
    ## 방향, 위치 x,  위치 y 
    sharks = [[] for _ in range(m+1)]
    ## 냄새 인덱스, 남은 초
    graph = []
    sharks_cnt = m
    time = 0
    for i in range(n):
        to_append = []
        for j, num in enumerate(list(map(int, input().split()))):
            if num == 0 :
                to_append.append([0, 0])
            else:
                sharks[num] = [0, i, j]
                to_append.append([num, k])
        graph.append(to_append)
    
    for i, d in enumerate(list(map(int, input().split()))):
        sharks[i+1][0] = d
    
    d_piority = [[] for _ in range(m+1)]
    for i in range(1, m+1):
        arr = [[]]
        for j in range(1, 5):
            arr.append(list(map(int, input().split())))
        d_piority[i] = arr

    moves = [(), (-1, 0), (1, 0), (0,-1), (0, 1)]
    can_end = True
    while sharks_cnt > 1 : 
        ## find_position 
        ## 샥스 번호에 따른 위치, 방향
        possible_position = [() for _ in range(m+1)]
        ## 아무 냄새가 없는 칸 찾기 
        for i in range(1, m+1):
            if sharks[i]  == []:
                continue
            no_smell = False
            i_d = sharks[i][0]
            for j in d_piority[i][i_d] :
                nx = sharks[i][1] + moves[j][0]
                ny = sharks[i][2] + moves[j][1]
                if 0<= nx < n and 0 <= ny < n :
                    if graph[nx][ny] == [0, 0] :
                        possible_position[i] = (nx, ny, j)
                        no_smell = True
                        break
            if not no_smell:
                for j in d_piority[i][i_d]:
                    nx = sharks[i][1] + moves[j][0]
                    ny = sharks[i][2] + moves[j][1]
                    if 0<= nx < n and 0 <= ny < n :
                        if graph[nx][ny][0] == i:
                            possible_position[i] = (nx, ny, j)
                            break
        ## 상어 먼저 이동
        new_graph = [[[0, 0] for _ in range(n) ]for _ in range(n)]
        for i in range(1, m+1):
            if possible_position[i] == ():
                continue
            x, y, d = possible_position[i]
            if new_graph[x][y] == [0, 0] :
                new_graph[x][y] = [i, k]
                sharks[i] = [d, x, y]
            else:
                sharks[i] = []
                sharks_cnt -= 1

        ## 냄새 1만큼씩 줄이며 이동 
        for i in range(n):
            for j in range(n):
                if new_graph[i][j] == [0, 0] :
                    if graph[i][j] == [0, 0] or graph[i][j][1] == 1:
                        continue
                    new_graph[i][j] = [graph[i][j][0], graph[i][j][1]-1]

        graph = new_graph
        time += 1
        if time > 1000 :
            can_end = False
            break
    
    if not can_end :
        return -1
    return time

print(solution())
