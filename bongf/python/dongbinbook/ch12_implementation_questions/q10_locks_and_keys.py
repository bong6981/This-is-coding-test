import copy 

def solution(key, lock):
    m = len(lock)
    n = len(key)
    graph = [[-2] * (m + (n-1) * 2) for _ in range(m+(n-1)*2)] 
    
    countl = 0
    for x in range(m) : 
        for y in range(m):
            if(lock[x][y]==0) :
                countl += 1
                graph[x+n-1][y+n-1] = 0  
            else : 
                graph[x+n-1][y+n-1] = 1
    if(countl == 0) :
        return True
    
    countk = 0
    kidx = []
    countk, kidx = getkidx(key, n)
    
    if(countl > countk) :
        return False
    
    if(check(countl, m, n, kidx, graph)): 
        return True 
    
    for i in range(3):
        key = rotate(key, n)
        countk, kidx = getkidx(key, n)
        if(check(countl, m, n, kidx, graph)): 
            return True 

    return False


def getkidx(key, n): 
    kidx = []
    countk = 0
    for x in range(n) : 
        for y in range(n):
            if(key[x][y]==1) :
                countk += 1
                kidx.append((x, y))
    return countk, kidx 


def rotate(key, n):
    n = len(key)
    newkey = [[0]*n for _ in range(n)]
    for i in range(n) :   
        for j in range(n):
            if(key[i][j] == 1) :
                newkey[j][n -(i+1)] = 1 
    return newkey 
    
def check(countl, m, n, kidx, graph) :
    for i in range(m+n-1):
        for j in range(m+n-1):
            broken = False 
            tempgraph = copy.deepcopy(graph)
            lock0 = countl
            for x,y in kidx :
                if(tempgraph[x+i][y+j] == 0) :
                    tempgraph[x+i][y+j] += 1
                    lock0 -= 1
                elif(tempgraph[x+i][y+j] == 1) :
                    broken = True 
                    break
            if (not broken and lock0 == 0) :
                return True
    return False  

print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))
print(solution([[1, 1], [1, 1]], [[1, 1, 1], [1, 0, 0], [1, 0, 0]]))
print(solution([[1, 1], [1, 1]], [[1, 1, 1], [1, 1, 1], [1, 1, 1]]))

