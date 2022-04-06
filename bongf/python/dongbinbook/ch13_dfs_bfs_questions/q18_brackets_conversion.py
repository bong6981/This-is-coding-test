def solution(p):
    answer = step_one_two(p)
    return answer

def step_one_two(p):
    if p == '' :
        return p 
    u, v = seperate(p)
    if(check_right_string(u)):
        u += step_one_two(v)
        return u 
    else : 
        u = u[1:-1]
        #똑똑이(solution2)풀이는 lambda를 이용해서 한줄로
        new_u = ''
        for c in u :
            if c == '(':
                new_u += ')'
            else:
                new_u += '('
        u = new_u
        return '(' + step_one_two(v) + ')' + new_u

# 동빈은 이것을 stack에 넣다 뺏다 하지 않고 count 숫자를 올려주고 내려주는 식으로 해결 
def check_right_string(balanced_word):
    if balanced_word == '':
        return None
    stack = []
    for w in balanced_word:
        if(stack == []):
            if(w == '('):
                stack.append(w)
            else:
                return False
        else:
            if w == '(' :
                stack.append(w)
            else:
                stack.pop()
    return True                    

# 동빈은 이것을 left만 이용해서 해결했다. 
def seperate(word):
    if(word == ''):
        return ''
    left = 0
    right = 0
    for i in range(len(word)):
        if(word[i] == '('):
            left += 1
        else:
            right += 1 
        if(left==right):
            break
    return word[:i+1], word[i+1:]

# print(solution("(()())()"))
# print(solution(")("))
# print(solution("()))((()"))

## dongbin은 균형작힌 괄호 문자열을 만들 때나, 올바른 괄호 문자열인지 판단할 때 숫자 count를 이용했다는 점 
def dongbin(p):
    answer = ''
    if p == '':
        return answer
    index = balanced_index(p)
    u = p[:index + 1]
    v = p[index + 1:]
    if check_proper(u):
        answer = u + dongbin(v)
    else:
        answer = '('
        answer += dongbin(v)
        answer += ')'
        u = list(u[1:-1]) 
        for i in range(len(u)):
            if u[i] == '(':
                u[i] = ')'
            else:
                u[i] = '('
        answer += "".join(u)
    return answer

def balanced_index(p):
    count = 0 
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            count -= 1
        if count == 0:
            return i

def check_proper(p):
    count = 0 
    for i in p:
        if i == '(':
            count += 1
        else:
            if count == 0: 
                return False
            count -= 1
    return True 

# 이해가 안 간다 
def solution2(p):
    if p=='': return p
    r=True; c=0
    for i in range(len(p)):
        if p[i]=='(': c-=1
        else: c+=1
        if c>0: r=False
        if c==0:
            if r:
                return p[:i+1]+solution(p[i+1:])
            else:
                return '('+solution(p[i+1:])+')'+''.join(list(map(lambda x:'(' if x==')' else ')',p[1:i]) ))

print(solution2("(()())()"))
# print(solution(")("))
# print(solution("()))((()"))
