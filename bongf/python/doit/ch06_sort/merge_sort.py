## 정렬을 마친 배열 a, b -> c에
from tkinter import N


def merge_sorted_list(a, b, c):
    pa, pb, pc = 0, 0, 0 # 각 배열의 커서
    na, nb, nc = len(a), len(b), len(c) #각 배열의 원소 수

    while pa < na and pb < nb:
        if a[pa] <= b[pb] :
            c[pc] = a[pa]
            pa += 1
        else:
            c[pc] = b[pb]
            pb += 1
        pc += 1
    
    while pa < na: # a에 남은 원소를 c에 복사 
        c[pc] = a[pa]
        pa += 1
        pc += 1
    
    while pb < nb:
        c[pc] = b[pb]
        pb += 1
        pc += 1


def merged_sorted_list_with_library():
    import heapq
    a = [2, 4, 6, 8, 11, 13]
    b = [1, 2, 3, 4, 9, 16, 21]
    c = list(heapq.merge(a, b))
    print(c)

merged_sorted_list_with_library() ## [1, 2, 2, 3, 4, 4, 6, 8, 9, 11, 13, 16, 21]


### 아래부터가 진짜 병합정렬
def merge_sort(arr, left, right):
    if left < right:
        center = (left + right) // 2

        merge_sort(arr, left, center)
        merge_sort(arr, center+1, right)

        p = j = 0
        i = k = left

        while i <= center: # 배열의 앞부분 복사, while문 종료시 p값은 복사한 원소수인 center - left + 1
            buff[p] = arr[i]
            p += 1
            i += 1

        while i <= right and j < p : #배열의 뒷부분과 buff로 복사한 배열의 앞부분 p개를 병합한 결과를 배열 arr에 저장
            if buff[j] <= arr[i]:
                arr[k] = buff[j]
                j += 1
            else:
                arr[k] = arr[i]
                i += 1
            k+=1

arr = []
n = len(arr)
buff = [None] * N
merge_sort(arr, 0, n-1)
