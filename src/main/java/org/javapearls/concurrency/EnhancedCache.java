package org.javapearls.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Better concurrency: multiple threads can use it
 * issue: two threads calling 'compute' at the same could end up computing
 * 		the same value
 *
 * @author wguo
 *
 * @param <A>
 * @param <V>
 */
public class EnhancedCache<A, V> implements Computable<A, V> {

	private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
	private final Computable<A, V> c;

	public EnhancedCache(Computable<A, V> c){
		this.c = c;
	}

	@Override
	public V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if (result == null){
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}

}
