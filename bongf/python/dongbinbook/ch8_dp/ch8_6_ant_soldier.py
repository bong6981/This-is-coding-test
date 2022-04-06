## 3,1,1,5 의 경우 기댓값 8 실제 결과값 6 
def solution() :
    n = int(input())
    arr = list(map(int, input().split(" ")))

    sum1 = 0 
    sum2 = 0 

    for i in range(n) :
        if(i%2 == 0) :
            sum1 += arr[i]
        else :
            sum2 += arr[i]
    return max(sum1, sum2)

## i번째 식량 창고에 있는 양이 k(i)라고 했을 때 점화식은 a(i) = max(a(i-1), a(i-2) + k(i))
def dongbin() :
    n = int(input())
    array = list(map(int, input().split()))

    d = [0] * 100 

    d[0] = array[0]
    d[1] = max(array[0], array[1])
    for i in range(2, n):
        print(i, n)
        d[i] = max(d[i-1], d[i-2] + array[i])
    return(d[n-1])

# print(solution())
print(dongbin())

'''
4
1 3 1 5 
결과 8
'''
'''
4
10 1 1 100
결과 110 
'''
