package Utils;

import Model.Exceptions.MyException;

import java.util.List;

public interface IExeStack<T> {
    void push(T t);
    T pop() throws MyException;
    boolean isEmpty();
    public List<T> getReverse();
}
