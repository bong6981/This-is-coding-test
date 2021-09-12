def solution() :
    n, m = map(int, input().split(" "))
    p = [0] * (n+1)
    for i in range(1, n+1):
        p[i] = i 
    
    for _ in range(m) :
        x, a, b = map(int, input().split(" "))
        if ( x == 0 ) :
            union(p, a, b)
        else :
            if(find_p(p, a) == find_p(p, b)) :
                print("YES")
            else:
                print("NO")


def find_p(p, x):
    if(p[x] != x) :
        p[x] = find_p(p, p[x])
    return p[x]

def union(p, a, b):
    a = find_p(p, a)
    b = find_p(p, b)
    if ( a < b) :
        p[b] = a 
    else :
        p[a] = b 

'''
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
결과 
NO
NO
YES 
'''

solution()
