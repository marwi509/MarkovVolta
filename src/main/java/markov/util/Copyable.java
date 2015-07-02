package markov.util;

public interface Copyable<T extends Copyable<T>> {
	T copyMe();
}
