// Reverse a stack

public class StackReversal {

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static StackNode top = null;

    static boolean isEmpty() {
        return top == null;
    }

    static void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    static int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            System.exit(1);
        }
        int res = top.data;
        top = top.next;
        return res;
    }

    static void insertAtBottom(int item) {
        if (isEmpty()) {
            push(item);
        } else {
            int temp = pop();
            insertAtBottom(item);
            push(temp);
        }
    }

    static void reverse() {
        if (!isEmpty()) {
            int temp = pop();
            reverse();
            insertAtBottom(temp);
        }
    }

    static void printStack() {
        System.out.println();
        StackNode current = top;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        push(4);
        push(3);
        push(2);
        push(1);

        System.out.println("Original Stack:");
        printStack();

        reverse();

        System.out.println("\nReversed Stack:");
        printStack();
    }
}
