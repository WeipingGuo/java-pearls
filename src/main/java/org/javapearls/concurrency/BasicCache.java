package org.javapearls.concurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * low concurrency: only one thread at a time can execute compute
 * thread could be blocked for a long time
 *
 * @author wguo
 *
 * @param <A>
 * @param <V>
 */
public class BasicCache<A, V> implements Computable<A, V> {

	private final Map<A, V> cache = new HashMap<A, V>();
	private final Computable<A, V> c;

	public BasicCache(Computable<A, V> c){
		this.c = c;
	}

	@Override
	public synchronized V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if (result == null){
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}

}
