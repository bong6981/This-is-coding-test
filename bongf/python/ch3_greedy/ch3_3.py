def solution() :
    n, m = map(int, input().split(" "))
    answer = 0
    for i in range(n) :
        answer = max(min(map(int, input().split(" "))), answer)
    return answer

print(solution())
