package Algortihms;

import java.util.LinkedHashMap;

//1->2->3->4->5
class ListNode{
    ListNode next;
    int data;

    ListNode() {}
    ListNode(int data){
        this.data=data;
    }
    ListNode(int data,ListNode next){
        this.data=data;
        this.next=next;
    }
}
public class ListNodeDemo {
    ListNode head;
    public ListNodeDemo() {
        head=null;
    }

    public int get(int index) {
        if(index<0){
            return -1;
        }
        ListNode curr=head;

        int count=0;
        while(curr!=null){
            if(index==count){
                return curr.data;
            }
            curr=curr.next;
            count++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode curr=new ListNode(val);
        if(head==null){
            head=curr;
            return;
        }
        curr.next=head;
        head=curr;
    }

    public void addAtTail(int val) {
        ListNode node=new ListNode(val);
        if(head==null){
            head=node;
            return;
        }

        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }

        curr.next=node;
    }

    public void addAtIndex(int index, int val) {
        if(index<0){
            return;
        }
        int count=0;

        if(index==0){
            addAtHead(val);
            return;
        }

        ListNode curr=head;
        ListNode prev=null;
        ListNode node=new ListNode(val);

        while(curr!=null && count<index){
            prev=curr;
            curr=curr.next;
            count++;
        }
        if(count!=index){
            return;
        }
        prev.next=node;
        node.next=curr;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || head==null){
            return;
        }
        if(index==0){
            head=head.next;
            return;
        }
        int count=0;

        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null && count<index){
            prev=curr;
            curr=curr.next;
            count++;
        }
        if(curr==null){
            return;
        }
        prev.next=curr.next;
    }
}
