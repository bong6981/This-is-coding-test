# 절반 나눈다는 의미를 빼먹음 (앞에서부터 개수에 상관없이 값만 절반만 되면 되는 것으로 계산)
def solution() :
    data = list(map(int, input()))

    t = 0 
    for d in data :
        t += d 
    
    t /= 2 
    s = 0
    for d in data :
        s += d 
        if ( s == t) :
            return "LUCKY"
        if ( s > t) :
            return "READY"


print(solution())

def dongbin() :
    n = input()
    length = len(n)
    sum = 0 

    for i in range(length//2) :
        sum += int(n[i])
    
    for i in range(length//2, length):
        sum -= int(n[i])
    
    if sum == 0 :
        return "LUCKY"
    return "READY"

'''
123402
LUCKY
7755
READY 
'''
