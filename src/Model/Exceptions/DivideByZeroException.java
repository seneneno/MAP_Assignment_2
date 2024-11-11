package Model.Exceptions;

public class DivideByZeroException extends MyException{


    public DivideByZeroException() {
        super("Cannot divide by zero.");
    }
}
