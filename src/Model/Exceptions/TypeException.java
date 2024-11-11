package Model.Exceptions;

public class TypeException extends MyException {
    public TypeException(String str) {
        super("Expression must be "+str +".");
    }
}
