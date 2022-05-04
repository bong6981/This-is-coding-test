# 시간초과 나서 답 보고 풀었습니다. (답풀이 그대로)
class Solution:
    def expand(self, left, right, s):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left+1:right]
    
    def longestPalindrome(self, s: str) -> str:
        if len(s) < 2 or s == s[::-1]:
            return s

        result = ''

        for i in range(len(s)-1):
            result = max(result,
            self.expand(i, i+1, s),
            self.expand(i, i+2, s),
            key=len)
        return result



## 시간초과로 답지 보고 품

# dp 사용했지만 초과 
# class Solution:
#     def is_pal(self, pal, i, j, str):
#         if pal[i][j] != -1:
#             return pal[i][j]

#         if i==j:
#             return True

#         if i+1 == j:
#             return str[i] == str[j]
        
#         if str[i]!= str[j]: return False

#         return self.is_pal(pal, i+1, j-1, str)

#     def longestPalindrome(self, s: str) -> str:
#         N = len(s)
#         pal = [[-1] * N for _ in range(N)]

#         for l in range(N, -1, -1):
#             for i in range(N-l+1):
#                 j = i + l - 1
#                 if s[i] == s[j]:
#                     if self.is_pal(pal, i, j, s):
#                         return s[i:j+1]


# 길이를 최대치부터 접근하며 안되는 값들을 dp에 넣어줬을 때 초과
# class Solution:
#     def pal_pro(self, i, j, pal, s):
#         while i >= 0 and j < s and s[i:j+1] != s[i:j+1][::-1]:
#             pal[i][j] = False 
#             i -= 1
#             j += 1
    

 
#     def longestPalindrome(self, s: str) -> str:
#         if len(s) < 2 or s == s[::-1]:
#             return s
#         N = len(s)
#         pal = [[-1] * N for _ in range(N)]

#         for l in range(N, -1, -1):
#             for i in range(N-l+1):
#                 j = i + l - 1
#                 if not pal[i][j]:
#                     continue 
#                 ns = s[i:j+1]
#                 if ns == ns[::-1]:
#                     return ns
#                 else:
#                     self.pal_pro(i, j, pal, s)
                    

