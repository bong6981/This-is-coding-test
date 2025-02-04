import heapq
def solution():
    ## 동빈북 : input = sys.stdin.readline
    INF = int(1e9)
    n, m, c = map(int, input().split())
    distance = [INF] * (n+1)
    graph = [[] for _ in range(n+1)]
    for _ in range(m) :
        x, y, z = map(int, input().split())
        graph[x].append((y, z))
    
    def dijkstra(start) :
        q = []
        heapq.heappush(q, (0, start))
        distance[start] = 0 
        while q:
            print(q)
            print(graph)
            dist, now = heapq.heappop(q)
            if distance[now] < dist :
                continue
            for i in graph[now] :
                cost = dist + i[1]
                if cost < distance[i[0]] :
                    distance[i[0]] = cost
                    heapq.heappush(q, (cost, i[0]))
    
    dijkstra(c)

    maxd = 0
    count = 0
    ## 동빈북 : for d in distance : 
    for i in range(n+1) :
        if distance[i] == INF or distance[i] == 0 :
            continue
        count += 1 
        ## 동빈북 maxd = max(maxd, d)
        if distance[i] > maxd :
            maxd = distance[i]

    return " ".join([str(count), str(maxd)])

print(solution())

'''
3 2 1
1 2 4
1 3 2
결과 2 4 
'''
    
