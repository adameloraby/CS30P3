package Mastery;

public class Queue2 {
    private Object[] queue;
    private int front, rear, size;

    public Queue2(int capacity) {
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enqueue(Object item) {
        if (size == queue.length) return false;
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
        return true;
    }

    public Object dequeue() {
        if (size == 0) return null;
        Object item = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

