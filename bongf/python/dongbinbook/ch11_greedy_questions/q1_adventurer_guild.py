def solution() :
    n = int(input())
    ps = list(map(int, input().split()))
    ps.sort()
    result = 0 
    count = 0
    s = 0 
    '''
    dongbin :
    for i in data :
        count += 1 
        if count >= i:
            result += 1
            count = 0 
    '''
    for p in ps :
        if count == 0 :
            s = p
        if p >= s : 
            count +=1 
            s = p 
        if count == s :
            result += 1
            count = 0 
    return result

print(solution())

'''
5
2 3 1 2 2
결과 2 
''' 
        