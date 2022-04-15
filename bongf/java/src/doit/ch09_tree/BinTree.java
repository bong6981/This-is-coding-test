package doit.ch09_tree;

import java.util.Comparator;

public class BinTree<K, V> {
    static class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }

    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2)
                : comparator.compare(key1, key2);
    }

    private V search(K key) {
        Node<K, V> p = root;

        while (true) {
            if (p == null) {
                return null;
            }
            int cond = comp(key, p.getKey());
            if (cond == 0) {
                return p.getValue();
            } else if (cond < 0) {
                p = p.left;;
            } else {
                p = p.right;
            }
        }
    }

    // node를 뿌리로 하는 서브트리에 노드 <K,V>를 삽입
    private void addNode(Node<K, V> node, K key, V value) {
        int cond = comp(key, node.getKey());

        if (cond == 0) {
            return;
        } else if ( cond < 0) {
            if(node.left == null) {
                node.left = new Node<K, V>(key, value, null, null);
            } else {
                addNode(node.left, key, value);
            }
        } else {
            if (node.right == null)
                node.right = new Node<K,V>(key, value, null, null);
            else
                addNode(node.right, key, value);
        }
    }

    public void add(K key, V value) {
        if(root == null) {
            root = new Node<K, V>(key, value, null, null);
        } else {
            addNode(root, key, value);
        }
    }

    public boolean remove(K key) {
        Node<K, V> p = root; // 스캔 중인 노드
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while(true) {
            if(p == null) {
                return false;
            }
            int cond = comp(key, p.getKey());
            if(cond == 0) {
                break;
            } else {
                parent = p;
                if( cond < 0) {
                    isLeftChild = true;
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        if(p.left == null) {
            if(p == root) {
                root = p.right;
            } else if(isLeftChild) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        } else if (p.right == null) {
            if (p == root)
                root = p.left;
            else if (isLeftChild)
                parent.left  = p.left;
            else
                parent.right = p.left;
        } else {
            parent = p;
            Node<K, V> left = p.left;
            isLeftChild = true;
            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key;
            p.data = left.data;
            if(isLeftChild) {
                parent.left = left.left;
            } else {
                parent.right = left.left;
            }
        }
        return true;
    }
}
