def solution():
    n = int(input())
    soldiers = list(map(int, input().split(" ")))
    dp = [1] * n
    maxV = 1
    for i in range(n):
        for j in range(0, i) :
            if(soldiers[j] > soldiers[i]) :
                dp[i] = max(dp[i], dp[j] + 1)
                maxV = max(maxV, dp[i])
    return n - maxV

def dongbin() :
    n = int(input())
    soldiers = list(map(int, input().split(" ")))
    # 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
    soldiers.reverse()
    dp = [1] * n

    # 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
    for i in range(1, n):
        for j in range(0, i):
            if soldiers[j] < soldiers[i]:
                dp[i] = max(dp[i], dp[j] + 1)
    
    # 열외해야 하는 병사의 최소 수를 출력
    print(n - max(dp))


print(solution())
