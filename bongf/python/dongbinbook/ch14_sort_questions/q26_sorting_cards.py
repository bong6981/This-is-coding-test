# https://www.acmicpc.net/problem/1715
import heapq
def solution():
    n = int(input())
    cards = []
    for _ in range(n):
        heapq.heappush(cards, int(input()))
    
    cnt = 0
    while len(cards) != 1 :
        one = heapq.heappop(cards)
        two = heapq.heappop(cards)
        sum_value = one + two
        heapq.heappush(cards, sum_value)
        cnt += sum_value 
    return cnt

print(solution())
