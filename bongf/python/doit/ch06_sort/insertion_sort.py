def insertion_sort(arr):
    n = len(arr)
    for i in range(1, n):
        j = i
        tmp = arr[i]
        while j > 0 and arr[j-1] > tmp:
            arr[j] = arr[j-1]
        arr[j] = tmp


