


public class SinglyLinkedList{

    private ListNode head;

    public SinglyLinkedList(){
        head = null;
    }

    public void makeListFromArray(int [] array) {
        ListNode p;
        ListNode t = new ListNode(array[0]);
        this.head = t;
        p = this.head;
        for (int i = 1, n = array.length; i < n; i++) {
            t = new ListNode(array[i]);
            p.next = t;
            p = t;
        }
    }

    public boolean searchForNode(ListNode t){
        ListNode p = head;
        while( p != null){
            if(p.getVal() == t.getVal()){
                System.out.println("true");
                return true;
            }
            p = p.next;
        }
        System.out.println("false");
        return false;
    }

    public void sortedInsert(ListNode t){
        if( head == null){
            head = t;
            return;
        }//else
        else if (t.getVal() < head.getVal()){
            t.next = head;
            head = t;
            return;
        }
        ListNode p = head, q = p;
        while( p != null && t.getVal() > p.getVal()) {
            q = p;
            p = p.next;
        }
        q.next = t;
        t.next = p;
    }

    public ListNode getHead() {
        return head;
    }

    public void display() {
        ListNode p = head;
        while( p != null){
            System.out.print(p.getVal() + " ");
            p = p.next;
        }
    }

}

