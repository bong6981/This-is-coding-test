from itertools import permutations

def solution(n, weak, dist):
    # 길이를 2배로 늘려서 '원형'을 일자 형태로 변형
    length = len(weak)
    for i in range(length):
        weak.append(weak[i] + n)
    print(f"weak : {weak}")
    answer = len(dist) + 1 # 투입할 친구 수의 최솟값을 찾아야 하므로 len(dist) + 1로 초기화
    # 0부터 length - 1까지의 위치를 각각 시작점으로 설정
    for start in range(length):
        print(f"start : {start}")
        # 친구를 나열하는 모든 경우 각각에 대하여 확인
        for friends in list(permutations(dist, len(dist))):
            print(f"friends : {friends}")
            count = 1 # 투입할 친구의 수
            # 해당 친구가 점검할 수 있는 마지막 위치
            position = weak[start] + friends[count - 1]
            print(f"position : {position}")
            # 시작점부터 모든 취약한 지점을 확인
            for index in range(start, start + length):
        
                # 점검할 수 있는 위치를 벗어나는 경우
                if position < weak[index]:
                    print(f"index : {index}, start:{start}, start+length = {start+length}")
                    count += 1 # 새로운 친구를 투입
                    if count > len(dist): # 더 투입이 불가능하다면 종료
                        break
         
                    position = weak[index] + friends[count - 1]
                    print("친구한명추가요")
                    print(f"추가한 position : {position}")
            answer = min(answer, count) # 최솟값 계산
            print(f"answer = {answer}")
    if answer > len(dist):
        return -1
    return answer

def solution_fail(n, weak, dist):
    weak_dist = [0] * len(weak)
    total = 0
    if(len(weak) == 1):
        return 1
    for i in range(len(weak)):
        if(i == len(weak)-1):
            weak_dist[i] = n - weak[i] + weak[0]
        else : 
            weak_dist[i] = weak[i+1] - weak[i]
        total += weak_dist[i]
    
    print(weak_dist)
    people = 0
    run = 0  
    weak_dist.sort(reverse = True)
    dist.sort(reverse = True)
    print(dist)
    for i in range(len(weak_dist)):
        if(len(dist) == 0):
            return -1 
        total = total - weak_dist[i]
        run += dist.pop(0)
        people += 1 
        if (run >= total) :
            return people
    return -1

from collections import deque
def solution2(n, weak, dist):
    dist.sort(reverse=True)
    q = deque([weak])
    print(f"q = {q}")
    visited = set()
    visited.add(tuple(weak))
    print(visited)
    for i in range(len(dist)):
        d = dist[i]
        print(f"d = {d}, dist= {dist}, len(q) = {len(q)}")
        for _ in range(len(q)):
            current = q.popleft()
            print(f"q = {q} current = {current}")
            for p in current:
                print(f"저는 current = {current} 속의 p = {p}")
                l = p
                r = (p + d) % n
                if l < r:
                    print(f"filter 할 것인데 current = {current}, l = {l}, r={r}")
                    temp = tuple(filter(lambda x: x < l or x > r, current))
                   
                else:
                    temp = tuple(filter(lambda x: x < l and x > r, current))
                print(f"temp = {temp}")

                if len(temp) == 0:
                    return (i + 1)
                
                elif temp not in visited:
                    visited.add(temp)
                    q.append(list(temp))
                    print(f"{temp not in visited}, tem= {temp}, visited = {visited}, q={q}")

    return -1

def solution3(n, weak, dist):

    W, F = len(weak), len(dist)
    repair_lst = [()]  # 현재까지 고칠 수 있는 취약점들 저장 (1,2,3)
    count = 0  # 투입친구 수
    dist.sort(reverse=True) # 움직일 수 있는 거리가 큰 친구 순서대로

    # 고칠 수 있는 것들 리스트 작성
    for can_move in dist:
        print(f"can_move : {can_move} in dist = {dist}")
        repairs = []  # 친구 별 고칠 수 있는 취약점들 저장
        count += 1

        # 수리 가능한 지점 찾기
        for i, wp in enumerate(weak):
            start = wp  # 각 위크포인트부터 시작
            ''' 이전 코드보다 더 깔끔한 부분... 익힐려고 손으로 세번 썼다. '''
            ends = weak[i:] + [n+w for w in weak[:i]]  # 시작점 기준 끝 포인트 값 저장
            can = [end % n for end in ends if end -
                   start <= can_move]  # 가능한 지점 저장
            repairs.append(set(can))
            print(f"weak : {weak}, i = {i} wp, start = {start} end = {ends} can = {can} repair = {repairs}")
            ''''''
        # 수리 가능한 경우 탐색
        cand = set()
        for r in repairs:  # 새친구의 수리가능 지점
            print(f"r : {r} in repairs = {repairs}")
            for x in repair_lst:  # 기존 수리가능 지점
                print(f"x : {x} in repairs_lst = {repair_lst}, r={r}")
                ''' 이전 코드보다 더 깔끔한 부분... 익힐려고 손으로 세번 썼다. '''
                new = r | set(x)  # 새로운 수리가능 지점
                print(f"new : {new}, W = {W}")
                if len(new) == W:  # 모두 수리가능 한 경우 친구 수 리턴
                    return count
                cand.add(tuple(new))
                print(f"cand : {cand}")
                ''''''
        repair_lst = cand
        print(f" repairs_lst = {repair_lst}")

    return -1
print(solution(12, [1, 5, 6, 10], [1, 2, 3, 4]))
# print(solution(12, [0, 5, 6, 10], [1, 2, 3, 4]))
# print(solution(12, [1, 3, 4, 9, 10], [3, 5, 7]))
# print(solution(50, [1], [6])) ##1 
# print(solution(200,  [0, 10, 50, 80, 120, 160], [1, 10, 5, 40, 30]))
# print(solution(200,  [0, 100], [1,1]))
# print(solution(200, [1, 50, 100], [1]))
# print(solution(200, [1], [1]))
# print(solution(30, [0, 3, 11, 21], [10, 4]))
# print(solution(200, [0, 100], [1, 1]))

# print(solution(100, [0, 3, 50, 53], [4, 2])) ## -1이어야 하지만 2명으로 나온다 3 +3 = 2 +4 니까 


