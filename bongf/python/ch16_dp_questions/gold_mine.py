def solution():
    t = int(input())
    answer = [] 
    for _ in range(t):
        n, m = map(int, input().split(" "))
        board = [[] * m for _ in range(n)]
        inputs = list(map(int, input().split()))
        for i, c in enumerate(inputs) :
            x = i // m
            board[x].append(c)

        for i in range(1, m):
            for j in range(0, n):
                y = i - 1
                v = board[j][i]
                for x in range(j-1, j+2):
                    if(0<= x < n) :
                        v = max(v, board[x][y] + board[j][i])
                board[j][i] = v
        
        ans = 0
        for i in range(n):
            ans = max(ans, board[i][m-1])
        answer.append(ans)
    for i in answer:
        print(i)


def dongbin() : 
    for tc in range(int(input())):
    # 금광 정보 입력
        n, m = map(int, input().split())
        array = list(map(int, input().split()))

        # 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
        ## 동빈 풀이가 더 가시적이다 
        dp = []
        index = 0
        for i in range(n):
            dp.append(array[index:index + m])
            index += m
        
        # print(dp)

        # 다이나믹 프로그래밍 진행
        for j in range(1, m):
            for i in range(n):
                # 왼쪽 위에서 오는 경우
                if i == 0:
                    left_up = 0
                else:
                    left_up = dp[i - 1][j - 1]
                # 왼쪽 아래에서 오는 경우
                if i == n - 1:
                    left_down = 0
                else:
                    left_down = dp[i + 1][j - 1]
                # 왼쪽에서 오는 경우
                left = dp[i][j - 1]
                dp[i][j] = dp[i][j] + max(left_up, left_down, left)

        result = 0
        for i in range(n):
            result = max(result, dp[i][m - 1])

        print(result)

'''
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
'''

solution()
# dongbin()
