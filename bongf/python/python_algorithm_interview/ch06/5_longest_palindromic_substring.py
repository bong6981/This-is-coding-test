


# 시간초과 나서 답 보고 풀었습니다. (답풀이 그대로)
def longestPalindrome(self, s: str) -> str:
    def expand(left: int, right:int) -> str:
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left+1:right]

    if len(s) < 2 or s == s[::-1]:
        return s

    for i in range(len(s)-1):
        result = max(result,
        expand(i, i+1),
        expand(i, i+2),
        key=len)





# def longestPalindrome(s: str) -> str:
#     N = len(s)
#     pal = [[-1] * N for _ in range(N)]

#     for l in range(N, -1, -1):
#         for i in range(N-l+1):
#             j = i + l - 1
#             if s[i] == s[j]:
#                 if is_pal(pal, i, j, s):
#                     return s[i:j+1]


# def is_pal(pal, i, j, str):
#     if pal[i][j] != -1:
#         return pal[i][j]
    
#     if i==j: return True
    
#     if i+1 == j: return str[i] == str[j]
    
#     if str[i]!= str[j]: return False
#     return is_pal(pal, i+1, j-1, str)

# print(longestPalindrome("babad"))
# print(longestPalindrome("cbbd"))
print(longestPalindrome("aacabdkacaa"))

