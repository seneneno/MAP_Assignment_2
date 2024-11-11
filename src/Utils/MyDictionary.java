package Utils;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class MyDictionary<K,V> implements IDictionary<K,V>{
    private Map<K,V> dict;

    public MyDictionary(){
        dict = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        dict.put(key,value);
    }

    @Override
    public V lookUp(K key) {
        if(!containsKey(key)){
            return null;
        }
        else
            return dict.get(key);
    }

    @Override
    public boolean containsKey(K key) {
        return dict.containsKey(key);
    }
    @Override
    public String toString(){
        return dict.toString();
    }

    @Override
    public void update(K key, V value) {
        dict.put(key, value);
    }
}
