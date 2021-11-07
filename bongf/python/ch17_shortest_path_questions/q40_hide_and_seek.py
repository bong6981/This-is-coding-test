import heapq
def solution():
    INF = int(1e9)
    n, m = map(int, input().split(" "))
    path = [[] for _ in range(n+1)]
    for _ in range(m):
        x, y = map(int, input().split(" "))
        path[x].append((y,1))
        path[y].append((x,1))

    d = [INF] * (n+1)
    d[0] = 0

    q = []
    heapq.heappush(q, (0, 1))
    d[1] = 0
    while q:
        distance, now = heapq.heappop(q)
        if(d[now] < distance):
            continue
        for des in path[now]:
            cost = distance + des[1]
            if(cost < d[des[0]]):
                d[des[0]] = cost
                heapq.heappush(q, (cost, des[0]))
    
    '''
    내가 쓴 방법은 어찌되었든 for문을 2번 도는 형식인데 
    동빈이는 for문을 한 번 도는 것으로 해결 
    max_node = 0
    max_distance = 0
    result = []
    for i in range(1, n+1):
        if max_distance < d[i] :
            max_distance = d[i]
            max_node = i
            result = [max_node]
        elif max_distance == d[i]:
            result.append(i)
    print(max_node, max_distance, len(result))
    max_node를 바로 아웃해도 어차피 순서대로 for문을 도니까 제일 먼 노드 중에서 제일 작은 인덱스가 출력된다.
    '''
    answer_dis = max(d)
    to_hide = []
    for i in range(len(d)):
        if(d[i] == answer_dis) :
            to_hide.append(i)
    
    to_hide.sort()
    print(to_hide[0], end=" ")
    print(answer_dis, end=" ")
    print(len(to_hide))
        


solution()

'''
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
'''
