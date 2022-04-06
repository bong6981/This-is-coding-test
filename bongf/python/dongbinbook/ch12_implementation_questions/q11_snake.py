# https://www.acmicpc.net/problem/3190

from collections import deque
def solution() :
    n = int(input())
    k = int(input())

    graph = [[0]*n for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        graph[x-1][y-1] = 4 
    
    # 이렇게 했을 때 런타임 에러 
    # turn = [''] * 1000
    # l = int(input())
    # for _ in range(l):
    #     x, d = input().split()
    #     turn[int(x)] = d 
    
    turn = []
    l = int(input())
    for _ in range(l):
        x, d = input().split()
        turn.append((int(x),d))
    
    p = [0, 0]
    snake = deque(p)
    move = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    move_idx = 0 
    second = 0
    graph[0][0] = 1 
    while True :
        newx = p[0] + move[move_idx][0]
        newy = p[1] + move[move_idx][1]
        second += 1

        ## len(snake) >= 2 이 조건을 생각하지 못해서 고생 
        if( 0 <= newx < n and 0 <= newy < n and graph[newx][newy] != 1) :
            if(graph[newx][newy] != 4 and len(snake) >= 2):
                todeletex = snake.popleft()
                todeletey = snake.popleft()
                graph[todeletex][todeletey] = 0 
            graph[newx][newy] = 1 
            p = [newx, newy]
            snake.append(newx)
            snake.append(newy)
            
            if(turn != [] and second == turn[0][0]):
                if(turn[0][1] == 'D'):
                    move_idx += 1 
                    if(move_idx == 4):
                        move_idx = 0 
                else :
                    move_idx -= 1 
                    if(move_idx == -1):
                        move_idx = 3
                turn.pop(0)
        else :
            break
    print(second)

solution()
'''
2
1
1 2
1
1 D
'''

# graph = [[0]*2 for _ in range(2)]
# n = 2
# newx = 3 
# newy = 3
# print( 0<newx<n and 0<newy<n and graph[newx][newy] != 1)

'''
5
2
2 5
2 4
6
4 D
5 D
6 D
7 D
8 D
9 D
결과 14 
'''
