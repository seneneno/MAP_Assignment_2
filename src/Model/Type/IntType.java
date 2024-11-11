package Model.Type;

public class IntType implements Type{
    public IntType(){

    }

    @Override
    public boolean equals(Object another){
        return another instanceof IntType;
    }
    @Override
    public String toString() { return "int";}

    @Override
    public Type deepCopy() {
        return new IntType();
    }
}
