package Model.Exceptions;

public class ExpressionVarException extends MyException{
    public ExpressionVarException() {
        super("Expression type does not match variable type");
    }
}
