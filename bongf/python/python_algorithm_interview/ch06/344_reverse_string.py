# 349ms, 18.5MB 

def reverseString(s) -> None:
    for i in range(len(s)//2):
        j = len(s) -1 -i
        s[i], s[j] = s[j], s[i]
    print(s)

reverseString(["h","e","l","l","o"])
reverseString(["H","a","n","n","a","h"])
  
        