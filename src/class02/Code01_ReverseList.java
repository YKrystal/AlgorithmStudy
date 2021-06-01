package class02;

/**
 * 反转链表
 *
 * @author YKrystal
 * @date 2021/6/1
 */
public class Code01_ReverseList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 反转单链表
     *
     * @param head 传入的链表的头
     * @return 新的头节点
     */
    public static Node reverseNode(Node head) {
        // 要返回心头
        Node newHead = null;
        // 记录下一个节点的位置
        Node next = null;
        while (head != null) {
            // 先记录head的next
            next = head.next;
            // head的next指向新头
            head.next = newHead;
            // 改变当前新头的位置
            newHead = head;
            // head往下移
            head = next;
        }

        return newHead;
    }

    static class DoubleNode {
        DoubleNode last;
        int value;
        DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    public static DoubleNode reverseDoubleNode(DoubleNode head) {
        DoubleNode newHead = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;

            // 挪动两条线
            head.next = newHead;
            head.last = next;

            // 更新变量
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println("-----------反转单链表-----------");

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("---反转前---");

        Node temp = head;
        while (temp != null) {
            System.out.printf("%d->", temp.value);
            temp = temp.next;
        }
        System.out.println();

        System.out.println("---反转后---");
        Node newHead = reverseNode(head);
        temp = newHead;
        while (temp != null) {
            System.out.printf("%d->", temp.value);
            temp = temp.next;
        }
        System.out.println();

        System.out.println("-----------反转双链表-----------");
        DoubleNode doubleHead = new DoubleNode(1);
        doubleHead.next = new DoubleNode(2);
        doubleHead.next.next = new DoubleNode(3);
        doubleHead.next.next.next = new DoubleNode(4);
        doubleHead.next.next.next.next = new DoubleNode(5);

        System.out.println("---反转前---");
        DoubleNode tmp = doubleHead;
        while (tmp != null) {
            System.out.printf("%d->", tmp.value);
            tmp = tmp.next;
        }
        System.out.println();

        System.out.println("---反转后---");
        DoubleNode newDoubleHead = reverseDoubleNode(doubleHead);
        tmp = newDoubleHead;
        while (tmp != null) {
            System.out.printf("%d->", tmp.value);
            tmp = tmp.next;
        }
        System.out.println();
    }

}
