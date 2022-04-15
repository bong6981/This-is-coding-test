from __future__ import annotations ## forward referencing이 이루어지도록 할 수 있습니다.
## https://ryanking13.github.io/2018/07/12/python-37-whats-new.html
from operator import is_
from typing import Any


class Node:
    def __init__(self, key:Any, value:Any, left:Node = None, right: Node = None):
        self.key = key
        self.value = value
        self.left = left
        self.right = right  # 오른쪽 포인터(오른쪽 자식 참조)


class BinarySearchTree:

    def __init__(self):
        self.root = None  
    
    def search(self, key: Any) -> Any:
        p = self.root           # 루트에 주목
        while True:
            if p is None:       # 더 이상 진행할 수 없으면
                return None     # 검색 실패
            if key == p.key:    # key와 노드 p의 키가 같으면
                return p.value  # 검색 성공
            elif key < p.key:   # key 쪽이 작으면
                p = p.left      # 왼쪽 서브 트리에서 검색
            else:               # key 쪽이 크면
                p = p.right     # 오른쪽 서브 트리에서 검색

    
    def add(self, key: Any, value: Any) -> bool:
        def add_node(node: Node, key: Any, value: Any) -> None:
            if key == node.key:
                return False  # key가 이진검색트리에 이미 존재
            elif key < node.key:
                if node.left is None:
                    node.left = Node(key, value, None, None)
                else:
                    add_node(node.left, key, value)
            else:
                if node.right is None:
                    node.right = Node(key, value, None, None)
                else:
                    add_node(node.right, key, value)
            return True

        if self.root is None:
            self.root = Node(key, value, None, None)
            return True
        
        return add_node(self.root, key, value)

    def remove(self, key:Any) -> bool:
        p = self.root  # 스캔 중인 노드
        parent = None   # 스캔 중인 노드의 부모 노드
        is_left_child = True  # p는 parent의 왼쪽 자식 노드인지 확인

        ## 삭제할 키를 검색
        while True:
            if p is None:
                return False
            if key == p.key: # key와 노드 p의 키가 같으면
                break   # 검색 성공
            else:
                parent = p
                if key < p.key:
                    is_left_child = True
                    p = p.left
                else:
                    is_left_child = False
                    p = p.right
        
        ## 자식노드가 없는 노드를 삭제하는 경우, 자식 노드가 1개인 노드를 삭제하는 경우
        if p.left is None:      # p에 왼쪽 자식이 없으면
            if p is self.root: 
                self.root = p.right
            elif is_left_child:
                parent.left = p.right
            else:
                parent.right = p.right
        elif p.right is None:
            if p is self.root:
                self.root = p.left
            elif is_left_child:
                parent.left = p.left
            else:
                parent.right - p.left
        ## 자식 노드가 2개인 노드 삭제 
        else:
            parent = p
            left = p.left
            is_left_child = True
            while left.right is not None:
                parent = left
                left = left.right
                is_left_child = False
            p.key = left.key
            p.value = left.value
            if is_left_child:
                parent.left = left.left
            else:
                parent.right = left.left
        return True
            





