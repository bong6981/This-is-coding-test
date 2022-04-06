## https://www.acmicpc.net/problem/1932
def solution() :
    n = int(input())
    now = list(map(int, input().split(" ")))
    prev = now

    for i in range(1, n):
        now = list(map(int, input().split(" ")))
        for j in range(len(now)) :
            if(j==0):
                now[j] = prev[0] + now[j]
            elif (j==len(now)-1):
                now[j] = prev[-1] + now[j]
            else :
                now[j] = max(prev[j-1], prev[j]) + now[j]
        prev = now
    
    return max(now)

print(solution())

        