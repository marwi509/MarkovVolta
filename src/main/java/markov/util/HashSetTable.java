package markov.util;

import markov.util.Hashable;
import markov.util.Table;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTable implements Table<Hashable>{

    private final Set set = new HashSet<Hashable>();

    @Override
    public Hashable contains(Hashable theElement) {
        if(set.contains(theElement)) return theElement;
    }

    @Override
    public Hashable insert(Hashable theElement) {
        set.add(theElement);
        return theElement;
    }

    @Override
    public Iterator<Hashable> iterator() {
        return set.iterator();
    }
}
