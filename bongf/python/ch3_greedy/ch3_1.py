def solution(change) :
    m = [500, 100, 50, 10]
    answer = 0
    for n in m :
        answer += change // n
        change %= n 
    return answer

print(solution(1260))
