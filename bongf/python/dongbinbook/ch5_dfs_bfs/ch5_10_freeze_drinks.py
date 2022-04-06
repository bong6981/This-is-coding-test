def solution() :
    n, m = map(int, input().split())
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input())))
        
    move = [[-1, 0], [1,0], [0, -1], [0,1]]

    def check_ice(i, j) :
        arr[i][j] = 1
        for x,y in move :
            if( 0<=i+x<= n-1 and 0<=j+y<=m-1 and arr[i+x][j+y] == 0) :
                check_ice(i+x, j+y)

    cnt = 0 
    for i in range(n):
        for j in range(m):
            if(arr[i][j] == 0) :
                cnt += 1
                check_ice(i, j)
    return cnt

print(solution())

'''
15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
'''

def dongbin() : 
    # N, M을 공백을 기준으로 구분하여 입력 받기
    n, m = map(int, input().split())

    # 2차원 리스트의 맵 정보 입력 받기
    graph = []
    for i in range(n):
        graph.append(list(map(int, input())))

    # DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
    def dfs(x, y):
        # 주어진 범위를 벗어나는 경우에는 즉시 종료
        if x <= -1 or x >= n or y <= -1 or y >= m:
            return False
        # 현재 노드를 아직 방문하지 않았다면
        if graph[x][y] == 0:
            # 해당 노드 방문 처리
            graph[x][y] = 1
            # 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y)
            dfs(x, y - 1)
            dfs(x + 1, y)
            dfs(x, y + 1)
            return True
        return False

    # 모든 노드(위치)에 대하여 음료수 채우기
    result = 0
    for i in range(n):
        for j in range(m):
            # 현재 위치에서 DFS 수행
            if dfs(i, j) == True:
                result += 1

    print(result) # 정답 출력
