## 1. 범위를 반씩 좁혀가는 탐색 
### 순차 탐색 Sequential Search
- 리스트 안에 특정한 데이터를 착기 위해서 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법 
- 보통 정렬되지 않는 리스트에서 특정 데이터를 찾아야 할 때 
- 최악의 경우 데이터의 개수가 N개일 때 시간복잡도 O(N)
### 이진탐색 Binary Search : 반으로 쪼개면서 탐색
- 배열 내부의 데이터가 정려로디어 있어야만 사요ㅗㅇ할 수 있는 알고리즘 
- 변수 3개 사용 : 시작점, 끝점, 중간점 
-   찾으려는 데이터와 중간점에 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾는 방법
-   $\log_2 N$ 빅오 표기 법에 따라 O($\log N$)
-   구현방법 2가지 : 1. 재귀함수 이용 2. 반복문 
-   재귀함수 이용
```python
def binary_search(array, target, start, end) :
    if start > end :
        return None 
    mid = (start + end) // 2

    if arry[mid] == tartget :
        return mid 
    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)
    else :
        return binary_search(array, target, mid+1, end)
```
-   반복문 사용
```python
def binary_search(array, target, start, end) :
    while start <= end :
        mid = (start+end) // 2
        if array[mid] == tartget :
            return mid
        elif array[mid] > tartget :
            end = mid -1
        else :
            start = mid +1
    return None
```
- 이진 탐색은 코딩 테스트에서 단골 문제니 이 소스코드를 그냥 지금 외워라 
-   탐색범위가 2000만을 넘어가면 이진 탐색으로 문제에 접근해보길 바란다. 
### 트리 자료구조 
![image](https://user-images.githubusercontent.com/73228803/131434460-4654f1b4-df72-4ffb-8116-14b9d5dbebc4.png)
-   트리는 부모 노드와 자식 노드의 관계로 표현된다 
-   트리의 최상단 노드를 루트노드 
-   트리의 최하단 노드를 단말 노드 
-   트리에서 일부를 떼어내도 트리구조이며 이를 서브트리라 한다. 
-   파일시스템과 같이 계층적이고 정렬된 데이터를 다루기 적합하다 
### 이진 탐색 트리
-   트리 자료구조 중에서 가장 간단한 형태 
![image](https://user-images.githubusercontent.com/73228803/131434523-f5628389-99ec-41c3-8e4f-f1b0ea35796f.png)
- 왼쪽 자식노드 < 부모노드 < 오른쪽 자식 노드 
-   구현 문제는 코테라기보단 자료구조
### 빠르게 입력받기 
- 입력 데이터의 개수가 많을 때 input()을 사용하면 동작 속도가 느리다. 시간초과. 
- 이럴 땐 sys 라이브러리의 readline()함수를 이용하면 시간 벌 수 있다. 
```python
import sys
#하나의 문자열 데이터 입력받기 
input_data = sys.stdin.readline().rstrip()

print(input_data)
```
```python
Hello, Coding Test
```
- 한 줄 입력받고 나서 rstrip()함수 꼭 호출 
- 입력 후 엔터가 줄 바꿈 기호로 입력되는데 이 공백 문자를 제거하려면 trstrip()함수 사용 
- 부록에 더 간단히 사용하는 방법 나와 있다. 

### ch7_8 떡볶이 떡 만들기 
- 전형적인 이진 탐색 문제 
- 파라메트릭 서치 Parametric Search 유형의 문제 
    -   최적화 문제를 결정문제(예, 아니오로 답하는 문제)로 바꾸어 해결하는 기법 
    -   '원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제'에 주로 파라메트릭 서치를 사용 
    -   범위내에서 조건을 만족하는 가장 큰 값을 찾으라는 최적화 문제라면 이진탐색으로 결정 문제를 해결하면서 범위를 좁혀갈 수 있다. 
-   코딩테스트나 프로그래밍 대회에서는 보통 파라메트릭 서치 유형은 이진 탐색을 이용해서 해결 
-   일반적으로 파라메틱 서치 문제는 재귀보다는 반복문이 간단하다.
#### 문제풀이 
-   절단기의 높이 H를 반복해서 조정 
    -   현재 이 높이로 자르면 조건을 만족할 수 있는가? 를 확인한 뒤에 조건의 만족여부('예','아니오')에 따라서 탐색 범위를 좁혀서 해결 
    -   범위를 조절할 때는 이진 탐색의 원리를 이용하여 절반씩 탐색 범위를 좁혀 나간다. 
-   절단기의 높이 탐색 범위는 1부터 10억까지의 정 수 중 하나인데 이처럼 큰 수를 보면 당연하다는 듯 이진 탐색을 떠올려야 한다. 
    -   순차 탐색은 시간초과 
