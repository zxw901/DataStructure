package com.company.ch11_AVLTree;

import java.util.ArrayList;

public class AVLTree <K extends Comparable<K>,V> {

        public class Node {
            private K key;
            private V value;
            private Node left;
            private Node right;
            private int height;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
                this.left = null;
                this.right = null;
                this.height=1;
            }

            public Node(K key) {
                this(key, null);
            }

            public Node() {
                this(null, null);
            }
        }

        private Node root;
        private int size;

        public AVLTree() {
            root = null;
            size = 0;
        }

        //获得节点 node 的高度
        private int getHeight(Node node){
            if(node==null)
                return 0;
            return node.height;
        }

        //获得节点 node 的平衡因子
        private int getBalanceFactor(Node node){
            if(node==null)
                return 0;
            return getHeight(node.left)-getHeight(node.right);
        }

        //判断该二叉树是否是一棵二分搜索树
        public boolean isBST(){
            ArrayList<K> keys=new ArrayList<>();
            inOrder(root,keys);
            for (int i = 1; i < keys.size(); i++) {
                if(keys.get(i-1).compareTo(keys.get(i))>0)
                    return false;
            }
            return true;
        }

        private void inOrder(Node node,ArrayList<K> keys){
            if(node==null)
                return;
            inOrder(node.left,keys);
            keys.add(node.key);
            inOrder(node.right,keys);
        }

        //判断该二叉树是否是一棵平衡二叉树
        public boolean isBalanced(){
            return isBalanced(root);
        }

        private boolean isBalanced(Node node){
            if(node==null)
                return true;
            if(getBalanceFactor(node)>1)
                return false;
            return isBalanced(node.left)&&isBalanced(node.right);
        }

        //寻找二分搜索树的最小元素
        public V minimum() {
            if (size == 0) {
                throw new IllegalArgumentException("AVLTree is empty!");
            }
            return minimum(root).value;
        }

        private Node minimum(Node node) {
            if (node.left == null) {
                return node;
            }
            return minimum(node.left);
        }

        //删除树中的最小值
        public V removeMin() {
            V ret = minimum();
            root = removeMin(root);
            return ret;
        }

        private Node removeMin(Node node) {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            node.left = removeMin(node.left);
            return node;
        }

        private Node getNode(Node node, K key) {
            if (node == null)
                return null;
            if (key.compareTo(node.key) < 0)
                return getNode(node.left, key);
            else if (key.compareTo(node.key) > 0)
                return getNode(node.right, key);
            else
                return node;
        }

        private Node rightRotate(Node y){
            Node x=y.left;
            Node T3=x.right;

            x.right=y;
            y.left=T3;

            y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
            x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;

            return x;
        }

        private Node leftRotate(Node y){
            Node x=y.right;
            Node T2=x.left;

            x.left=y;
            y.right=T2;

            y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
            x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;

            return x;
        }

        public void add(K key, V value) {
            root = add(root, key, value);
        }

        private Node add(Node node, K key, V value) {
            if (node == null) {
                size++;
                return new Node(key, value);
            }
            if (key.compareTo(node.key) < 0)
                node.left = add(node.left, key, value);
            else if (key.compareTo(node.key) > 0)
                node.right = add(node.right, key, value);
            else
                node.value = value;

            //更新 height
            node.height=1+Math.max(getHeight(node.left),getHeight(node.right));

            //计算平衡因子
            int balanceFactor=getBalanceFactor(node);
//            if(Math.abs(balanceFactor)>1)
//                System.out.println("unbalanced : "+balanceFactor);

            //维护平衡
            //LL
            if(getBalanceFactor(node)>1&&getBalanceFactor(node.left)>=0)
                return rightRotate(node);

            //RR
            if(getBalanceFactor(node)<-1&&getBalanceFactor(node.right)<=0)
                return leftRotate(node);

            //LR
            if(getBalanceFactor(node)>1&&getBalanceFactor(node.left)<0)
            {
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }

            //RL
            if(getBalanceFactor(node)<-1&&getBalanceFactor(node.right)>0)
            {
                node.right=rightRotate(node.right);
                leftRotate(node);
            }

            return node;
        }

        public V remove(K key) {
            Node node = getNode(root, key);
            if (node != null) {
                root = remove(root, key);
                return node.value;
            }
            return null;
        }

        private Node remove(Node node, K key) {

            if (node == null) {
                return null;
            }

            if (key.compareTo(node.key) < 0) {
                node.left = remove(node.left, key);
                return node;
            }
            else if (key.compareTo(node.key) > 0) {
                node.right = remove(node.right, key);
                return node;
            }
            else {
                if (node.left == null) {
                    Node rightNode = node.right;
                    node.right = null;
                    size--;
                    return rightNode;
                }
                if (node.right == null) {
                    Node leftNode = node.left;
                    node.left = null;
                    size--;
                    return leftNode;
                }
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }

        public boolean contains(K key) {
            return getNode(root, key) != null;
        }

        public void set(K key, V value) {
            Node node = getNode(root, key);
            if (node == null)
                throw new IllegalArgumentException(key + " doesn't exist!");
            node.value = value;
        }

        public V get(K key) {
            Node node = getNode(root, key);
            return node == null ? null : node.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int getSize() {
            return size;
        }
}
