# https://www.acmicpc.net/problem/15686
from itertools import combinations
import copy 

def solution() :
    n, m = map(int, input().split())
    chicken = [] 
    home = [] 
    for i in range(n):
        list1 = list(map(int, input().split()))
        for j in range(n) : 
            if(list1[j]==1):
                home.append((i+1, j+1))
            elif(list1[j]==2):
                chicken.append((i+1, j+1))

    chicken_len = [[0] * len(chicken) for _ in range(len(home))]
    for i in range(len(home)):
        for j in range(len(chicken)):
            x, y = home[i]
            a, b = chicken[j]
            chicken_len[i][j] = abs(a-x) + abs(b-y)
    to_out = len(chicken) - m
    
    if to_out == 0 :
        length = 0 
        for j in range(len(chicken_len)):
            chicken_len[j].sort()
            length += chicken_len[j][0]
        return length
        
    answer = []
    for nums in combinations(list(range(len(chicken))), to_out):
        length = 0
        for j in range(len(chicken_len)):
            chicken_len_temp = copy.deepcopy(chicken_len[j])
            for i in nums :
                chicken_len_temp[i] = 100 
            chicken_len_temp.sort()
            length += chicken_len_temp[0]
        answer.append(length)
   
    answer.sort()
    return answer[0]
            
print(solution())

'''
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
'''
'''
5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2
'''

def dongbin() :
    n, m = map(int, input().split())
    chicken, house = [], []

    for r in range(n):
        data = list(map(int, input().split()))
        for c in range(n):
            if data[c] == 1:
                house.append((r, c)) # 일반 집
            elif data[c] == 2:
                chicken.append((r, c)) # 치킨집

    # 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
    candidates = list(combinations(chicken, m))

    # 치킨 거리의 합을 계산하는 함수
    def get_sum(candidate):
        result = 0
        for hx, hy in house:
            # 가장 가까운 치킨 집을 찾기
            temp = 1e9
            for cx, cy in candidate:
                temp = min(temp, abs(hx - cx) + abs(hy - cy))
            # 가장 가까운 치킨 집까지의 거리를 더하기
            result += temp
        # 치킨 거리의 합 반환
        return result

    # 치킨 거리의 합의 최소를 찾아 출력
    result = 1e9
    for candidate in candidates:
        result = min(result, get_sum(candidate))

    print(result)
