# 사이클 없이 모든 노드가 연결 되어 있다는 조건이 어디있지.. 
def solution() :
    n, m = map(int, input().split())
    p = [0] * (n+1)

    edges = []
    result = 0
    last = 0 

    for i in range(1, n+1):
        p[i] = i

    for _ in range(m) :
        a, b, c = map(int, input().split())
        edges.append((c, a, b))
    
    edges.sort() 

    for edge in edges :
        c, a, b = edge
        if find_p(p, a) != find_p(p, b):
            union(p, a, b)
            result += c 
            last = c 
            
    return result - last




def find_p(p, x):
    if(p[x] != x):
        p[x] = find_p(p, p[x])
    return p[x]

def union(p, a, b):
    a = find_p(p, a)
    b = find_p(p, b)
    if(a<b):
        p[b] = a
    else :
        p[a] = b 

'''
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4 
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
// 결과 8 
'''
print(solution())
