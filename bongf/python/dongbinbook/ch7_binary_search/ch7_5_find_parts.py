import sys

def dongbin_binary_search() : 
    n = int(input())
    stock = sys.stdin.readline().rstrip().split(" ")
    m = int(input())
    require = sys.stdin.readline().rstrip().split(" ")

    stock.sort()
    for r in require :
        if binary_search(stock, r, 0, n-1) == None :
            print('no', end= ' ')
        else :
            print('yes', end= ' ')


def binary_search(array, target, start, end):
    while start <= end :
        mid = (start + end) //2 
        if(array[mid] == target) :
            return mid
        elif array[mid] > target :
            end = mid - 1 
        else :
            start = mid + 1 
    return None


def dongbing_counting_sort():
    n = int(input())
    array = [0] * 1000001
    for i in input().split():
        array[int(i)] = 1
    
    m = int(input())
    x = list(map(int, input().split()))
    for i in x :
        if array[i] == 1:
            print('yes', end= ' ')
        else:
            print('no', end= ' ')


## dongbin_set()
def solution() :
    n = int(input())
    stock = sys.stdin.readline().rstrip().split(" ")
    ## dongbin : stock = set(map(int, input().split()))
    m = int(input())
    require = sys.stdin.readline().rstrip().split(" ")

    for r in require :
        if (r in stock) :
            print('yes', end= ' ')
        else :
            print('no', end= ' ')


solution()
# dongbin_binary_search()
'''
5 
8 3 7 9 2
3
5 7 9
'''
