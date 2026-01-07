package SkillBuilders;

public class Stack3Tester {
    public static void main(String[] args) {
        Stack3 s = new Stack3();

        s.push("A");
        s.push("B");
        s.push("C");

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
