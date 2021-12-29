# https://www.acmicpc.net/problem/2110
def solution():
    n, c = map(int, input().split())
    homes = []
    for _ in range(n):
        homes.append(int(input()))
    homes.sort()

    start = 1
    end = homes[n-1] - homes[0]
    result = 0
    while start<= end :
        mid = (start+end) //2
        cnt = 1
        prev = homes[0]
        for i in range(1, n):
            if homes[i] - prev >= mid :
                cnt += 1
                prev = homes[i]
        if cnt >= c :
            start = mid + 1
            result = mid
        else:
            end = mid - 1
    return result

print(solution())
