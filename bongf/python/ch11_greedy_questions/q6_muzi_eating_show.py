## https://programmers.co.kr/learn/courses/30/lessons/42891
## 이해 안갈 때 해설 : https://www.youtube.com/watch?v=zpz8SMzwiHM

import heapq

## dongbin
def solution(food_times, k):
    if sum(food_times) <= k : 
        return -1
    
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i+1))
    
    sum_value = 0 #먹기 위해 사용한 시간 
    previous = 0 #직전에 다 먹은 음식의 소요시간 
    length = len(food_times) #남은 음식의 개수
    
    while sum_value + (q[0][0] - previous) * length <= k: 
        now = heapq.heappop(q)[0]
        sum_value += (now-previous) * length
        length -= 1
        previous = now 
    
    result = sorted(q, key = lambda x : x[1])
    return result[(k-sum_value) % length][1]


## 나름 효율성 고민해봤지만 실패 
def solution_not_efficient(food_times, k):
    toeat = k 
    mincount = toeat // len(food_times)
    left = sum(food_times)
    if(k >= left):
        return -1 
    
    maxindex = 0 
    if mincount >= 1 : 
        for i in range(len(food_times)):
            if food_times[i] >= mincount : 
                food_times[i] -= mincount 
                toeat -= mincount
                maxindex = i 
                        
            else : 
                toeat -= food_times[i]
                food_times[i] = 0 
        i = maxindex + 1
    else : 
        i = 0 
    
    if(i>len(food_times)-1):
        i = 0

    while toeat != 0 : 
        if food_times[i] > 0 : 
            toeat -= 1 
            food_times[i] -= 1 
        i +=1
        if i == len(food_times) : 
            i = 0

    while(food_times[i]==0):
        i+= 1
        if i == len(food_times) : 
            i = 0        
    return i + 1  

## 효율성 고려 안하고 풀었을 때 
def solution_not_efficient(food_times, k):
    toeat = k 
    index = 0 
    left = sum(food_times)
    if(k >= left):
        return -1 

    while toeat != 0 :
        if(food_times[index] > 0) :
            toeat -= 1
            food_times[index] -= 1 
            left -= 1
        index += 1
        if index == len(food_times) : 
           index = 0 
    
    while(food_times[index] == 0):
        index += 1 
        if(index == len(food_times)):
            index = 0 
    return index + 1 

# 1 
# print(solution([3,1,2], 5))
# 4
# print(solution([1,2,3,4], 8))
# 4
# print(solution([2,2,2,2], 3))
# -1 
# print(solution([2,2,2,2], 10))
# 6 
# print(solution([3,1,1,1,2,4,3], 12))
