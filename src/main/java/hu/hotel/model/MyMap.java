package hu.hotel.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Peter_Fazekas on 2017.02.25..
 */
public class MyMap<K, V> extends TreeMap<K, V> {

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> actual : map.entrySet()) {
            K key = actual.getKey();
            Integer value = (Integer) actual.getValue();
            if(this.containsKey(actual.getKey())){
                value += (Integer) this.get(key);
            }
            this.put(key, (V)value);
        }
    }
}
