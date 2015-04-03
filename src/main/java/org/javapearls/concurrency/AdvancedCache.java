package org.javapearls.concurrency;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * FutureTask represents a computational process that may or may not
 * already have completed. FutureTask.get() returns the result of
 * the computation immediately if it is available; otherwise it blocks
 * until the result has been computed and then returns it.
 *
 * Issue: still small window that two threads compute the same value
 *
 * FROM BOOK 'Java Concurrency in Practice'
 *
 * @author wguo
 *
 * @param <A>
 * @param <V>
 */
public class AdvancedCache<A, V> implements Computable<A, V> {

	private final Map<A, Future<V>> cache =
		new ConcurrentHashMap<A, Future<V>>();

	private final Computable<A, V> c;

	public AdvancedCache(Computable<A, V> c){
		this.c = c;
	}

	@Override
	public V compute(final A arg) throws InterruptedException {

		Future<V> f = cache.get(arg);
		if (f == null){
			Callable<V> eval = new Callable<V>(){
				@Override
				public V call() throws Exception {
					return c.compute(arg);
				}
			};

			FutureTask<V> ft = new FutureTask<V>(eval);
			f = ft;
			cache.put(arg, ft);
			ft.run();
		}

		try{
			return f.get();
		} catch (ExecutionException e) {
			throw new InterruptedException(e.getMessage());
		}

	}

}
