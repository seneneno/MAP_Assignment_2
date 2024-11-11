package Model.Expression;

import Utils.IDictionary;
import Model.Exceptions.MyException;
import Model.Value.Value;

public interface Exp {
    Value eval(IDictionary<String,Value> tbl) throws MyException;
    Exp deepCopy();
}
