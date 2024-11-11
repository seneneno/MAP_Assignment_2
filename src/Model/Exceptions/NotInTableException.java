package Model.Exceptions;

public class NotInTableException extends MyException{
    public NotInTableException(String id) {
        super(id + "not in symbol table.");
    }
}
