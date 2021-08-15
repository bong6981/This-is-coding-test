from itertools import combinations
def solution() :
    s = int(input())
    arr = input().split()
    move_y = {'L':-1, 'R':1, 'U':0, 'D':0}
    move_x = {'L':0, 'R':0, 'U':-1, 'D':1}

    x = 1 
    y = 1
    for i in arr :
        a = x + move_x[i]
        b = y + move_y[i]
        if( 1<=a<=5) and ( 1<=b<=5) :
            x = a
            y = b
    return x, y
        




print(solution())
