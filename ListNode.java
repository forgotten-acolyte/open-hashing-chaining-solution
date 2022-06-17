

public class ListNode {
    private int val;
    public ListNode next;

    public ListNode() {}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode listNode){
        this.val = val;
        this.next = listNode;
    }
}
