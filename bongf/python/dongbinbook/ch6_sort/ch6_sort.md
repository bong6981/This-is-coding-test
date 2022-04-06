## 선택정렬 (Selection Sort)
### 정렬 방법 
- 데이터가 무작위로 있을 때
가장 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고 
- 그 다음 작은 데이터를 선택해 앞에서 두 번째 데이터와 바꾸는 과정을 반복
```python
array = [ 7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
for i in range(len(array)) :
    min_index = i 
    for j in range(i+1, len(array)): 
        if array[min_index] > array[j] :
            min_index = j 
    array[i], array[min_index] = array[min_index]
, array[i] ## 스와프 
print(array)
```
### 시간복잡도 
- n + (n-1) + (n-2) + ... + 2
- n(n+1) / 2 = ($n^2$ + n) / 2 = O($n^2$) 
- 2중반복문 두 번 사용 
- 비효율적 

## 삽입 정렬 (Insertion Sort)
- 데이터를 하나씩 확인해서 각 데이터를 적절한 위치에 삽입 
- 데이터가 거의 정렬 때 있을 때 효율적 
```python
array = [ 7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
for i in range(1, len(array)):
    for j in range(i, 0, -1) : #인덱스 0부터 i까지 1씩 감소
        if array[j] < array[j-1] :
            array[j], array[j-1] = array[j-1], array[j]
        else :
            break
print(array)
```
### 시간복잡도 
- O($N^2$)
- 하지만 이미 정렬이 어느 정도 되어있다면 매우 빠르게 
    -   최선의 경우 O(N)까지 가능하다. 
- 거의 정렬되어 있는 경우는 여타 알고리즘 보다 삽입정렬을 이용하자 

## 퀵 정렬 (Quick sort)
- 가장 많이 사용되는 알고리즘 
- 기준을 설정한 다음 큰 수와 작은 수를 교환한 후 리스트를 반으로 나누는 방식 
- 퀵 정렬에서는 피벗(Pivot)이이 사용된다. 
    -   큰 숫자와 작은 숫자를 교환할 때 교환하기 위한 '기준'을 피벗이라고 한다.
- 피벗을 설정하고 리스트를 분할하는 방법에 따라 퀵 정렬이 구분된다. 여기서는 가장 대표적인 분할 방식인 호어분할(Hoare Parition)방식으로 설명 
    -   호어분할에서는 리스트에서 첫 번째 데이터를 피벗으로 정한다. 
    -   왼쪽에서부터 피벗보다 큰 데이터를 찾고, 오른쪽에서부터 피벗보다 작은 데이터를 찾는다 
    -   그 다음 큰 데이터와 작은 데이터의 위치를 서로 교환해준다. 
    -   이렇게 한 번 돌면 피벗을 기준으로 왼쪽에는 피벗보다 작은수, 오른쪽에는 피벗보다 큰 수가 있다. ( 이 작업을 분할 Divide 혹은 파티션 Partition 이라고 한다)
    -   그 다음은 왼쪽 리스트, 오른쪽 리스트 각각에서 맨 앞의 수를 피벗으로 설정해서 다시 정렬해준다. 
-   5장에서 다루었던 '재귀 함수'와 동작 원리로 같다. 실제로 퀵정렬은 재귀 함수 형태로 작성했을 때 구현이 매우 간결해진다. 
-   종료조건 : 현재 리스트의 데이터 개수가 1개인 경우 
```python
array = [ 7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
def quick_sort(array, start, end):
    if start >= end : #원소가 1개인 경우 종료 
        return
    pivot = start
    left = start + 1
    right = end 
    while left <= right :
        while left <= end and array[left] <= array[pivot] : 
            left += 1
        while right > start and array[right] >= array[[pivot] :
            right -= 1 
        if left > right : #엇갈렸다면 작은 데이터와 피벗을 교체  
            array[right], array[pivot] = array[pivot], array[right]
        else : 
            array[left], array[right] = array[right], array[left]
    quick_sort(array, start, right-1)
    quieck_sort(array, right+1, end)

quick_sort(array, 0, len(array)-1)
print(array)
```
- 파이썬의 장점을 살려 짧게 작성한 퀵 정렬 
```python
array = [ 7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
def quick_sort(array):
    if len(array) <= 1 :
        return array
    
    pivot = array[0]
    tail = array[1:]

    left_side = [ x for x in tail if x <= pivot] 
    right_side = [ x for x in tail if x > pivot]

    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(array))
```    
### 시간복잡도 
- 평균 O(NlogN) : 빠르다는 것만 인지
- 최악 : O($N^2$)
    -   이미 데이터가 정렬되어 있는 경우에는 매우 느리게 동작한다. 

