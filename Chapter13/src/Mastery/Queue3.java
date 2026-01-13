package SkillBuilders;

import java.util.ArrayList;

public class Queue3 {
    private ArrayList<Object> queue;

    public Queue3() {
        queue = new ArrayList<>();
    }

    public void enqueue(Object item) {
        queue.add(item);
    }

    public Object dequeue() {
        if (queue.isEmpty()) return null;
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
