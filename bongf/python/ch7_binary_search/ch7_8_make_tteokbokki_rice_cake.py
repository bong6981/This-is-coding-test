import sys
# 이문제에 대한 해설 ch7_binary_search.md에 작성 
def solution() :
    n, require = map(int, input().split())
    arr = list(map(int, sys.stdin.readline().rstrip().split()))
    arr.sort(reverse=True)
    answer = 0 

    h = 0
    for i in range(20) :
        total = 0
        for l in arr :
            if(l-h <= 0) :
                break
            else :
                total += l-h
        if(total < require) : 
            break
        else :
            answer = h
            h += 1
    return answer

def dongbin() :
    n, m = map(int, input().split())
    array = list(map(int, input().split()))

    start = 0
    end = max(array)
    
    result = 0
    while(start<= end):
        total = 0
        mid = ( start + end) // 2
        for x in array :
            if x > mid :
                total += x - mid
        if total < m :
            end = mid - 1
        else :
            result = mid
            start = mid + 1
    return result 

print(dongbin())
# print(solution())
'''
4 6
19 15 10 17
'''
