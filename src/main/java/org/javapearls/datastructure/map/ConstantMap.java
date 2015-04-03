package org.javapearls.datastructure.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Create a data structure so that put, get, insert, delete, and random
 * all can be done in O(1)
 *
 * Array - store the actual data
 * HashMap - key: data, value: index in the array
 *
 * @author wguo
 *
 */
public class ConstantMap<E> {

	private final static int DEFAULT_CAPACITY = 16;
	private int capacity;
	private int size; 					// the number of elements
	private Object[] array;				// array to store the actual data
	private Map<E, Integer> indexMap;	// map data to index in the array

	public ConstantMap(){
		this(DEFAULT_CAPACITY);
	}

	public ConstantMap(int capacity){
		this.capacity = capacity;
		this.size = 0;
		array = new Object[capacity];
		indexMap = new HashMap<E, Integer>(capacity);
	}

	/**
	 * add an element to the map
	 *
	 * @param e
	 */
	public void add(E e){

		if (size == capacity){
			enlarge();
		}

		array[size] = e;		// add the element to the last of the array
		indexMap.put(e, size);	// remember the index
		size++;
	}

	/**
	 * get an element from the map
	 *
	 * @param e
	 * @return element if found; null otherwise
	 */
	@SuppressWarnings("unchecked")
	public E get(E e){
		Integer index = indexMap.get(e);
		return (index == null) ? null : (E)(array[index]);
	}

	/**
	 * delete an element from the map. nothing occurs if the element was not
	 * in the map
	 *
	 * @param e
	 */
	@SuppressWarnings("unchecked")
	public void delete(E e){

		Integer index = indexMap.get(e);
		if (index == null){	return; }

		// swap with the last element
		E last = (E)array[size-1];
		array[size-1] = null;
		array[index] = last;

		// remove it from the map
		indexMap.remove(e);
		indexMap.put(last, index);

		size--;
	}

	/**
	 * get a random element from the map
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E random(){
		int index =	(int)(Math.random() * size);
		return (E)array[index];
	}


	private void enlarge(){
		this.capacity = this.capacity >>> 1;
		array = Arrays.copyOf(array, this.capacity);
	}
}
