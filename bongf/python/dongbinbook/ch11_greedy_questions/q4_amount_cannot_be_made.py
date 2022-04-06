from itertools import combinations 
def solution() :
    n = int(input())
    coins = list(map(int, input().split(" ")))
    a = set()
    for i in range(1, n+1):
        for x in list(combinations(coins, i)) :
            a.add(sum(x))
    answer = 1 
    while True : 
        if answer in a : 
            answer += 1
        else :
            break
    
    return answer

def dongbin() : 
    n = int(input())
    data = list(map(int, input().split()))
    data.sort()
    
    target = 1 
    for x in data : 
        print(x, target)
        if target < x :
            break
        else : 
            target += x 


# print(solution())
print(dongbin())

'''
5
3 2 1 1 9
결과값 8 
'''
