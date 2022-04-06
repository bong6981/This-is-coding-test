def solution(n, stages):
    stages = sorted(stages)
    result = []
    start = stages[0]
    people = len(stages)
    cnt = 0
    for i in range(1, n+1):
        count = stages.count(i)
        if people == 0:
            fail = 0
        else:
            fail = count / people
        result.append((-fail, i))
        people -= count

    result.sort()
    result = [i[1]for i in result]
    return result
