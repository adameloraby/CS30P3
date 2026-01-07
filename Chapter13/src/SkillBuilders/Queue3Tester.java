package SkillBuilders;

public class Queue3Tester {
    public static void main(String[] args) {
        Queue3 q = new Queue3();

        q.enqueue("X");
        q.enqueue("Y");
        q.enqueue("Z");
        
        q.dequeue();

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}