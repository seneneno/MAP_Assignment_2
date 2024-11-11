package Model.Stmt;

import Model.Exceptions.ExpressionVarException;
import Model.Exceptions.NotPrevDeclaredException;
import Model.Expression.Exp;
import Model.PrgState;
import Model.Type.Type;
import Utils.IDictionary;
import Utils.IExeStack;
import Model.Exceptions.MyException;
import Model.Value.Value;

public class AssignStmt implements IStmt {
    private String id;
    private Exp exp;
    public AssignStmt(String id, Exp exp){
        this.id=id;
        this.exp=exp;
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {
        IExeStack<IStmt> stk = state.getStk();
        IDictionary<String,Value> stbl = state.getSymTable();
        if(stbl.containsKey(id)){
            Type type = (stbl.lookUp(id)).getType();
            Value val = exp.eval(stbl);
            if((val.getType()).equals(type)){
                stbl.update(id,val);
            }
            else
                throw new ExpressionVarException();
        }
        else
            throw new NotPrevDeclaredException();
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new AssignStmt(this.id,this.exp.deepCopy());
    }

    @Override
    public String toString(){
        return this.id + "=" + this.exp.toString();
    }
}
