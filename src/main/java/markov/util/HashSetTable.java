package markov.util;

import java.util.*;

public class HashSetTable<Element extends Hashable> implements Table<Element>{

    private final Map<Integer, Element> map = new HashMap<>();

    @Override
    public Element contains(Element theElement) {
        return map.get(theElement.hashCode());
    }

    @Override
    public Element insert(Element theElement) {
        Element el = (Element) theElement.copyMe();
        if(!map.containsKey(el.hashCode()))
            map.put(el.hashCode(), el);
        return map.get(el.hashCode());
    }

    @Override
    public Iterator<Element> iterator() {
        return map.values().iterator();
    }
}

