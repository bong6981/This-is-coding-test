## 동빈북 
def solution() :
    n, m = map(int, input().split())
    arr = []
    for i in range(n) :
        arr.append(int(input()))
    
    d = [10001] * (m+1)
    d[0] = 0
    for i in range(n) :
        for j in range(arr[i], m+1) :
            if d[j-arr[i]] != 10001 :
                d[j] = min(d[j], d[j-arr[i]] + 1)

    if d[m] == 10001 :
        return -1
    return d[m]


print(solution())

'''
2 15
2
3
결과 5
'''

'''
3 4
3
5
7
결과 -1
'''
