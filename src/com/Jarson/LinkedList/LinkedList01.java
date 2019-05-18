package com.Jarson.LinkedList;

/**
 * @author Jarson
 * @create 2019-05-18 11:28
 */
/*
    链表的结构：
        第一个节点
        最后一个节点
        链表的大小
 */
public class LinkedList01 {
    public Node firstNode;     // 第一个节点
    public Node lastNode;       //最后一个节点
    public int size;            //链表的大小

    public void add(Object obj){
        Node node = new Node(obj);
       //判断第一次调用的情况
       if(firstNode==null){
              //创建一个节点
           //因为是第一个节点，那么他的上与下都是为null
           node.privous = null;
           node.next = null;

            firstNode  =  node;
            lastNode = node;

       }else{           //之后调用的情况
           //[a,b,c,d]
            node.privous = lastNode;        //第三次调用时，若传入“c”，则它的上一个节点为之前的最后一个节点（b）
           node.next = null;                //并且它的下一个节点为空

           lastNode.next = node;         //最后一个节点的下一个则是add（）新的node
           lastNode =node;                  //而它变成最后一个节点




       }

    }

    @Override
    //[a,b,c,d]     重写toString修改格式
    public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("[");

              Node temp=firstNode;  //temp为第一个节点
            while (temp!=null){
                sb.append(temp.element+",") ; //输出当中的元素
                //扩展：循环到最后一个的时候，那么temp.next为null，则temp也为null，最后退出循环
                temp = temp.next;   //将当前temp的下一个节点赋给temp（b）
            }
                sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args){
        LinkedList01 linkedList01 = new LinkedList01();
            linkedList01.add("a");
            linkedList01.add("b");
            linkedList01.add("c");
        System.out.println(linkedList01);
    }
}
