from collections import deque

## https://www.acmicpc.net/problem/3665
def dongbin():
    for tc in range(int(input())):
        n = int(input())
        indegree = [0] * (n+1)
        graph = [[False] * (n+1) for _ in range(n+1)]

        data = list(map(int, input().split()))
        for i in range(n):
            for j in range(i+1, n):
                graph[data[i]][data[j]] = True
                indegree[data[j]] += 1
        
        m = int(input())
        for i in range(m):
            x, y = map(int, input().split())
            if graph[x][y]:
                graph[y][x] = True
                graph[x][y] = False
                indegree[x] += 1
                indegree[y] -= 1 
            else:
                graph[x][y] = True
                graph[y][x] = False
                indegree[x] -= 1
                indegree[y] += 1
        
        result = []
        q = deque()

        for i in range(1, n+1):
            if indegree[i] == 0:
                q.append(i)
        
        certain = True
        cycle = False

        for i in range(n):
            if len(q) == 0: 
                cycle = True
                break
                
            if len(q) >= 2 :
                certain = False
                break
            
            now = q.popleft()
            result.append(now)

            for j in range(1, n+1):
                if graph[now][j]:
                    indegree[j] -= 1
                    if indegree[j] == 0 :
                        q.append(j)
        
        if cycle: 
            print("IMPOSSIBLE")
        elif not certain:
            print("?")
        else:
            for i in result:
                print(i, end=" ")
            print()

dongbin()
