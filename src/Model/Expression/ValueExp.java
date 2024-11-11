package Model.Expression;

import Utils.IDictionary;
import Model.Exceptions.MyException;
import Model.Value.Value;

public class ValueExp implements Exp{
    private Value e;

    public ValueExp(Value e){
        this.e=e;
    }

    @Override
    public Value eval(IDictionary<String, Value> tbl) throws MyException {
        return e;
    }

    @Override
    public Exp deepCopy() {
        return new ValueExp(e.deepCopy());
    }

    @Override
    public String toString(){
        return e.toString();
    }
}
