def solution() :
    n, m = map(int, input().split(" "))
    weight = [0] * (m+1)
    balls = list(map(int, input().split(" ")))
    for b in balls : 
        weight[b] += 1
    

    '''
    dongbin : 
    for i in range(1, m+1):
        n -= weight[i]
        result = weight[i] * n 
    '''
    answer = 0 
    for i in range(1, m):
        for j in range(i+1, m+1):
            answer += weight[i] * weight[j]
    
    return answer

print(solution())

'''
5 3 
1 3 2 3 2
## 8 
'''

'''
8 5 
1 5 4 3 2 4 5 2
## 25 
'''
