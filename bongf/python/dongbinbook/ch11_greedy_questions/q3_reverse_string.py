# https://www.acmicpc.net/submit/1439
def solution() :
    num = input()

    z = 0
    o = 0
    s = ''
    for n in num :
        if s != n :
            if n == '0' :
                z += 1
            else :
                o += 1 
            s = n
    
    return min(z, o)

def dongbin():
    data = input()
    count0 = 0
    count1 = 0

    if data[0] == '1':
        count0 += 1
    else:
        count1 += 1
    
    for i in range(len(data)-1):
        if data[i] != data[i+1]:
            if data[i+1] == '1':
                count0 += 1
            else :
                count1 += 1 
    return(count0, count1)


print(solution())
