def solution() :
    x = int(input())
    answer = 0
    while( x!= 1) :
        print(x, answer)
        if (x // 5) != 0 :
            answer += x - (x//5)*5 + 1
            x = x//5
        elif x//3 != 0:
            answer += x - (x//3)*3 + 1
            x = x//3
        elif x//2 != 0 :
            answer += x - (x//2)*2 + 1
            x = x//2
    return answer

def dongbin() :
    x = int(input())

    d = [0] * 30001
    for i in range (2, x+1) :
        d[i] = d[i-1] + 1
        if(i%2 == 0):
            d[i] = min(d[i], d[i//2] + 1)
        if(i%3 == 0) :
            d[i] = min(d[i], d[i//3] + 1)
        if(i%5 ==0) :
            d[i] = min(d[i], d[i//5] + 1)
    return d[x]

# print(solution())
print(dongbin())

'''
26
결과 3 
'''
