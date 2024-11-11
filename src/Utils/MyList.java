package Utils;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements IList<T> {
    private List<T> list;

    public MyList(){
        list=new ArrayList<>();
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
