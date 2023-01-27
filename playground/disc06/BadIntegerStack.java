package disc06;

public class BadIntegerStack {
    public class Node {
        public Integer value;
        public Node prev;

        public Node(Integer v, Node p) {
            value = v;
            prev = p;
        }
    }
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Integer num) {
        top = new Node(num, top);
    }

    public Integer pop() {
        Integer ans = top.value;
        top = top.prev;
        return ans;
    }
    public Integer peek() {
        return top.value;
    }

/**
 * Question (a): done!
 * */
/*    public static void main(String[] args) {
        BadIntegerStack bis = new BadIntegerStack();
        try {
            bis.pop();
        } catch (Exception NullPointerException) {
            System.out.println("Success!");
        }
    }*/

/**
 * Question (b):参考的答案，因为连题目都没懂是要干啥。
 * 其实就是to solve the NullPointerException error when calling pop() method.
 * The solution is: stack.top.prev = stack.top
 * If you set top.prev to itself, then every time you pop you will
 * set top back to itself! This means you can keep popping
 * but top will remain in the list.
 * */
    public static void main(String[] args) {
        BadIntegerStack bis = new BadIntegerStack();
        bis.push(1);
        bis.top.prev = bis.top;     //key point!!!
        while (!bis.isEmpty()) {
            bis.pop();
        }
        System.out.println("This print statement is unreachable!");
    }
}
