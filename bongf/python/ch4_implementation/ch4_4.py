def solution() :
    h, w = map(int, input().split())
    x, y, d = map(int, input().split())
    
    arr = [[0] * w for _ in range(h)]
    for i in range(h):
        arr[i] = list(map(int, input().split()))
    
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    cnt = 1
    turn_c = 0 
    while True :
        if turn_c == 4 :
            lx = x - dx[d]
            ly = y - dy[d]
            if 0 <= lx <=h and 0 <= ly <= w and arr[lx][ly] == 0 :
                x = lx
                y = ly 
                cnt += 1
                turn_c = 0 
                ##continue 왜 들어가야할까? 
            else :
                break
        arr[x][y] = 1
        d = 3 if d == 0 else d-1
        lx = x + dx[d]
        ly = y + dy[d]
        turn_c += 1
        if 0 <= lx <=h and 0 <= ly <= w and arr[lx][ly] == 0 :
            x, y = lx, ly
            cnt += 1
            turn_c = 0
    return cnt

print(solution())



