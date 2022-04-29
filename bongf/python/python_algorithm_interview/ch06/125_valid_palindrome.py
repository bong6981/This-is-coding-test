#10.04
def isPalindrome(s: str) -> bool:
    new_s = ""
    for c in s:
        if c.isalpha() or c.isdigit():
            new_s += c.lower()

    is_palindrome = True
    if new_s == "":
        return True
    for i in range((len(new_s)-1)//2+1):
        j = len(new_s) -1 -i
        if new_s[i] != new_s[j]:
            is_palindrome = False
            break
    return is_palindrome

print(isPalindrome(input()))


## 교재재공 문제풀이 
import re
def isPalindrome(s: str) -> bool:
    s.lower()
    s = re.sub('[^a-z0-9]', '', s)
    return s == s[::-1]
