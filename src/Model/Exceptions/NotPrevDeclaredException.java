package Model.Exceptions;

public class NotPrevDeclaredException extends MyException{
    public NotPrevDeclaredException() {
        super("Variable was not previously declared.");
    }
}
