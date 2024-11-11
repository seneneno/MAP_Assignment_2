package Model;

import Model.Stmt.IStmt;
import Utils.IExeStack;
import Utils.IList;
import Utils.IDictionary;
import Model.Value.Value;

public class PrgState {
    private IStmt original_program;
    private IExeStack<IStmt> exeStack;
    private IDictionary<String, Value> symTable;
    private IList<Value> out;

    public IStmt getOriginal_program() {
        return original_program;
    }
    public IExeStack<IStmt> getStk(){
        return exeStack;
    }
    public IDictionary<String,Value> getSymTable(){
        return symTable;
    }
    public IList<Value> getOut(){
        return out;
    }

    public PrgState(IExeStack<IStmt> stk, IDictionary<String,Value> symtbl, IList<Value> ot, IStmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        original_program=prg.deepCopy();
        //original_program=prg;
        stk.push(prg);
    }

    @Override
    public String toString() {
        return "Execution stack: "+exeStack.getReverse() + " \n Symbol table: "+symTable.toString()+" \n Out: "+out.toString() + "\n";
    }

}
