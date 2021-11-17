## https://www.acmicpc.net/problem/19236
import copy

def solution():
    graph = [[] for _ in range(4)]
    fishes = [() for _ in range(17)]
    for i in range(4):
        input_list = list(map(int, input().split()))
        for j in range(0, 7, 2) :
            ## 해당 위치에 들어갈 숫자, 방향
            graph[i].append((input_list[j], input_list[j+1]-1))
            ## 인덱스를 물고기 번호로 갖는 물고기의 위치 x, u, 방향 
            fishes[input_list[j]] = (i, j//2)
    
    to_eat = graph[0][0][0]
    shark_d = graph[0][0][1]
    shark = (0, 0, shark_d) 
    graph[0][0] = (-1, shark_d)
    fishes[to_eat] = ()
    ate_list = []

    def dfs(graph, shark, fishes, ate):
        graph = copy.deepcopy(graph)
        fishes = copy.deepcopy(fishes)

        graph, fishes = fish_move(graph, fishes)
        to_eat = shark_eat(graph, shark)
        if to_eat==[] :
            ate_list.append(ate)
            return
        sh_old_x = shark[0]
        sh_old_y = shark[1]
        sh_old_d = shark[2]
        for candidate in to_eat:
            x, y = candidate
            new_sh_d = graph[x][y][1]
            fish = graph[x][y][0]
            fishes[fish] = ()
            graph[x][y] = (-1, new_sh_d)
            graph[sh_old_x][sh_old_y] = (0, 0)
            shark = (x, y, new_sh_d)
            ate += fish
            dfs(graph, shark, fishes, ate)
            ate -= fish
            shark = (sh_old_x, sh_old_y, sh_old_d)
            graph[sh_old_x][sh_old_y] = (-1, sh_old_d)
            graph[x][y] = (fish, new_sh_d)
            fishes[fish] = (x, y)
    
    dfs(graph, shark, fishes, to_eat)
    ate_list.sort(reverse=True)
    return ate_list[0]

def fish_move(graph, fishes):
    move = [(-1, 0), (-1, -1), (0,-1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1)]
    for f, fish in enumerate(fishes):
        if fish == () :
            continue
        x, y = fish
        d = graph[x][y][1]
        for i in range(d, d+8):
            ni = i
            if ni > 7:
                ni -= 8
            nx = x + move[ni][0]
            ny = y + move[ni][1]
            if 0<=nx<4 and 0<=ny<4 and graph[nx][ny][0] != -1 :
                graph[x][y] = (f, ni)
                other_fish = graph[nx][ny][0]
                graph[nx][ny], graph[x][y] = graph[x][y], graph[nx][ny]
                fishes[f] = (nx, ny)
                if other_fish != 0 :
                    fishes[other_fish] = (x, y)
                break
    return graph, fishes

def shark_eat(graph, shark):
    move = [(-1, 0), (-1, -1), (0,-1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1)]
    sh_x, sh_y, sh_d = shark
    nx = sh_x
    ny = sh_y
    to_eat = []
    while True:
        nx = nx + move[sh_d][0]
        ny = ny + move[sh_d][1]
        if 0 <= nx < 4 and 0 <= ny < 4:
            if graph[nx][ny][0] != 0 :
                to_eat.append((nx, ny))
        else:
            break
    return to_eat

print(solution())


