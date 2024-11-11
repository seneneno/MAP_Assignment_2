package Model.Stmt;

import Model.PrgState;
import Utils.IExeStack;
import Model.Exceptions.MyException;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt second;

    public CompStmt(IStmt first, IStmt second){
        this.first=first;
        this.second=second;
    }

    @Override
    public String toString(){
        return "(" + this.first + ";" +this.second + ")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IExeStack<IStmt> stk = state.getStk();
        stk.push(this.second);
        stk.push(this.first);
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new CompStmt(this.first.deepCopy(),this.second.deepCopy());
    }
}
