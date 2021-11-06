def solution():
    n = int(input())
    grades = []
    for _ in range(n):
        data = input().split(" ")
        grades.append((data[0], int(data[1]), int(data[2]), int(data[3])))
    
    '''
    dongbin : 
    students.sort(key=lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
    '''
    grades.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))
    for g in grades:
        print(g[0])


solution()
