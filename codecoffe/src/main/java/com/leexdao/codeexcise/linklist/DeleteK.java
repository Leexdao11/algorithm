package com.leexdao.codeexcise.linklist;

import com.leexdao.codeexcise.utils.LinkListUtil;

/**
 * @author lee
 * @date 2021/11/14 19:25
 *删除链表的倒数第k个节点
 *思路：删除倒数第k个节点  假设链表长度为n,就是遍历到n-k个节点，然后删除此节点的下一个节点即可
 */
public class DeleteK {

    public static void main(String[] args) throws Exception {
        //初始化链表
        LinkListUtil.LinkList list=new LinkListUtil.LinkList();
        list.insert(1,0);
        list.insert(2,1);
        list.insert(8,2);
        list.insert(4,3);



       // deleteKNoded(list,2);
        LinkListUtil.Node node = deleteKNodedPro(list, 4);
        list.setHead(node);
        list.printNode();
    }

    public static  void  deleteKNoded(LinkListUtil.LinkList list ,int k){
        //遍历到n-k个节点
        LinkListUtil.Node temp=list.getHead();
        for (int i = 0; i <list.getSize()-k -1; i++) {
            temp=temp.next;
        }

        //删除倒数第k个节点
        temp.next=temp.next.next;
    }

    public static  LinkListUtil.Node  deleteKNodedPro(LinkListUtil.LinkList list ,int k){

        /**采用快慢指针的方法，快指针比慢指针快n个节点
         * 当快指针的next节点为null时，此时慢指针的next节点就是要删除的节点
         * */
        LinkListUtil.Node head=list.getHead();
        LinkListUtil.Node kNode=list.getHead();
        LinkListUtil.Node sNode=list.getHead();

        //快指针先走n个节点
        for (int i = 0; i <k ; i++) {
            kNode=kNode.next;
        }

        //当删除的节点为头节点
        if(kNode==null){
           head=head.next;
           return head;
        }

        while (kNode.next!=null){
            kNode=kNode.next;
            sNode=sNode.next;

        }
        //删除倒数第k个节点
        sNode.next=sNode.next.next;
        return head;
    }

}
