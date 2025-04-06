// infix to postfix by dynamic created stack

import java.util.Stack;

 public class StackArray2 {
    private int top;
    private int maxSize;
    private int[] array;

    public StackArray2(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.array = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        array[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return Integer.MIN_VALUE;
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return Integer.MIN_VALUE;
        }
        return array[top];
    }

    public static boolean isOperand(char ch) {
        return Character.isLetter(ch);
    }

    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String convertInfixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (isOperand(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        StackArray2 stack = new StackArray2(20);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());

        String expression = "((a+(b*c))-d)";
        System.out.println("Postfix Expression: " + convertInfixToPostfix(expression));
    }
}
