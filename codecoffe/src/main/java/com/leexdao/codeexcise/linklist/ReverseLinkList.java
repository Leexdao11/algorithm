package com.leexdao.codeexcise.linklist;

import com.leexdao.codeexcise.utils.LinkListUtil;
import org.springframework.aop.scope.ScopedProxyUtils;


/**
 * @author lee
 * @date 2021/11/11 9:50
 * 反转链表
 *
 *思路  采用两个指针将链表的局部一一反转
 */
public class ReverseLinkList {


    public static void main(String[] args) throws Exception {
        //新建链表

        LinkListUtil.LinkList linkList=new LinkListUtil.LinkList();

        linkList.insert(1,0);
        linkList.insert(5,1);
        linkList.insert(7,2);
        linkList.insert(6,3);
        linkList.insert(9,4);
        linkList.insert(3,5);
        //初始链表
         linkList.printNode();

        LinkListUtil.Node head =linkList.getHead();

        LinkListUtil.Node  curr= null;
        LinkListUtil.Node  pre= head;


        while (pre!=null){
            LinkListUtil.Node temp=pre.next;
            pre.next=curr;
            curr=pre;
            pre=temp;
        }

        LinkListUtil.Node temp = curr;
        //反转链表
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}
