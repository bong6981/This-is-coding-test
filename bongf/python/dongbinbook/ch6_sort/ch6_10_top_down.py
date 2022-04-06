##동빈북과 풀이 같음
def solution() :
    n = int(input())
    arr = []
    for i in range(n) :
        arr.append(int(input()))
    return sorted(arr, reverse = True)

print(solution())
