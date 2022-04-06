def solution() :
    s = input()
    result = 0 
    for c in s :
        c = int(c)
        if result == 0 or c == 0 :
            result += c
        else :
            result *= c
    return result



print(solution())
'''
02984
결과 576
567
결과 210 
'''
