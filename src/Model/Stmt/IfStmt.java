package Model.Stmt;

import Model.Exceptions.TypeException;
import Model.Expression.Exp;
import Model.PrgState;
import Model.Type.BoolType;
import Model.Value.BoolValue;
import Utils.IDictionary;
import Utils.IExeStack;
import Model.Exceptions.MyException;
import Model.Value.Value;

public class IfStmt implements IStmt {
    private Exp ifExp;
    private IStmt thenStmt ;
    private IStmt elseStmt;

    public IfStmt(Exp ifExp,IStmt thenStmt, IStmt elseStmt){
        this.ifExp=ifExp;
        this.thenStmt = thenStmt;
        this.elseStmt=elseStmt;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IExeStack<IStmt> stk= state.getStk();
        IDictionary<String,Value> stbl= state.getSymTable();
        Value cond = ifExp.eval(stbl);
        if(!cond.getType().equals(new BoolType())){
            throw new TypeException("bool");
        }
        else{
            BoolValue cd = (BoolValue)cond;
            if (cd.getValue()) {
                stk.push(thenStmt);
            } else {
                stk.push(elseStmt);
            }
        }
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new IfStmt(this.ifExp.deepCopy(),this.thenStmt , this.elseStmt.deepCopy());
    }

    @Override
    public String toString(){
        return "(if("+ ifExp.toString()+") then(" +thenStmt.toString()
                +")else("+elseStmt.toString()+"))";
    }

}
