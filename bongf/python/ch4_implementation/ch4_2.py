def solution() :
    n = int(input())
    ## N에 3이 포함되어 있지 않을 떄 한 시간당 3이 들어간 개수
    c = 10 * 6 * 10 + 5 * 6* 10 + 5 * 9 * 10 + 5 * 9 * 5
    ## N에 3이 포함되어 있을 때 3이 들어간 개수 
    a = 6 * 10 * 6 * 10 

    answer = 0
    for i in range(n+1) :
        if( i == 3 or i == 13 or i == 23) :
            answer += a
        else :
            answer += c 
    return answer

def dongbin() :
    h = int(input())

    count = 0
    for i in range(h+1) :
        for j in range(60) :
            for k in range(60) :
                if '3' in str(i) + str(j) + str(k):
                    count += 1

print(solution())
