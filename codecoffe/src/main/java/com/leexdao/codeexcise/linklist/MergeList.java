package com.leexdao.codeexcise.linklist;

import com.leexdao.codeexcise.utils.LinkListUtil;

/**
 * @author lee
 * @date 2021/11/18 16:07
 * 合并两个有序链表
 */
public class MergeList {

    public static void main(String[] args) throws Exception {
        LinkListUtil.LinkList l1=new LinkListUtil.LinkList();
        l1.insert(1,0);
        l1.insert(2,1);
        l1.insert(4,2);
        l1.insert(6,3);


        LinkListUtil.LinkList l2=new LinkListUtil.LinkList();
        l2.insert(1,0);
        l2.insert(3,1);
        l2.insert(5,2);
        l2.insert(8,3);
        l2.insert(9,4);

        LinkListUtil.Node node = mergeList(l1, l2);
        while (node.next!=null){
            System.out.println(node.data);
            node=node.next;
        }

    }

    public static LinkListUtil.Node mergeList(LinkListUtil.LinkList l1, LinkListUtil.LinkList l2){
        LinkListUtil.Node preHead = new LinkListUtil.Node(0);
        LinkListUtil.Node prev=preHead;
        LinkListUtil.Node temp1=l1.getHead();
        LinkListUtil.Node temp2=l2.getHead();
        while (temp1!=null&&temp2!=null) {
            if (temp1.data <= temp2.data) {
                prev.next = temp1;
                temp1 = temp1.next;

            } else {
                prev.next = temp2;
                temp2 = temp2.next;
            }
            prev=prev.next;
        }
        prev.next=temp1==null?temp2:temp1;

        return preHead.next;
    }
}
