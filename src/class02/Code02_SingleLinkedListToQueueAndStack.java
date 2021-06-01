package class02;

/**
 * 使用单链表实现队列和栈结构
 *
 * @author YKrystal
 * @date 2021/6/1
 */
public class Code02_SingleLinkedListToQueueAndStack {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    static class MyQueue {
        int size;
        Node first;
        Node last;


        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        /**
         * 添加一个value到队列中
         *
         * @param value 要添加的值
         */
        public void add(int value) {
            // 先把这个值装进节点
            Node node = new Node(value);
            // 第一次添加，两个属性都是null，没有节点元素，都指向这个添加的节点
            if (first == null) {
                first = node;
                last = node;
            } else {
                // first已经有指向，往last后加
                last.next = node;
                // last指向新添加的位置
                last = node;
            }
            size++;
        }

        /**
         * 获取队首元素
         *
         * @return
         */
        public int get() {
            int ans = 0;
            // 空队列
            if (first == null) {
                last = null;
                throw new RuntimeException("queue is empty");
            }

            ans = first.value;
            first = first.next;
            size--;

            return ans;
        }

        public int peek() {
            int ans = 0;
            if (first == null) {
                last = null;
                throw new RuntimeException("queue is empty");
            }

            ans = first.value;
            return ans;
        }
    }


    static class MyStack {
        Node head;
        int size;

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void add(int value) {
            Node node = new Node(value);
            // 第一次添加
            if (head == null) {
                head = node;
            } else {
                // 新来的next指向head
                node.next = head;
                // 头指向新添加进来的节点
                head = node;
            }
            size++;
        }

        public int get() {
            int ans = 0;
            if (head == null) {
                throw new RuntimeException("stack is empty");
            }
            ans = head.value;
            head = head.next;
            size--;
            return ans;
        }

        public int peek() {
            int ans = 0;
            if (head == null) {
                throw new RuntimeException("stack is empty");
            }
            ans = head.value;
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println("------------MyQueue------------");
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        // [1,2]
        System.out.println("queue.get() = " + queue.get());
        queue.add(3);
        // [1,3]
        System.out.println("queue.get() = " + queue.get());
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.get() = " + queue.get());

//        System.out.println(queue.get());

        System.out.println("------------MyStack------------");
        MyStack stack = new MyStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        // [3,2,1]
        System.out.println("stack.get() = " + stack.get());
        // [2,1]
        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.get() = " + stack.get());

    }
}
