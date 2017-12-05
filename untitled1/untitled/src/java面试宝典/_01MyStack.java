package java面试宝典;

import java.util.Stack;

/**
 * Created by Administrator on 2016/10/27 0027.
 设计一个有getMin功能的栈
 */
public class _01MyStack {
 private Stack<Integer> stackData;
    private Stack<Integer>stackMin;
    public _01MyStack(){
        this.stackData=new Stack<Integer> ();
        this.stackMin=new Stack<Integer>();
    }
 public void push(int  newNum){
     if(this.stackMin.isEmpty()){
         this.stackMin.push(newNum);
     }else if(newNum<=this.getmin()){
       this.stackMin.push(newNum);
     }
     this.stackData.push(newNum);
 }
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("You stack is empty");
        }
        int value=this.stackData.pop();
        if(value==this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("You stack is empty");
        }
        return this.stackMin.peek();
    }

}
/*
方案二
 */
class Mystack2{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public Mystack2(){
        this.stackData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum<this.getmin()){
            this.stackMin.push(newNum);
        }else
        {
            int newMin=this.stackMin.peek();
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("You stack is empty");
        }
        this.stackMin.pop();
    return this.stackData.pop();
    }
    public int getmin(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("You stack is empty");
        }
        return this.stackMin.peek();
    }
}