package Algortihms;

class ListNode1{
    int data;
    ListNode1 next;

    public ListNode1(){

    }

    public ListNode1(int data){
        this.data=data;
    }

    public ListNode1(ListNode1 next,int data){
        this.data=data;
        this.next=next;
    }
}
public class RemoveNthNodeFromEnd {
    public static ListNode1 createList(int [] arr){

        if(arr.length==0){
            return null;
        }

        ListNode1 head=new ListNode1(arr[0]);
        ListNode1 curr=head;

        for(int i=1;i<arr.length;i++){
            ListNode1 node=new ListNode1(arr[i]);
            curr.next=node;
            curr=curr.next;
        }

        return head;
    }

    public static void printList(ListNode1 head){
        if(head==null || head.next==null){
            System.out.println(head.data);
        }

        ListNode1 curr=head;

        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        if(head==null){
            return null;
        }
        if(head.next==null && n==1){
            return null;
        }
        int count=0;

        ListNode1 curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }

        if(count==n){
            head=head.next;
            return head;
        }

        ListNode1 prev=null;
        int c=0;
        curr=head;
        while(c<count-n && curr!=null){
            prev=curr;
            curr=curr.next;
            c++;
        }

        prev.next=curr.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd obj=new RemoveNthNodeFromEnd();
        int arr[]={1,2,3,4,5};
        int n=2;

        ListNode1 head=createList(arr);

        System.out.println("Before nth node removal");

        printList(head);

        ListNode1 modifiedHead=obj.removeNthFromEnd(head,n);

        System.out.println("After nth node removal");

        printList(modifiedHead);
    }
}
