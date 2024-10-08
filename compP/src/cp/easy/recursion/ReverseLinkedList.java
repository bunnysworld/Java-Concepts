package cp.easy.recursion;

import java.util.List;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        ListNode mainNode = new ListNode();
        mainNode.val = 1;
        mainNode.next = new ListNode(2);
        mainNode.next.next = new ListNode(3);
        mainNode.next.next.next = new ListNode(4);
        mainNode.next.next.next.next = new ListNode(5);
        ListNode newNode = reverse(mainNode);
        System.out.println("dvfv");
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newNode;
    }

}
