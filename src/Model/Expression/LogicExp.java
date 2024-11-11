package Model.Expression;

import Model.Exceptions.TypeException;
import Model.Type.BoolType;
import Model.Type.Type;
import Model.Value.BoolValue;
import Utils.IDictionary;
import Model.Exceptions.MyException;
import Model.Value.Value;

public class LogicExp implements Exp{
    private Exp e1;
    private Exp e2;
    private String op;//1-and,2-or
    private static Type t=new BoolType();
    public LogicExp(Exp e1, Exp e2, String op){
        this.e1=e1;
        this.e2=e2;
        this.op=op;
    }

    @Override
    public Value eval(IDictionary<String, Value> tbl) throws MyException {
        Value v1,v2;
        v1= e1.eval(tbl);
        if (v1.getType().equals(t)) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(t)) {
                BoolValue i1 = (BoolValue)v1;
                BoolValue i2 = (BoolValue)v2;
                boolean n1,n2;
                n1=i1.getValue();
                n2=i2.getValue();
                switch(op){
                    case "&&":
                        return new BoolValue(n1 && n2);
                    case "||":
                        return new BoolValue(n1 || n2);
                }
            }
            else
                throw new TypeException("boolean");
        }
        else throw new TypeException("boolean");
        return v1;
    }

    @Override
    public Exp deepCopy() {
        return new LogicExp(e1.deepCopy(),e2.deepCopy(),op);
    }

    @Override
    public String toString(){
        return switch (op) {
            case "&&" -> e1.toString() + "&&" + e2.toString();
            case "||" -> e1.toString() + "||" + e2.toString();
            default -> "";
        };
    }
}
