def solution():
    x = [0] + list(input())
    y = [0] + list(input())
    n = len(x)
    m = len(y)
    dp = [[0] * (n) for _ in range(m)]
    for i in range(1, n):
        dp[0][i] = i

    for i in range(1, m):
        dp[i][0] = i

    for i in range(1, m):
        for j in range(1, n):
            if x[j] != y[i] :
                dp[i][j] = min(dp[i-1][j-1]+1, dp[i-1][j]+1, dp[i][j-1]+1)
            if x[j] == y[i] :
                dp[i][j] = dp[i-1][j-1] 

    return dp[m-1][n-1]

print(solution())
