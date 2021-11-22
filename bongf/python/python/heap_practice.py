import heapq

def basic():
    h = []
    heapq.heappush(h, 4)
    heapq.heappush(h, 2)
    heapq.heappush(h, 1)
    heapq.heappush(h, 5)
    print(h) ## [1, 4, 2, 5]
    x = heapq.heappop(h)
    print(x) ## 1
    print(h) ## [2, 4, 5]

def heapify_practice():
    l = [2, 3, 4, 5, 1]
    heapq.heapify(l)
    print(l) ## [1, 2, 4, 5, 3]

## heapq의 heappush를 할 때 (우선순위, 실제들어갈 값)을 인자로 넣어주면 된다
def max_heap():
    h = []
    ls = [ 1, 2, 3, 4, 5]
    for l in ls :
        heapq.heappush(h, (-l, l)) 
    print(h) ## [(-5, 5), (-4, 4), (-2, 2), (-1, 1), (-3, 3)]
    answer = []
    for x in h :
        answer.append(x[1])
    print(answer) ## [5, 4, 2, 1, 3]


## k번째 최대값 구하기, 최소값 구하기
## - pop을 k번 해주면 된다.
