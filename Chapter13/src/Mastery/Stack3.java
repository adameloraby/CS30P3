package SkillBuilders;

import java.util.ArrayList;

public class Stack3 {
    private ArrayList<Object> stack;

    public Stack3() {
        stack = new ArrayList<>();
    }

    public void push(Object item) {
        stack.add(item);
    }

    public Object pop() {
        if (stack.isEmpty()) return null;
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

