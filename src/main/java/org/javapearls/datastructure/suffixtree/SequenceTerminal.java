package org.javapearls.datastructure.suffixtree;

public class SequenceTerminal<S> {

	private S sequence;

	public SequenceTerminal(S seq){
		this.sequence = seq;
	}

	public S getSequence(){
		return this.sequence;
	}

	@Override
	public int hashCode() {
		return this.sequence.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		SequenceTerminal<S> other = (SequenceTerminal<S>) obj;
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "$"+sequence.toString()+"$";
	}
}
