#https://www.acmicpc.net/problem/14502
#나는 combination으로 3개를 뽑아줬고 동빈쓰는 dfs(재귀)를 이용해서 벽을 세워졌다는 점이 다르다 
'''
def dfs(count):
    global result
    # 울타리가 3개 설치된 경우
    if count == 3:
        for i in range(n):
            for j in range(m):
                temp[i][j] = data[i][j]
        # 각 바이러스의 위치에서 전파 진행
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 2:
                    virus(i, j)
        # 안전 영역의 최대값 계산
        result = max(result, get_score())
        return
    # 빈 공간에 울타리를 설치
    for i in range(n):
        for j in range(m):
            if data[i][j] == 0:
                data[i][j] = 1
                count += 1
                dfs(count)
                data[i][j] = 0
                count -= 1
'''
n, m = map(int, input().split())
## 동빈은 그래프 초기화를 [] 로 해준다음 int list로 한줄씩 받아서 append 해주었다. 
graph = [[0] * m for _ in range(n)]
for i in range(n):
    nums = list(map(int, input().split()))
    for j in range(len(nums)):
        if(nums[j]!=0):
            graph[i][j] = nums[j] 


def get_answer(graph, n, m ):
    virus_graph = [[0] * (m) for _ in range(n)]

    def virus_spread(x, y):
        moves = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        for move in moves:
            newx, newy = move
            newx += x
            newy += y 

            if( 0 <= newx < n and 0 <= newy < m and virus_graph[newx][newy] == 0):
                virus_graph[newx][newy] = 2
                virus_spread(newx, newy)

    for i in range(n) :
        for j in range(m):
           virus_graph[i][j] = graph[i][j]

    for i in range(n) :
        for j in range(m):
            if(virus_graph[i][j] == 2): 
                virus_spread(i,j)

    count = 0
    for i in range(n) :
        for j in range(m):
            if(virus_graph[i][j] == 0): 
                count += 1

    return count



position = []
for i in range(n):
    for j in range(m):
        if(graph[i][j] == 0):
            position.append((i, j))

from itertools import combinations
answer = 0
for c in combinations(position, 3):
    temp = []
    for j in c : 
        x, y = j
        temp.append(graph[x][y]) 
        graph[x][y] = 1
    answer = max(answer, get_answer(graph, n, m))
    for j in c : 
        x, y = j 
        graph[x][y] = temp.pop(0)

print(answer)

