n = int(input())
a = []  # 배열 값 입력 필요

# 더이상 교환이 없을 때 교환하지 않는 방법의 개선
for i in range(n-1):
    exchanged = 0
    for j in range(n-1, i, -1):
        if a[j-1] > a[j]:
            a[j-1], a[j] = a[j], a[j-1]
            exchanged += 1
    if exchanged == 0:
        break

# 스캔의 범위를 제한하는 개선
n = len(a)
k = 0
while k < n - 1:
    last = n - 1
    for j in range(n-1, k, -1):
        if a[j-1] > a[j]:
            a[j-1], a[j] = a[j], a[j-1]
            last = j
    k = last

# 셰이커 정렬
def shaker_sort(arr):
    left = 0
    right = len(a) - 1
    last = right
    while left < right:
        for j in range(right, left, -1):
            if a[j-1] > a[j]:
                a[j-1], a[j] = a[j], a[j-1]
                last = j
        left = last

        for j in range(left, right):
            if a[j] > a[j+1]:
                a[j+1], a[j] = a[j], a[j+1]
                last = j
        right = last
