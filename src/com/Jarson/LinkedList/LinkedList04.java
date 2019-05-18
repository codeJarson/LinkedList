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

   新增get方法
        思路：
            1.通过索引获取元素值       get（int idnex）
            2.首先需要判断索引值，是否在该链表长度范围内    if（index<size-1）
            3.若在范围内，则执行挨个查找，            ·   fori
            4.从第一个firstNode开始，                  temp  = firstNode
       链表的查询效率低，我们需要折半查找，所以需要>>1
   新增remove方法   remove（int index）
        思路：
            通过索引来移除元素       Node temp3 = getNode（index）
            1. 我们需要封装一个getNode方法，调用
            2.取得值后，我们现在已知的变量temp3，通过他的privous和next取得前后的两个节点，     frontNode=temp3.privous    behindNode=temp3.next
            3.将前后的两个节点重新分配，如何分配？？？
                frontNode.next = behindNode     behindNode.privous = frontNode
            4.判断，如果删除的元素为第一个的话
                     if  index==0，firstNode=behindNode
                   如果删除的元素为最后一个
                     fi index==size-1 lastNode = frontNode

  新增节点插入方法add（）
        思路：
            从哪插入？？？     index索引值
             插入的节点？？？       新的节点   Node newNode= new Node（object obj）
            1.取得该索引的节点，  Node temp4 = getNode（index）
            2.继续取得前后两个节点        frontNode=temp4.privous    behindNode=temp4.next
            3.frontNode.next 的值指向新的节点 （newNode）
            4. 新的节点 （newNode）.next（.privous）指向temp4（frontNode）
                。。。。。以此类推
 */
public class LinkedList04 {
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
            size++;
    }
    //节点插入方法    [a,b,c,d,e,f]
    public void addNode(int index,Object obj){
        //做判断
        if(index<0||index>size-1) {
            throw new RuntimeException("索引不合法：" + index);
        }
        //创建一个新的节点
        Node newNode= new Node(obj);
        Node temp4 = getNode(index);
        if(temp4!=null){
            Node frontNode = temp4.privous;


            if(frontNode!=null){
                frontNode.next = newNode;
                newNode.privous = frontNode;
                newNode.next = temp4;
                temp4.privous = newNode;
            }
           if(index==0){
               firstNode.privous = newNode;
               newNode.next = firstNode;
               firstNode = newNode;

           }

        }
    }
    //[a,b,c,d,e,f]
    public void remove(int index){  //传入索引值
        Node temp3 = getNode(index);    //取得节点
        if (temp3!=null){
            Node frontNode = temp3.privous;
            Node behindNode = temp3.next;
            //第一种情况
            if(frontNode!=null){
                frontNode.next = behindNode;
            }
            if(behindNode!=null){
                behindNode.privous = frontNode;
            }
            //第二种情况
            if(index==0){
                firstNode = behindNode;
            }
            if(index==size-1){
                lastNode = frontNode;
            }
            size--;
        }

    }
   public Object get(int index){
           Node temp2 =  getNode(index);
        return temp2!=null?temp2.element:null;

   }
   public Node getNode(int index){
       Node temp2 = null;   //临时节点
       //做判断
       if(index<0||index>size-1){
           throw new RuntimeException("索引不合法："+index);
       }else{
           //[a,b,c,d]

           if(index<=(size>>1)){
               temp2 = firstNode; //指代第一个节点
               for(int i = 0;i<index;i++){
                   temp2 = temp2.next;
               }
           }else{
               temp2 = lastNode;   //指代最后一个节点
               for(int j = size-1;j>index;j--){
                   temp2 = temp2.privous;

               }

           }

       }
       return temp2;
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
        LinkedList04 linkedList01 = new LinkedList04();
            linkedList01.add("a");
            linkedList01.add("b");
            linkedList01.add("c");
            linkedList01.add("d");
            linkedList01.add("e");
            linkedList01.add("f");
        System.out.println(linkedList01);
        //System.out.println(linkedList01.get(1));
        //linkedList01.remove(5);
        //System.out.println(linkedList01);
        linkedList01.addNode(5,"Jarson");
        System.out.println(linkedList01);
    }
}
