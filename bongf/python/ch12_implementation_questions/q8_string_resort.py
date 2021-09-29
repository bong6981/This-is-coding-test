def solution() :
    n = list(input())
    n.sort()
    sum = 0 
    count = 0 
    while True :
        s = n[0]
        if not s.isdigit() :
            break
        sum += int(n.pop(0))
        count += 1
    
    return "".join(n) + str(sum) if count != 0 else "".join(n)

print(solution())

## 동빈북 풀이보면 숫자가 0이 들어올 경우는 0출력 안해주는 걸로 하는데 그냥 해주는 걸로 바꿨다 
def dongbin() :
    data = input()
    result = [] 
    value = 0 
    count = 0 

    for x in data :
        if x.isalpha() :
            result.append(x)
        else :
            value += int(x)
            count += 1
    
    result.sort()

    if count == 0 :
        return "".join(result) 
    return "".join(result) + str(sum)
    
'''
K1KA5CB7
결과 ABCKK13
AJKDLSI412K4JSJ9D
결과 ADDIJJJKKLSS20
'''
