package Model.Value;

import Model.Type.BoolType;
import Model.Type.Type;

public class BoolValue implements Value{
    private boolean value;

    public BoolValue(boolean value){
        this.value=value;
    }


    public boolean getValue(){
        return value;
    }

    @Override
    public Type getType() {
        return new BoolType();
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
    @Override
    public Value deepCopy() {
        return new BoolValue(value);
    }
}
