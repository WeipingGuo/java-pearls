package org.javapearls.datastructure.linkedlist;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache<K, V> {

	private final int capacity;
	private Map<K, V> cacheMap;

	private final ReadWriteLock wrLock = new ReentrantReadWriteLock();
	@SuppressWarnings("unused")
	private final Lock readLock = wrLock.readLock();
	@SuppressWarnings("unused")
	private final Lock writeLock = wrLock.writeLock();

	public LRUCache(int capacity){
		this.capacity = capacity;
		cacheMap = 	new ConcurrentHashMap<K, V>(new CacheMap<K,V>(capacity));
	}

	/**
	 * get a cached element
	 * @param key
	 * @return
	 */
	public V get(K key){
		return cacheMap.get(key);
	}

	/**
	 * same as put
	 *
	 * @param key
	 * @param value
	 */
	public void add(K key, V value){
		cacheMap.put(key, value);
	}

	/**
	 * add an entry to the cache
	 * @param key
	 * @param value
	 */
	public void put(K key, V value){
		cacheMap.put(key, value);
	}

	/**
	 * remove an entry from the cache
	 * @param key
	 */
	public void remove(K key){
		cacheMap.remove(key);
	}

	public boolean containsKey(K key){
		return cacheMap.containsKey(key);
	}

	/**
	 * the current cache size
	 *
	 * @return
	 */
	public int size(){
		return cacheMap.size();
	}

	/**
	 * the capacity of the cache
	 *
	 * @return
	 */
	public int capacity(){
		return this.capacity;
	}

	/**
	 * clear up all the cached entries
	 */
	public void clear(){
		cacheMap.clear();
	}

}
