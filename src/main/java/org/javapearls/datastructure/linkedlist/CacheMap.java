package org.javapearls.datastructure.linkedlist;

import java.util.LinkedHashMap;

public class CacheMap<K, V> extends LinkedHashMap<K, V> {


	/**
	 *
	 */
	private static final long serialVersionUID = -1274799162028799173L;

	/** The max number of caches it holds. */
	private final int maxEntries;

	/**
	 * Instantiates a new lRU cache.
	 *
	 * @param capacity	the capacity of the cache
	 */
	public CacheMap(final int capacity){
		super(capacity, 1.0f, true);
		this.maxEntries = capacity;
	}

	/* (non-Javadoc)
	 * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
	 */
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > maxEntries;
	}

}
