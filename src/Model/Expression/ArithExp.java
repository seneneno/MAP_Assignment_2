package Model.Expression;

import Model.Exceptions.DivideByZeroException;
import Model.Exceptions.TypeException;
import Model.Type.IntType;
import Model.Type.Type;
import Model.Value.IntValue;
import Utils.IDictionary;
import Model.Exceptions.MyException;
import Model.Value.Value;


public class ArithExp implements Exp{
    private Exp e1;
    private Exp e2;
    private char op;
    private static Type t=new IntType();

    public ArithExp(Exp e1,Exp e2, char op){
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
                IntValue i1 = (IntValue)v1;
                IntValue i2 = (IntValue)v2;
                int n1,n2;
                n1=i1.getValue();
                n2=i2.getValue();
                switch(op){
                    case '+':
                        return new IntValue(n1+n2);
                    case '-':
                        return new IntValue(n1-n2);
                    case '*':
                        return new IntValue(n1*n2);
                    case '\\':
                        if(n2==0)
                            throw new DivideByZeroException();
                        else
                            return new IntValue(n1/n2);
                }
            }
            else
                throw new TypeException("int");
        }
        else throw new TypeException("int");
        return v1;
    }

    @Override
    public Exp deepCopy() {
        return new ArithExp(e1.deepCopy(),e2.deepCopy(),op);
    }

    @Override
    public String toString(){
        return switch (op) {
            case '+' -> e1.toString() + "+" + e2.toString();
            case '-' -> e1.toString() + "-" + e2.toString();
            case '*' -> e1.toString() + "*" + e2.toString();
            case '\\' -> e1.toString() + "\\" + e2.toString();
            default -> "";
        };
    }
}
