package Model.Stmt;

import Model.PrgState;
import Model.Type.BoolType;
import Model.Type.Type;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Exceptions.MyException;

public class VarDeclStmt implements IStmt {
    private String id;
    private Type type;

    public VarDeclStmt(String id, Type t){
        this.id=id;
        this.type=t;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        if(this.type.equals(new BoolType()))
            state.getSymTable().put(id ,new BoolValue(true));
        else
            state.getSymTable().put(id,new IntValue(0));
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new VarDeclStmt(this.id, this.type.deepCopy());
    }

    @Override
    public String toString(){
        return type.toString() +" "+ id;
    }
}
