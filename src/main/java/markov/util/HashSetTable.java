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
    public Element get(Element theElement) {
        Element element = map.get(theElement);
        if(element != null) return element;
        else throw new IllegalStateException(theElement + " did not exist in the table");
    }

    @Override
    public Element insert(Element theElement) {
        map.put(theElement, theElement);
        return theElement;
    }

    @Override
    public Iterator<Element> iterator() {
        return map.values().iterator();
    }

    @Override
    public boolean contains(Element element) {
        return map.containsKey(element);
    }
}

