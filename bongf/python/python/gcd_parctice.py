import math

def use_library():
    print(math.gcd(48, 56)) ## 8 
    ## lcm : 두수의 곱 나누기 gcd
    print(48 * 56 // math.gcd(48, 56)) ## 336

def gcd(m, n):
    if m < n :
        m, n = n, m
    if n == 0:
        return m 
    if m % n == 0:
        return n
    else:
        return gcd(n, m%n)

def gcd2(m, n):
    m, n = max(m, n), min(m, n)
    t = 1
    while t > 0 :
        t = m % n
        m, n = n, t
    return m

def gcd3(m, n):
    gcd = lambda m, n : n if not m%n else gcd(n, m%n)

