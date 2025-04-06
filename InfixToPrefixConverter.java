public class InfixToPrefixConverter {
    static final int MAX = 100;
    static int top = -1;
    static char[] stack = new char[MAX];

    static boolean isFull() {
        return top == MAX - 1;
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static void push(char item) {
        if (isFull()) return;
        stack[++top] = item;
    }

    static char pop() {
        if (isEmpty()) return (char) Integer.MIN_VALUE;
        return stack[top--];
    }

    static char peek() {
        if (isEmpty()) return (char) Integer.MIN_VALUE;
        return stack[top];
    }

    static boolean isOperand(char ch) {
        return Character.isLetter(ch);
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    static String getPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        top = -1;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOperand(c)) {
                result.append(c);
            } else if (c == '(') {
                push(c);
            } else if (c == ')') {
                while (!isEmpty() && peek() != '(') {
                    result.append(pop());
                }
                if (!isEmpty() && peek() != '(') {
                    return "Invalid Expression";
                } else {
                    pop();
                }
            } else {
                while (!isEmpty() && precedence(c) <= precedence(peek())) {
                    result.append(pop());
                }
                push(c);
            }
        }
        while (!isEmpty()) {
            result.append(pop());
        }
        return result.toString();
    }

    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    static String swapBrackets(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') result.append(')');
            else if (c == ')') result.append('(');
            else result.append(c);
        }
        return result.toString();
    }

    static String infixToPrefix(String expression) {
        expression = reverse(expression);
        expression = swapBrackets(expression);
        String postfix = getPostfix(expression);
        return reverse(postfix);
    }

    public static void main(String[] args) {
        String expression = "((a/b)+c)-(d+(e*f))";
        System.out.println("The infix is: " + expression);
        String prefix = infixToPrefix(expression);
        System.out.println("The prefix is: " + prefix);
    }
}
