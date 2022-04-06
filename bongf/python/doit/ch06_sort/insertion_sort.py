from bisect import bisect


def insertion_sort(arr):
    n = len(arr)
    for i in range(1, n):
        j = i
        tmp = arr[i]
        while j > 0 and arr[j-1] > tmp:
            arr[j] = arr[j-1]
        arr[j] = tmp


def binary_insertion_sort(arr):
    n = len(arr)
    for i in range(1, n):
        key = arr[i]
        
        pl = 0 # 검색 범위의 맨 앞 인덱스 
        pr = i -1 # 검색 범위의 맨 끝 원소 인덱스 

        while True:
            p_mid = (pl + pr) // 2
            if arr[p_mid] == key:
                break
            elif arr[p_mid] < key:
                pl = p_mid + 1
            else:
                pr = p_mid - 1

            if pl > pr:
                break
        
        p_to_insert = p_mid + 1 if pl <= pr else pr + 1

        for j in range(i, p_to_insert, -1):
            arr[j] = arr[j-1]
        
        arr[p_to_insert] = key


### 파이썬 라이브러리를 사용한 이진 삽입 정렬
def binary_insertion_sort(arr):
    import bisect
    for i in range(1, len(arr)):
        bisect.insort(arr, arr.pop(i), 0, i)
