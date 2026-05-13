class MinStack {
    /*
     * so we need o(1) for each func right push/pop/top is easy but getmin is hard
     * cause
     * traversal, I keep track of current min in a var but if i pop current min var
     * becomes invalid and to find new min i need to traverse which is more than
     * o(1) so
     * i need to keep track of min at each stage so kind of arr like a 2nd stack
     */
    private ArrayDeque<Integer> mainStack;
    private ArrayDeque<Integer> currMin;

    public MinStack() {
        mainStack = new ArrayDeque<>();
        currMin = new ArrayDeque<>();
    }

    public void push(int val) {
        // add to stack
        mainStack.push(val);

        /*
         * if val is smaller than our current min we add it, if not then we need to push
         * the current top min value again so that both mainStack and currMin stack have
         * same length and currMin doesnt become null eg. if we push 1,2,3 in mainStack
         * and for each case 1 is the min element so currMin should have 1,1,1
         */
        if (currMin.isEmpty() == false) {
            if (currMin.peek() >= val)
                currMin.push(val);
            else {
                int temp = currMin.peek();
                currMin.push(temp);
            }
        } else
            currMin.push(val);
    }

    public void pop() {
        // remove the top element
        int popped = mainStack.pop();

        // since we are pushing everytime we need to pop everytime to maintain same size
        currMin.pop();
    }

    public int top() {
        // return top element
        int top = mainStack.peek();

        // no need to uodate current min cause this operation didnt change mainStack
        return top;
    }

    public int getMin() {
        // here we are not changeing mainStack or currMin stack just doing peek
        int top = currMin.peek();
        return top;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
