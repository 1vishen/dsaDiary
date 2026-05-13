class MyStack {

    // declaring 2 queues
    ArrayDeque<Integer> q1;
    ArrayDeque<Integer> q2;

    public MyStack() {
        // initialization of 2 queues
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        // push in q1 only
        q1.offer(x);
    }

    public int pop() {
        // keep popping from q1 till only 1 element remains
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int popped = q1.poll();
        q1 = q2;
        q2 = new ArrayDeque<>();

        return popped;
    }

    public int top() {
        // keep popping from q1 till only 1 element remains
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int popped = q1.poll();
        // but add popped one as wekk since top is just peeking
        q2.offer(popped);
        q1 = q2;
        q2 = new ArrayDeque<>();

        return popped;
    }

    public boolean empty() {
        if (q1.isEmpty() == true)
            return true;
        else
            return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
