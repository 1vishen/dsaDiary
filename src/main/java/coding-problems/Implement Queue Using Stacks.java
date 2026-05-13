class MyQueue {

    // declaring 2 stacks
    ArrayDeque<Integer> s1;
    ArrayDeque<Integer> s2;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        // push in s1
        s1.push(x);
    }

    public int pop() {
        // pop from s1 and keep till only 1 element remains
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        int popped = s1.pop();
        // need this cause transfering from 1 stack to another reverses the order
        while (s2.size() > 0) {
            s1.push(s2.pop());
        }
        s2 = new ArrayDeque<>();
        return popped;
    }

    public int peek() {
        // same as pop
        // pop from s1 and keep till only 1 element remains
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        int popped = s1.pop();
        // push last element to s2 as well
        s2.push(popped);
        // need this cause transfering from 1 stack to another reverses the order
        while (s2.size() > 0) {
            s1.push(s2.pop());
        }
        s2 = new ArrayDeque<>();
        return popped;
    }

    public boolean empty() {
        if (s1.isEmpty() == true)
            return true;
        else
            return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
