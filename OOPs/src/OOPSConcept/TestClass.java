package OOPSConcept;

class ListNode {
    ListNode prev;
    ListNode next;
    int data;

    public ListNode() {
    }

    public ListNode(int data) {
        this.data=data;
    }

}



public class TestClass {
    public static ListNode addNode(ListNode head,int val){
        ListNode node=new ListNode(val);
        if(head==null){
            return node;
        }
        ListNode curr=head;

        while(curr.next!=null){
            curr=curr.next;
        }

        curr.next=node;
        node.prev=curr;
        return head;
    }

    public static ListNode removeNode(int val,ListNode head){
        if(head==null){
            return null;
        }
        ListNode curr=head;

        while(curr!=null){
            if(curr.data==val){
                ListNode prevNode=curr.prev;
                ListNode nextNode=curr.next;
                if(prevNode!=null){
                    prevNode.next=nextNode;
                }
                else{
                    head=nextNode;
                }

                if(nextNode!=null){
                    nextNode.prev=prevNode;
                }

                return head;
            }
            curr=curr.next;
        }
        return head;
    }
    public static void print(ListNode head){
        ListNode curr=head;

        if(curr==null){
            System.out.println("List is empty");
            return;
        }
        if(curr.next==null){
            System.out.println(curr.data);
            return;
        }
        while(curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }
    static void main(String[] args) {
        ListNode head=null;
        head=addNode(head,1);
        head=addNode(head,2);
        head=addNode(head,3);
        print(head);
        removeNode(2,head);
        print(head);
    }
}
