package Model.Exceptions;

public class StackEmptyException extends MyException {
    public StackEmptyException() {
        super("Stack is empty.");
    }
}
