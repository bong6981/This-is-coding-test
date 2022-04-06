def solution() :
    n = int(input())
    d = [0] * 1001 

    '''
    dongbin :
    d[1] = 1
    d[2] = 3
    for i in range(3, n+1) :
    '''  
    d[1] = 1
    if(n >= 2) :
        d[2] = 3
        for i in range(3, n+1) :
            d[i] = (d[i-1] + 2 * d[i-2]) % 796796
    return d[n]
        
print(solution())
