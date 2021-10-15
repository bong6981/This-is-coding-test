# https://www.acmicpc.net/problem/18352

from collections import deque

# 동빈북과 내 풀이가 다 2%에서 걸린다 
def solution() :
    n, m, k, x = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b) 
    
    visited = [False] * (n+1)
    answer = []

    def run(v, depth, k) :
        new_level = 0 
        q = deque([v])
        visited[v] = True
        element_in_same_level =  1

        while q:
            if(depth==k):
                return list(q)

            x = q.popleft()
            for i in graph[x]:
                if not visited[i]:
                    new_level += 1
                    q.append(i)
                    visited[i] = True
                  
            element_in_same_level -= 1
            if(element_in_same_level == 0):
                element_in_same_level = new_level
                new_level = 0 
                depth += 1 
            
    answer = run(x, 0, k)
    if(answer == None):
        print(-1)
    elif(len(answer) == 0) :
        print(-1)
    else :
        for i in answer:
            print(i)

# solution()


# 난 visited로 최단 거리를 체크했는데 동빈은 최단거리를 저장하는 distance = [] 를 만들었다. 
def dongbin():
    n, m, k, x = map(int, input().split())
    graph = [[] for _ in range(n + 1)]

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)

    # 여기가 다르다 : 모든 도시에 대한 최단 거리 초기화
    distance = [-1] * (n + 1)
    distance[x] = 0 # 출발 도시까지의 거리는 0으로 설정

    # 너비 우선 탐색(BFS) 수행
    q = deque([x])
    while q:
        now = q.popleft()
        # 현재 도시에서 이동할 수 있는 모든 도시를 확인
        for next_node in graph[now]:
            # 아직 방문하지 않은 도시라면
            if distance[next_node] == -1:
                # 최단 거리 갱신
                distance[next_node] = distance[now] + 1
                q.append(next_node)

    # 최단 거리가 K인 모든 도시의 번호를 오름차순으로 출력
    check = False
    for i in range(1, n + 1):
        if distance[i] == k:
            print(i)
            check = True

    # 만약 최단 거리가 K인 도시가 없다면, -1 출력
    if check == False:
        print(-1)

print(dongbin())
