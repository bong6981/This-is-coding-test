def solution() :
    n, k = map(int, input().split())
    cnt = 0 
    while n != 1 :
        if n % k == 0 :
            n /= k
        else :
            n -= 1
        cnt += 1
    return cnt

# 효율성을 위해 n을 k의 배수인 target으로 한번에 바꾸는 풀이    
def dongbin() :
    n, k = map(int, input().split())
    result = 0

    while True:
        target = (n//k) * k
        result += ( n - target)
        n = target

        if n < k :
            break
        result += 1
        n //= k
    
    result += (n-1)
    return result

print(solution())
