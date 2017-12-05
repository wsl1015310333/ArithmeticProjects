package java面试宝典;

import java.util.Stack;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class _02MyStack {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;
    public _02MyStack(){
        stackPush=new Stack<Integer>();
        stackPop=new Stack<Integer>();
    }
    public void add (int pushInt){
        stackPush.push(pushInt);
    }
    public int poll(){
        if(stackPop.empty()&&stackPush.empty()){
            throw  new RuntimeException("Queue is Empty!");
        }else if(!stackPush.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    public int peek(){
        if(stackPop.empty()&&stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.empty()){
            while(!stackPush.empty())
            stackPop.push(stackPush.pop());
        }
        return stackPop.peek();
    }
}
