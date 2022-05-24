import java.util.Stack;

/**
 * @author Pzr
 * @create 2022/5/20 - 21:05
 */
class MinStack { Stack<Integer> stack1 = new Stack(); Stack<Integer> stack2 = new Stack(); /** initialize your data structure here. */ public MinStack() { }public void push(int x) { stack1.push(x); if(stack2.isEmpty()){ stack2.push(x); }else{
    if(x<=stack2.peek()){ stack2.push(x); } } }public void pop() { if(stack2.peek()==stack1.peek()){ stack2.pop(); stack1.pop(); }else{stack1.pop(); } }public int top() { return stack1.peek(); }public int min() { return stack2.peek(); } }