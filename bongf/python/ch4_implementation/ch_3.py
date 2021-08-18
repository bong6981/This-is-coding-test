def solution() :
    p = input()
    movep = [ [2, 1], [2, -1], [-2, 1], [-2, -1], [1, 2], [1, -2], [-1, 2], [-1, -2]]
    
    x = ord(p[0]) - 96
    ##dobin) x= int(ord([p0]) - ord('a')) + 1
    y = int(p[1])
    cnt = 0
    for c,d in enumerate(movep) :
        nx = x + c
        ny = y + d
        if(1<=nx<=8 and 1<=ny<=8) :
            cnt += 1
    return cnt

print(solution())

