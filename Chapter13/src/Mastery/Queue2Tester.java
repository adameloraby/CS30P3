package SkillBuilders;

public class Queue2Tester {
    public static void main(String[] args) {
        Queue2 q = new Queue2(3);

        q.enqueue("First");
        q.enqueue(2);
        q.enqueue(3.5);
        
        q.dequeue();
        
        q.enqueue(4);
        
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}

