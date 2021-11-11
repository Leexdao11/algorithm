package com.leexdao.codeexcise.linklist;

import com.leexdao.codeexcise.utils.LinkListUtil;

/**
 * @author lee
 * @date 2021/11/11 11:35
 * 回文数
 * 判断一个用链表存储的数字是不是回文数
 *
 *
 * 大致思路如下
 * 由于回文串最重要的就是对称，那么最重要的问题就是找到那个中心，
 * 用快指针每步两格走，当他到达链表末端的时候，慢指针刚好到达中心，
 * 慢指针在过来的这趟路上还做了一件事，他把走过的节点反向了，
 * 在中心点再开辟一个新的指针用于往回走，而慢指针继续向前，
 * 当慢指针扫完整个链表，就可以判断这是回文串，否则就提前退出，
 * 总的来说时间复杂度按慢指针遍历一遍来算是O(n),空间复杂度因为只开辟了3个额外的辅助，所以是o(1)
 */
public class Palindrome {


    public static void main(String[] args) throws Exception {
        //构建回文数链表
        LinkListUtil.LinkList linkList=new LinkListUtil.LinkList();
        linkList.insert(1,0);
        linkList.insert(6,1);
        linkList.insert(8,2);
        linkList.insert(6,3);
        linkList.insert(1,4);

        LinkListUtil.Node preNode=null;
        LinkListUtil.Node slowNode=linkList.getHead();
        LinkListUtil.Node quickNode=linkList.getHead();


        while (quickNode.next!=null){
            quickNode=quickNode.next.next;
            LinkListUtil.Node temp=slowNode.next;
            slowNode.next=preNode;
            preNode=slowNode;
            slowNode=temp;
        }

        //这里是因为当慢指针到了中心，但是preNode还在前一个节点  为了保持pre和后续的slowNode比较数据 所以就需要将slowNode后移一位，两个指针对齐数据
        slowNode=slowNode.next;

        boolean flag=true;
        while (slowNode!=null){
            if(slowNode.data==preNode.data){
                slowNode=slowNode.next;
                preNode=preNode.next;
            }
           flag=false;
            break;
        }

        if(flag){
            System.out.println("该链表是回文数");
        }else {
            System.out.println("该链表是回文数");
        }

    }
}
