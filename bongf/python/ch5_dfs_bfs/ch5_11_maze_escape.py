from collections import deque as dq 

## bfs의 레벨별로 cnt를 세기 위해 new_moving을 만들었다. 
def solution() :
    n, m = map(int, input().split())
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input())))
    move = [[0,1], [1,0], [0,-1], [-1,0]]

    cnt = 1
    moving = [[0,0]]
    new_moving = [] 
    while True :
        if(len(moving) == 0) :
            moving = new_moving
            cnt += 1
            if(len(moving) == 0):
                break
        x, y = moving[0]
        if(x==n-1 and y==m-1) :
            break
        moving = moving[1:]
        arr[x][y] = 1
        for mx, my in move :
            nx = x + mx
            ny = y + my
            if( 0<=nx< n and 0<=ny<m and arr[nx][ny]==1 and [nx,ny] not in moving ) :
                new_moving.append([nx, ny])

    return cnt

from collections import deque 
def dongbin() :
    n, m = map(int, input().split())
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input())))

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    def bfs(x, y) :
        queue = deque()
        queue.append((x,y))

        while queue:
            x, y = queue.popleft
            for i in range(4) :
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or ny < 0 or nx >= n or ny >= m :
                    continue
                if arr[nx][ny] == 0 :
                    continue
                if arr[nx][ny] == 1:
                    arr[nx][ny] = arr[x][y] + 1
                    queue.append((nx,ny))
        return arr[n-1][m-1]
    print(bfs(0,0))

print(solution())


'''
5 6
101010
111111
000001
111111
111111
결과는 10
'''

