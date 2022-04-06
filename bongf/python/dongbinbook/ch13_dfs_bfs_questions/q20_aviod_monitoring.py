# https://www.acmicpc.net/problem/18428
# 동빈은 장애물 설치를 combination을 활용 https://github.com/ndb796/python-for-coding-test/blob/master/13/6.py
def monitor(x, y):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        while (0<=nx<n and 0<=ny<n):
            if temp[nx][ny] == 'O':
                break
            if temp[nx][ny] == 'S':
                return False
            nx += dx[i]
            ny += dy[i]
    return True

def dfs(count):
    if(count == 3) :
        for i in range(n):
            for j in range(n):
                temp[i][j] = graph[i][j]

        for i in range(n):
            for j in range(n):
                if(temp[i][j] == 'T'):
                    if not monitor(i, j) :
                        return False
        return True
   
    for x in range(n):
        for y in range(n):
            if graph[x][y] == 'X' :
                count += 1 
                graph[x][y] =  'O'
                if dfs(count) :
                    return True
                graph[x][y] = 'X'
                count -= 1
    return False

n = int(input())
graph = []
student_count = 0 
for i in range(n):
    graph.append(input().split())
    for j in range(n):
        if(graph[i][j] == 'S'):
            student_count += 1 
temp = [['X'] * n for _ in range(n)]
if dfs(0) :
    print('YES')
else:
    print('NO')







