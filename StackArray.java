// convert infix to prefix using dynamic created stack

import java.util.Stack;

public class StackArray {
    private int top;
    private int maxSize;
    private char[] array;

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.array = new char[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(char item) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        array[++top] = item;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return Character.MIN_VALUE;
        }
        return array[top--];
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return Character.MIN_VALUE;
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

    public static String infixToPrefix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (isOperand(ch)) {
                result.insert(0, ch);
            } else if (ch == ')') {
                stack.push(ch);
            } else if (ch == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result.insert(0, stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == ')') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.insert(0, stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String expression = "((a/b)+c)-(d+(e*f))";
        System.out.println("Infix Expression: " + expression);
        System.out.println("Prefix Expression: " + infixToPrefix(expression));
    }
}
