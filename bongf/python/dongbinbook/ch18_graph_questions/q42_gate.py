def solution():
    g = int(input())
    p = int(input())
    d = [0] * (g+1) 
    cnt = 0 
    for _ in range(p):
        x = int(input())
        can = False
        for i in range(x, 0, -1):
            if d[i] != 1 :
                d[i] = 1 
                can = True
                cnt += 1
                break
        
        if not can :
            break
    return cnt


def find_p(parent, x):
    if(parent[x] != x):
        parent[x] = find_p(parent, parent[x])
    return parent[x]

def union(parent, x, y):
    x = find_p(parent, x)
    y = find_p(parent, y)
    if( x < y):
        parent[y] = x
        return 
    parent[x] = y

def dongbin():
    g = int(input())
    p = int(input())
    parent = [0] * (g+1)
    for i in range(1, g+1):
        parent[i] = i
    
    result = 0 
    for _ in range(p):
        data = find_p(parent, int(input()))
        if data == 0 :
            break
        union(parent, data, data-1)
        result += 1
    return result 
    
print(solution())
# print(dongbin())



'''
4
3
4
1
1
//2
'''
'''
4
6
2
2
3
3
4
4
//3
'''


