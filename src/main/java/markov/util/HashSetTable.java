package markov.util;

import java.util.*;

public class HashSetTable<Element extends Hashable> implements Table<Element>{

    private final Map<Integer, Element> set = new HashMap<>();

    @Override
    public Element contains(Element theElement) {
        return set.get(theElement.hashCode());
    }

    @Override
    public Element insert(Element theElement) {
        Element el = (Element) theElement.copyMe();
        set.put(el.hashCode(), el);
        return set.get(el.hashCode());
    }

    @Override
    public Iterator<Element> iterator() {
        return set.values().iterator();
    }
}

