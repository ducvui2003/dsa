package leet_code._155;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        this.st = new Stack();
        this.minSt = new Stack();
    }

    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty())
            minSt.push(val);
        else
            minSt.push(Math.min(val, minSt.peek()));
    }

    public void pop() {
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
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