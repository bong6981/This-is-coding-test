def solution() :
    n, m, k = map(int, input().split(" "))
    arr = list(map(int, input().split(" ")))
    arr.sort(reverse=True)
    return (arr[0] * 3 + arr[1] * 1) * (m // (k+1)) + arr[0] * (m % (k+1)) if ( len(arr) > 0 ) else arr[0] * m
    
print(solution())
