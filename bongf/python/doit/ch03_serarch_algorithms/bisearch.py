from typing import Any, Sequence

def bin_search(arr: Sequence, key: Any) -> int:
    """시퀀스 a에서 key와 일치하는 원소를 이진 검색"""
    pl = 0
    pr = len(arr) -1

    while True:
        pc = (pl + pr) // 2
        if arr[pc] == key:
            return pc
        if arr[pc] < key:
            pl = pc + 1
        else:
            pr = pc -1
        if pl > pr:
            break
    
    return -1

