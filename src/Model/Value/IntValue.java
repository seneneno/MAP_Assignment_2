package Model.Value;

import Model.Type.IntType;
import Model.Type.Type;

public class IntValue implements Value{
    private int value;

    public IntValue(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public Value deepCopy() {
        return new IntValue(value);
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
