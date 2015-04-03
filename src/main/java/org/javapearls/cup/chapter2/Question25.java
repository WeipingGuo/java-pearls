package org.javapearls.cup.chapter2;

import java.util.IdentityHashMap;
import java.util.Map;


/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 *
 * @author wguo
 *
 */
public class Question25 {

	/**
	 * Use a hashtable to track how many nodes pointing to the same node
	 *
	 * @param <K>
	 * @param header
	 * @return
	 */
	public static <K> SNode<K> loopStart(SNode<K> header){

		if (header == null){
			return null;
		}

		// use a IdentityHashMap to track Node
		Object dummy = new Object();
		Map<SNode<K>, Object> map  = new IdentityHashMap<SNode<K>, Object>();
		for (SNode<K> s = header; s != null; s = s.next){
			if (map.containsKey(s)){
				return s;
			}
			map.put(s, dummy);
		}

		return null;
	}

	/**
	 * keep two pointers: slow and faster
	 *
	 * @param <K>
	 * @param header
	 * @return
	 */
	public static <K> SNode<K> findBeginning(SNode<K> header){

		SNode<K> slow = header;
		SNode<K> faster = header;

		// faster runs twice as slow
		while(faster.next != null){
			slow = slow.next;
			faster = faster.next.next;
			if (slow == faster){
				break;
			}
		}

		// no loop if faster has no next element
		if (faster.next == null){
			return null;
		}

		// if slow starts from the header again
		// and faster move with the same pace as slow,
		// they will meet at the start of the loop
		slow = header;
		while (slow != faster){
			slow = slow.next;
			faster = faster.next;
		}
		return faster;
	}

	public static <E> boolean isCycle(SNode<E> header){
	    if (header == null) return true;

	    SNode<E> slow = header, faster = header;
	    while (faster.next != null && faster.next.next != null){
	        slow = slow.next;
	        faster = faster.next.next;
	        if (slow == faster){
	            return true;
	        }
	    }
	    return false;
	}



}
