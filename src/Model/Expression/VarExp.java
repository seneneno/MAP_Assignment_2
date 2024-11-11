package Model.Expression;

import Model.Exceptions.NotPrevDeclaredException;
import Utils.IDictionary;
import Model.Exceptions.MyException;
import Model.Value.Value;

public class VarExp implements Exp{
    private String id;

    public VarExp(String id){
        this.id=id;
    }

    @Override
    public Value eval(IDictionary<String, Value> tbl) throws MyException {


        if(tbl.containsKey(id))
            return tbl.lookUp(id);
        else
            throw new NotPrevDeclaredException();
    }

    @Override
    public Exp deepCopy() {
        return new VarExp(this.id);
    }
    @Override
    public String toString(){
        return id;
    }
}
