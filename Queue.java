//Array implementation of Queue.
 
 public class Queue {
    int front, rear, size;
    int capacity;
    int[] array;
    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        this.array = new int[this.capacity];
    }
    boolean isFull() {
        return (this.size == this.capacity);
    }
    boolean isEmpty() {
        return (this.size == 0);
    }
    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }
    int front() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }
    int rear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }
    public static void main(String[] args) {
        Queue queue = new Queue(1000);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue.dequeue() + " dequeued from queue");
        System.out.println("Front item is " + queue.front());
        System.out.println("Rear item is " + queue.rear());
    }
}
