from collections import deque
import copy 

def solution() :
    n = int(input())
    indegree = [0] * (n+1)
    hour = [0] * (n+1)
    graph = [[] for _ in range(n+1)]

    for i in range(1, n+1) :
        info = list(map(int, input().split()))
        hour[i] = info[0]

        # dobin : 
        # for i in info[1:-1] : 
        #   indegree[i] += 1
        #   graph[i].append(i)
        for x in range(1, len(info)-1):
            graph[info[x]].append(i)
            indegree[i] += 1

    result = copy.deepcopy(hour)
    q = deque()
    for i in range(1, n+1):
        if indegree[i] == 0 :
            q.append(i)

    while q :
        now = q.popleft()
        for i in graph[now]:
            result[i] = max(result[i], result[now] + hour[i])
            indegree[i] -= 1
            if indegree[i] == 0 :
                q.append(i)

    for i in range(1, n+1):
        print(result[i])

solution()

'''
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
결과 
10
20
14
18
17
'''
