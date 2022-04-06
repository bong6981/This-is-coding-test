import heapq

def solution() :
    INF = int(1e9)
    n, m = map(int, input().split())
    distance = [INF] * (n+1)
    graph = [[] for i in range(n+1)]
    
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append((b, 1))
        graph[b].append((a, 1))
    x, k = map(int, input().split())

    def dijkstra(start) :
        q = []
        heapq.heappush(q, (0, start))
        distance[start] = 0
        while q :
            dist, now = heapq.heappop(q)
            if distance[now] < dist :
                continue

            for i in graph[now] :
                cost = dist + i[1]
                if(cost < distance[i[0]]) :
                    distance[i[0]] = cost
                    heapq.heappush(q, (cost, i[0]))


    dijkstra(1)
    answer1 = distance[k]
    if(answer1 == 1e9) :
        return -1
    distance = [INF] * (n+1)
    dijkstra(k)
    answer2 = distance[x]
    if(answer2 == 1e9) :
        return -1
    return answer1 + answer2

# print(solution())

## 나는 다익스트라 최단경로 알고리즘으로 풀었는데 전형적인 플로이드 워셜 알고리즘이라고 해서 다시 품 
def solution2():
    INF = 1e9
    n, m = map(int, input().split())
    graph = [[INF] * (n+1) for _ in range(n+1) ]

    for i in range(1, n+1) :
        graph[i][i] = 0 
    
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a][b] = 1
        graph[b][a] = 1

    x, k = map(int, input().split())
    
    for j in range(1, n+1) :
        for a in range(1, n+1):
            for b in range(1, n+1):
                graph[a][b] = min(graph[a][b], graph[a][j] + graph[j][b])
    '''
    동빈북은 여기서 
    distance = graph[1][k] + graph[k][x]
    if distance >= INF :
        return -1 
    return distance
    ''' 
    a = graph[1][k] 
    b = graph[k][x]
    if(a != INF and b != INF) :
        return a + b
    return -1


print(solution2())

'''
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
결과 3
'''

'''
4 2
1 3
2 4
3 4
결과 -1 
'''
