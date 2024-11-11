package Model.Stmt;

import Model.Expression.Exp;
import Model.PrgState;
import Utils.IDictionary;
import Utils.IList;
import Model.Exceptions.MyException;
import Model.Value.Value;

public class PrintStmt implements IStmt {
    private Exp exp;

    public PrintStmt(Exp e){
        this.exp=e;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IList<Value> out= state.getOut();
        IDictionary<String,Value> stbl=state.getSymTable();
        out.add(exp.eval(stbl));
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new PrintStmt(this.exp.deepCopy());
    }

    @Override
    public String toString(){
        return "print("+exp.toString()+ ")";
    }
}
