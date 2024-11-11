package Model.Stmt;

import Model.PrgState;
import Model.Exceptions.MyException;

public class NopStmt implements IStmt {

    @Override
    public PrgState execute(PrgState state) throws MyException {
        return null;
    }

    @Override
    public IStmt deepCopy() {
        return null;
    }

    @Override
    public String toString(){
        return "No operation.";
    }
}
