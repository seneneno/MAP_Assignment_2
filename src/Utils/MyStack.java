package Utils;

import Model.Exceptions.MyException;
import Model.Exceptions.StackEmptyException;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MyStack<T> implements IExeStack<T>{
    private Stack<T>stack;

    public MyStack() {
        stack = new Stack<>();
    }

    @Override
    public void push(T t) {
        stack.push(t);
    }


    @Override
    public T pop() throws MyException {
        if(stack.isEmpty()){
            throw new StackEmptyException();
        }
        else
           return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public List<T> getReverse() {
        return (List<T>) Arrays.asList(stack.reversed());
    }

    @Override
    public String toString(){
        return stack.toString();
    }
}
