package com.Jarson.LinkedList;

/**
 * @author Jarson
 * @create 2019-05-18 11:28
 */
/*
     简单的节点实体类
        结构：
            1.上一个节点，2.元素数据，3.下一个节点

 */
public class Node {
    Node privous;   //上一個節點
     Object element;//元素数据
    Node next;  //下一个节点


    public Node() {
    }

    public Node(Node privous, Object element, Node next) {
        this.privous = privous;
        this.element = element;
        this.next = next;
    }

    public Node(Object element) {
        this.element = element;
    }
}
