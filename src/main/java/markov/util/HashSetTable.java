package markov.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashSetTable<Element extends Hashable> implements Table<Element>{

    private final Map<Element, Element> map;

    public HashSetTable() {
        map = new HashMap<>();
    }

    @Override
    public Element contains(Element theElement) {
        return map.get(theElement);
    }

    @Override
    public Element insert(Element theElement) {
        if(!map.containsKey(theElement))
            map.put(theElement, theElement);
        return map.get(theElement);
    }

    @Override
    public Iterator<Element> iterator() {
        return map.values().iterator();
    }
}

