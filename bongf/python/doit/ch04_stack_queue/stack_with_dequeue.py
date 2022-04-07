# 고정 길이 스택 클래스 FixedStack 구현하기
from typing import Any
from collections import deque

class FixedStack:

    # class Empty(Exception):
    #     """비어 있는 FixedStack에 pop 또는 peek를 호출할 때 내보내는 예외 처리"""
    #     pass

    # class Full(Exception):
    #     """가득 찬 FixedStack에 push를 호출할 때 내보내는 예외 처리"""
    #     pass
    
    def __init__(self, capacity: int = 256) -> None:
        self.__stk = deque([], capacity) #스택본체
        self.capacity = capacity
    
    def __len__(self) -> int:
        """스택에 쌓여있는 데이터 개수를 반환"""
        return len(self.__stk)

    def is_empty(self) -> bool:
        """스택이 비어 있는가?"""
        return not self.__stk

    def is_full(self) -> bool:
        """스택은 가득 찼는가?"""
        return len(self.__stk) == self.__stk.maxlen

    def push(self, value:Any) -> None:
        self.__stk.append(value)

    def pop(self) -> Any:
        return self.__stk.pop()

    def peek(self) -> Any:
        return self.__stk[-1]
    
    def clear(self) -> None:
        self.__stk.clear()

    def find(self, value:Any) -> Any:
        try:
            return self.__stk.index(value)
        except ValueError:
            return -1
    
    def count(self, value:Any) -> int:
        return self.__stk.count(value)
    
    def __contains__(self, value: Any) -> bool:
        return self.count(value)

    def dump(self) -> None:
        print(list(self.__stk))

    
