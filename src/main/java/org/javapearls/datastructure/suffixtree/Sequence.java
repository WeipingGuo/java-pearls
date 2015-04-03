package org.javapearls.datastructure.suffixtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sequence<I, S extends Iterable<I>> implements Iterable<Object> {

	private List<Object> masterSeq = new ArrayList<Object>();


	/**
	 * constructor
	 *
	 * @param seq
	 */
	public Sequence(S seq){
		for (Object o : seq){
			masterSeq.add(o);
		}

		SequenceTerminal<S> terminal = new SequenceTerminal<S>(seq);
		masterSeq.add(terminal);
	}

	/**
	 * get item
	 *
	 * @param index
	 * @return
	 */
	public Object getItem(int index){
		return masterSeq.get(index);
	}

	/**
	 * add to the suffix tree
	 *
	 * @param seq
	 */
	public void add(S seq){
		for (I item : seq){
			masterSeq.add(item);
		}

		SequenceTerminal<S> terminal = new SequenceTerminal<S>(seq);
		masterSeq.add(terminal);
	}

	/**
	 * the size of the tree
	 *
	 * @return
	 */
	public int size(){
		return masterSeq.size();
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("Sequence = [");
		for(Object i : masterSeq){
			sb.append(i).append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>(){

			int currentPos = 0;

			@Override
			public boolean hasNext() {
				return currentPos < masterSeq.size();
			}

			@Override
			public Object next() {
				if (currentPos < masterSeq.size()){
					return masterSeq.get(currentPos++);
				}else{
					return null;
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove element operation is not supported");
			}

		};
	}



}
