package Model.Stmt;

import Model.PrgState;
import Model.Exceptions.MyException;

public interface IStmt {
    PrgState execute(PrgState state) throws MyException;

    IStmt deepCopy();
}
