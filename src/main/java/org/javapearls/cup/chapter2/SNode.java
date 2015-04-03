package org.javapearls.cup.chapter2;


/**
 * A single linked node
 *
 * @param <K> the key type
 */
public class SNode<K> {

	/** The element. */
	public K element;

	/** The next. */
	public SNode<K> next;

	/**
	 * Instantiates a new s node.
	 *
	 * @param e the data
	 * @param n the next node
	 */
	public SNode(K e, SNode<K> n){
		this.element = e;
		this.next = n;
	}

	public SNode(K e){
		this.next = null;
		this.element = e;
	}


	public void print(){
		for(SNode<K> s = this; s != null; s = s.next){
			System.out.print(s.element);
			if (s.next != null){
				System.out.print("-->");
			}
			else{
				System.out.print("\n");
			}
		}
	}

}
