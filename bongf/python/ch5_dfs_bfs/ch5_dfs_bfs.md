### 스택 
- 파이썬에서 스택은 list의 append(), pop() 을 이용한다 (선입후출)

### 큐 
- 파이썬에서 큐는 deque 자료구조를 활용한다.
- from collections import deque
- 선입선출하려면 popleft를 활용한다. 
- append()(오른쪽에 더하기), appendleft(), pop()(맨오른쪽 수 제거), popleft()

### 재귀함수
-   RecursionError: maximum recursion depth exceeded in comparison.
    -   재귀할 때 가장 많이 등장하는 에러. 재귀의 최대 깊이 초과 에러. 
-   재귀함수의 수행은 스택 자료구조 이용. 가장 마지막에 호출한 함수가 먼저 끝내야 함수 호출 종료 가능 
-   팩토리얼 : 재귀 함수를 이용하는 대표적 예제 
    -   재귀함수는 반복문 대신 사용할 때 매우 간단하게 보인다. 
```python
# 반복적으로 구현한 n!
def factorial_iterative(n):        
    result = 1
    # 1부터 n까지의 수를 차례대로 곱하기
    for i in range(1, n + 1):
       result *= i
    return result

# 재귀적으로 구현한 n!
def factorial_recursive(n):        
    if n <= 1: # n이 1 이하인 경우 1을 반환
        return 1
    # n! = n * (n - 1)!를 그대로 코드로 작성하기
    return n * factorial_recursive(n - 1)

# 각각의 방식으로 구현한 n! 출력(n = 5)
print('반복적으로 구현:', factorial_iterative(5))
print('재귀적으로 구현:', factorial_recursive(5))

```

### DFS 
#### 인접행렬(Adjacency Matirx )
- 2차원 배열로 그래프의 연결 관계를 표현 하는 방식 
![image](https://user-images.githubusercontent.com/73228803/129821748-32682a5a-7ead-4632-9e3a-8cf23ba02130.png)

|  | 0| 1| 2 
|:--:|:--:|:--:|:--:
|0 | 0 | 7 | 5
|1|  7 | 0 || 무한
|2 | 5 | 무한 | 0

```python
INF = 999999999 # 무한의 비용 선언

# 2차원 리스트를 이용해 인접 행렬 표현
graph = [
    [0, 7, 5],
    [7, 0, INF],
    [5, INF, 0]
]

print(graph)
```
#### 인접리스트(Adjacency List)
- 리스트로 그래프의 연결관계를 표현하는 방식 
![image](https://user-images.githubusercontent.com/73228803/129822521-bb830864-37d5-4bf6-a4d0-78f717bbff93.png)
- 이미지 출처 : https://www.google.com/url?sa=i&url=https%3A%2F%2Flaptrinhx.com%2Fadjacency-list-c-4178577820%2F&psig=AOvVaw04M0eKQOGpPjn2zRdmhrgr&ust=1629336864754000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKDXs5-3ufICFQAAAAAdAAAAABAD
- 연결된 노드에 대한 정보를 차례대로 연결하여 저장 
- 자바 Linked List 라이브러리 제공 
- 파이썬은 2차원 리스트로 활용 
```python
# 행(Row)이 3개인 2차원 리스트로 인접 리스트 표현
graph = [[] for _ in range(3)]

# 노드 0에 연결된 노드 정보 저장 (노드, 거리)
graph[0].append((1, 7))
graph[0].append((2, 5))

# 노드 1에 연결된 노드 정보 저장 (노드, 거리)
graph[1].append((0, 7))

# 노드 2에 연결된 노드 정보 저장 (노드, 거리)
graph[2].append((0, 5))

print(graph) ## [[(1,7), (2,5)], [(0,7)], [(0,5)]]
```
- 노드 개수가 많을 수록 인접행렬 메모리 분리 
- 인접리스트는 특정 두 노드가 연결되에 있는지에 대한 정보를 얻는 속도가 느리다.
    -   특정 노드와 연결된 모든 인접 노드를 순회해야 하는 경우 인접 리스트 방식 이용이 메모리 절감에 효율적 

#### DFS
- 재귀함수, 스택으로 구현 
- 1) 탐색시작 노드를 스택에 삽입 -> 방문처리
- 2) 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문처리 
```python
# DFS 함수 정의
def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
graph = [
  [],
  [2, 3, 8],
  [1, 7],
  [1, 4, 5],
  [3, 5],
  [3, 4],
  [7],
  [2, 6, 8],
  [1, 7]
]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * 9

# 정의된 DFS 함수 호출
dfs(graph, 1, visited)
```
#### BFS
- 큐로 구현 
- 코딩테스트에서는 DFS보다는 BFS가 더 빠르다 
```python
from collections import deque

# BFS 함수 정의
def bfs(graph, start, visited):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    # 현재 노드를 방문 처리
    visited[start] = True
    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아 출력
        v = queue.popleft()
        print(v, end=' ')
        # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
graph = [
  [],
  [2, 3, 8],
  [1, 7],
  [1, 4, 5],
  [3, 5],
  [3, 4],
  [7],
  [2, 6, 8],
  [1, 7]
]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * 9

# 정의된 BFS 함수 호출
bfs(graph, 1, visited)
```

