package markov.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTable<Element extends Hashable> implements Table<Element>{

    private final Set<Element> set = new HashSet<>();

    @Override
    public Element contains(Element theElement) {
        if(set.contains(theElement)) return theElement;
        else return null;
    }

    @Override
    public Element insert(Element theElement) {
        Element el = (Element) theElement.copyMe();
        set.add(el);
        return theElement;
    }

    @Override
    public Iterator<Element> iterator() {
        return set.iterator();
    }
}
