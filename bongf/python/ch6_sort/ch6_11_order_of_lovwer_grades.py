def solution() :
    n = int(input())
    arr = []
    for i in range(n) :
        name, grades = input().split(" ")
        arr.append((name, int(grades)))
    
    return sorted(arr, key = lambda x : x[1])

def dongbin() :
    # N 입력 받기
    n = int(input())

    # N명의 학생 정보를 입력 받아 리스트에 저장
    array = []
    for i in range(n):
        input_data = input().split()
        # 이름은 문자열 그대로, 점수는 정수형으로 변환하여 저장
        array.append((input_data[0], int(input_data[1])))

    # 키(Key)를 이용하여, 점수를 기준으로 정렬
    array = sorted(array, key=lambda student: student[1])

    # 정렬이 수행된 결과를 출력
    for student in array:
        print(student[0], end=' ')

print(solution())
'''
2
홍길동 95
이순신 77
'''

'''
##int로 안바꿔주면 여기서 에러
2                 
홍길동 13
이순신 100
'''
