package Model.Type;

public class BoolType implements Type{
    public BoolType(){}

    @Override
    public boolean equals(Object another){
        return another instanceof BoolType;
    }

    @Override
    public String toString(){
        return "bool";
    }

    @Override
    public Type deepCopy() {
        return new BoolType();
    }
}
