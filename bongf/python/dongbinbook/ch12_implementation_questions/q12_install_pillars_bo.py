# https://programmers.co.kr/learn/courses/30/lessons/60061?language=python3

## 요구사항에서 전체 명령의 개수 1000개 이하 
## 시간복잡도 O(M^3) 해도 가능 : 요구할 때마다 일일이 전체 구조물을 확인하며 규칙을 확인 
def dongbin(n, build_frame):
    def possible(answer):
        for x, y, stuff in answer : 
            if stuff == 0 :
                if y == 0 or [x-1, y, 1] in answer or [x, y, 1] in answer or [x, y-1, 0] in answer:
                    continue
                return False
            elif stuff == 1: 
                if [x, y-1, 0] in answer or [x+1, y-1, 0] in answer or ([x-1, y, 1] in answer and [x+1, y, 1] in answer):
                    continue
                return False
        return True
    
    answer = [] 
    for frame in build_frame :
        x, y, stuff, operate = frame
        if operate == 0 :
            answer.remove([x, y, stuff])
            if not possible(answer):
                answer.append([x, y, stuff])
        if operate == 1 :
            answer.append([x, y, stuff])
            if not possible(answer):
                answer.remove([x, y, stuff])
    return sorted(answer)




## 테케 6번 틀림, 18-23 시간초과 
import copy
def solution(n, build_frame):
    graph = [[Node() for _ in range(n+1)] for _ in range(n+1)]
    
    for i in range(n+1):
        graph[n][i].floor = True 
    
    def possible_install_gi(x,y,graph):
        node = graph[x][y]
        if node.floor or node.bo_l or node.bo_r :
            return True
        if x+1 <= n : 
            undernode = graph[x+1][y]
            if(undernode.gi):
                return True
        return False

    def possible_install_bo(x,y,graph):
        node = graph[x][y]

        if x+1 <= n : 
            undernode = graph[x+1][y]
            if(undernode.gi):
                return True
        rightnode = None
        if(y+1<=n) :
            if(x+1<=n):
                rightundernode = graph[x+1][y+1]
                if rightundernode.gi : 
                    return True
            rightnode = graph[x][y+1]
            if rightnode.bo_r and  node.bo_l :
                return True
        return False

    def possible_remove_gi(x, y, tempgraph) :
        node = tempgraph[x][y]
        node.gi = False
        if(x-1 >= 0):
            upnode = tempgraph[x-1][y]
            if(upnode.bo_l):
                if not(possible_install_bo(x-1, y-1, tempgraph)):
                    return False, None
            if(upnode.bo_r):
                if not possible_install_bo(x-1, y, tempgraph):
                    return False, None
            if(upnode.gi):
                if not possible_install_gi(x-1, y, tempgraph):
                    return False, None
        return True, tempgraph

    def possible_remove_bo(x, y, tempgraph) :
        node = tempgraph[x][y]
        node.bo_r = False
        rightnode = tempgraph[x][y+1]
        rightnode.bo_l = False
        if(node.bo_l):
            if not possible_install_bo(x, y-1, tempgraph):
                return False, None
        if(node.gi):
            if not possible_install_gi(x, y, tempgraph):
                return False, None
        if(rightnode.gi):
            if not possible_install_gi(x, y+1, tempgraph):
                return False, None
        if(rightnode.bo_r):
            if not possible_install_bo(x, y+1, tempgraph):
                return False, None
        return True, tempgraph

    def print_answer(graph, n):
        arr = [] 
        for i in range(n+1):
            for j in range(n, 0, -1):
                node = graph[j][i]
                if(node.gi):
                    arr.append([i, n-j, 0])
                if(node.bo_r):
                    arr.append([i, n-j, 1])
        return arr 


    for work in build_frame : 
        y, x, thing, do = work
        x = n - x
        node = graph[x][y]
        if(do == 1) :
            if thing == 0 and possible_install_gi(x, y,graph) :
                node.gi = True
            if  thing == 1 and possible_install_bo(x, y, graph):
                node.bo_r = True
                rightnode = graph[x][y+1]
                rightnode.bo_l = True                    

        else : 
            tempgraph = copy.deepcopy(graph)
            if  thing == 0  :
                possible, resultgraph = possible_remove_gi(x, y, tempgraph)
                if(possible):
                    graph = resultgraph
            else : 
                possible, resultgraph = possible_remove_bo(x,y,tempgraph)
                if(possible):
                    graph = resultgraph
        
    return print_answer(graph, n)

class Node : 
    def __init__(self):
        self.gi = False 
        self.bo_r = False
        self.bo_l = False  
        self.floor = False 
    
    def __str__(self):
        return f'gi = {self.gi}, bo_r = {self.bo_r}, bo_l = {self.bo_l} floor = {self.floor}'

# print(solution(5, [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]))
print(solution(5, [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]))

# print(solution(5, [[1,0,0,1],[1,1,1,1]]))
# print(solution([5,0,0,1],[5,1,0,1]))


