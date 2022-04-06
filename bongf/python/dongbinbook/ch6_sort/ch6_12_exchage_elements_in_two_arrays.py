def solution():
    n, k = map(int, input().split())
    arr1 = list(map(int, input().split()))
    arr2 = list(map(int, input().split()))
    arr1.sort()
    arr2.sort(reverse=True)

    for i in range(k) :
        if(arr1[i] < arr2[i]) :
            arr1[i], arr2[i] = arr2[i], arr1[i]
        else :
            break
    return sum(arr1)



print(solution())

'''
5 3
1 2 5 4 3
5 5 6 6 5
//결과 26
'''

'''
5 3
1 2 5 4 3
2 2 6 6 2
//결과 24
'''
