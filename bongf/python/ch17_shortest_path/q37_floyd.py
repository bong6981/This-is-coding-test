## 백준 pypy로 제출 - 통과 
## https://www.acmicpc.net/problem/11404
def solution():
    ## 처음에는 최대값을 100001로 해서 틀렸다.
    INF = int(1e9)
    n = int(input())
    m = int(input())
    board = [[INF] * (n+1) for _ in range(n+1)]
    for i in range(1, n+1):
        board[i][i] = 0

    for _ in range(m):
        s, e, c = map(int, input().split(" "))
        board[s][e] = min(board[s][e], c)

    
    for i in range(1, n+1):
        for j in range(1, n+1):
            for k in range(1, n+1):
                board[j][k] = min(board[j][k], board[j][i] + board[i][k]) 

    for i in range(1, n+1):
        for j in range(1, n+1):
            if(board[i][j] < 100001):
                print(board[i][j], end= ' ')
            else:
                print(0, end= ' ')
        print()

solution()

