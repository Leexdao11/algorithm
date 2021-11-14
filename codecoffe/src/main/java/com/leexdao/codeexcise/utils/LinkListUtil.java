package com.leexdao.codeexcise.utils;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @author lee
 * @date 2021/11/11 9:51
 * 链表工具类
 */
public class LinkListUtil {


    public static class Node{
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }


   public static  class  LinkList{

        //链表头指针
       private Node head;
        //链表尾指针
       private Node last;
        //链表长度
       private int  size;


       /**
        * @param data 插入值
        * @param index 插入位置
        */
       //链表插入
       public void  insert(int data,int index) throws Exception {

           if(index<0||index>size){
              throw new Exception("超出链表范围！");
           }
           Node node=new Node(data);
           //链表为空
           if (size==0){

               head=node;
               last=node;
           }else if(index==0){
               //头部插入
               node.next=head;
               head=node;
           }else if(index==size){
               //尾部插入
              last.next=node;
              last=node;
           }else{
               //中间插入
               //找到插入的位置
             Node preNode= get(index-1);

             node.next=preNode.next;
             preNode.next=node;

           }
           size++;
       }

       private Node get(int index) {

           Node temp=head;

           for (int i = 0; i < index; i++) {
               temp=temp.next;
           }

          return temp;

       }

      public void  printNode(){
           Node temp=head;
           while (temp!=null){
               System.out.println(temp.data);
               temp=temp.next;
           }
      }


       public int getSize() {
           return size;
       }

       public Node getHead() {
           return head;
       }

       public Node getLast() {
           return last;
       }

       public void setHead(Node head) {
           this.head = head;
       }
   }

}
