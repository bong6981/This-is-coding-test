def partition(arr):
    n = len(arr)
    pl = 0 # 왼쪽커서 
    pr = n-1 #오른쪽 커서 
    x = arr[n//2]

    while pl <= pr:
        while arr[pl] < x : pl += 1
        while arr[pr] > x : pr -= 1
        if pl <= pr:
            arr[pl], arr[pr] = arr[pr], arr[pl]
            pl += 1
            pr -= 1

## 기본 퀵 정렬 구현 
def quick_sort(arr):
    qsort(arr, 0, len(arr)-1)

def qsort(arr, left, right):
    pl = left
    pr = right
    x = arr[(left+right)//2]

    while pl <= pr:
        while arr[pl] < x : pl += 1
        while arr[pr] > x : pr -= 1
        if pl <= pr :
            arr[pl], arr[pr] = arr[pr], arr[pl]
            pl += 1
            pr -= 1
    
    if left < pr : qsort(arr, left, pr)
    if pl < right : qsort(arr, pl, right)

## 비재귀적인 퀵 정렬 만들기 
from stack import Stack

def qsort(arr, left, right):
    range = Stack(right-left+1)
    range.push((left, right))

    while not range.is_empty():
        pl, pr = left, right = range.pop()
        x = arr[(left+right)//2]

        while pl <= pr:
            while arr[pl] < x : pl += 1
            while arr[pr] > x : pr -= 1
            if pl <= pr :
                arr[pl], arr[pr] = arr[pr], arr[pl]
                pl += 1
                pr -= 1
    
            if left < pr : range.push((left, pr))
            if pl < right : range.push((pl, right))

def quick_sort(arr):
    qsort(arr, 0, len(arr)-1)
