## 계수 정렬(Count Sort)
- 특정 조건 부합할 때만 사용할 수 있지만 매우 빠른 정렬 알고리즘 
- '데이터의 크기 범위가 제한 되어 정수 형태로 표현할 수 있을 때'만 사용할 수 있다. 
- 일반적으로 가장 큰 데이터와 가장 작은 데이터의 차이가 1,000,000 을 넘지 않을 때 효과적으로 사용할 수 있다. 
    -   예를 들어 0이상 100이하인 성적 데이터를 정렬할 때 
-   그 이유는 계수 정렬을 이용할 때는 '모든 범위를 ㄷ마을수 있는 크기의 리스트(배열)를 선언'해야 해서 
### 방법
- 일반적으로 별도의 리스트를 선어하고 그 안에 정렬에 대한 정보를 담는다는 특징 
```python
array = [ 7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
count = [0] * (max(array) + 1)

for i in range(len(array)) :
    count[arr[i]] += 1

for i in range(len(count)) :
    for j in range(count[i]) :
        print(i, end= ' ')
```
### 시간 복잡도 
- 모든 데이터가 양의 정수인 상황에서 데이터의 개수를 N, 데이터 중 최대값의 크기를 K라고 할 때
    -   O(N + K)
- 현존하는 정렬 알고리즘 중에서 기수 정렬(Radix Sort)와 더블어 가장 빠르다 
    -    보통 기수 정렬은 계수 정렬에 비해서 느리지만 ㅈ처리할 수 있는 정수의 크기는 더 크다 

### 공간 복잡도 
-   데이터가 0과 999,999 단 두 개만 있을 때 리스트가 100만개가 되도록 선언해야 한다. 이럴 때 심각한 비효율성 
- 동일한 값을 가지는 데이터가 여러 개 등장할 때 적합 
    -   성적의 경우 100점을 맞은 학생이 여러 명 있을 수 있기 때문에 
    -   나) 도수분포도가 몰려있지 않을 때?
-   퀵 정렬은 일반적인 경우에 평균적으로 빠르게 동작, 데이터의 특성 파악하기 어렵다면 퀵 정렬 
-   계수 정렬은 데이터의 크기가 한정되어 있고, 데이터의 크기가 많이 중복되어 있을 수록 유리 
-   일반적인 코딩 테스트에서 데이터 개수를 1000만개 이상으로 설정할 수 없는 경우가 많아 정렬 문제에서의 데이터 개수는 1000만 개 미만으로 출제될 것 

## 파이썬 정렬 라이브러리 
- 기본 정렬 라이브러리 sorted(), sort()
    -   key를 매개 변수로 입력받을 수 있다.
    -   key 값으로는 하나의 함수가 들어가야 하며 이는 정렬 기준이 된다. 
    ```python
    arr = [('바나나', 2), ('사과', 5), ('당근', 3)]

    def setting(data) :
        return date[1]
    
    result = sorted(arr, key=setting)
    print(result)
    ```
    -   lamda를 활용할 수도 있다. 

### 정렬 라이브러리 시간 복잡도 
- 최악에도 O(NlogN)
    -   직접 퀵 정렬 구현보다 더욱더 효과적 
- 문제에 별도의 요구가 없다면 
    -    단순 정렬 문제 : 기본 정렬 라이브러리 사용 
    -   데이터의 범위가 한정적, 더 빠르게 동작해야 할 때 : 계수 정렬 사용 
-   코딩 테스트에서 정렬 알고리즘이 사용되는 경우는 일반적으로 3가지 
    1. 정렬 라이브러리로 풀 수 있는 문제 
    2. 정렬 알고리즘의 원리에 대해서 물어보는 문제
        -   선택정렬, 삽입정렬, 퀵 정렬 등의 원리를 알아야 풀 수 있다. 
    3. 더 빠른 정렬이 필요한 문제 : 계수 정렬 등의 다른 정렬 알고리즘을 이요하거나 문제게서 기존에 알려진 알고리즘의 구조적 개선으로 푸는 문제 

