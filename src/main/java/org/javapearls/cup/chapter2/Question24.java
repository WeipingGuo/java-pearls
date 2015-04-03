package org.javapearls.cup.chapter2;

/**
 *
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 *
 * @author wguo
 *
 */
public class Question24 {

	public static SNode<Integer> sum(SNode<Integer> a, SNode<Integer> b, int carry){

		// after all the elements are added, we still could have
		// a carryover. need create a new node for it.
	    if (a == null && b == null){
	    	if (carry == 1){
	    		return new SNode<Integer>(1);
	    	}
	    	else{
	    		return null;
	    	}
	    }

	    int sum = carry;
	    if (a != null){
	        sum += a.element;
	        a = a.next;
	    }
	    if (b != null){
	        sum += b.element;
	        b = b.next;
	    }

	    if (sum >= 10){
	        sum -= 10;
	        carry = 1;
	    }
	    else{
	        carry = 0;
	    }

	    SNode<Integer> header = new SNode<Integer>(sum);
	    header.next = sum(a, b, carry);

	    return header;
	}

	public static SNode<Integer> sum(SNode<Integer> s1, SNode<Integer> s2){

		if (s1 == null){
			return s2;
		}
		if (s2 == null){
			return s1;
		}

		int sum = s1.element + s2.element;
		int carry = 0;
		if (sum >= 10){
			carry = 1;
			sum -= 10;
		}

		SNode<Integer> header = new SNode<Integer>(sum, null);
		SNode<Integer> p1 = s1.next;
		SNode<Integer> p2 = s2.next;
		SNode<Integer> s = header;
		while (p1 != null && p2 != null){
			sum = p1.element + p2.element + carry;

			if (sum >= 10){
				carry = 1;
				sum -= 10;
			}
			else{
				carry = 0;
			}

			SNode<Integer> t = new SNode<Integer>(sum, null);
			s.next = t;
			s = t;

			p1 = p1.next;
			p2 = p2.next;
		}

		// if one list is longer than other
		SNode<Integer> p = (p1 != null) ? p1 : p2;
		while (p != null){
			sum = p.element + carry;
			if (sum >= 10){
				carry = 1;
				sum -= 10;
			}
			else{
				carry = 0;
			}

			SNode<Integer> t = new SNode<Integer>(sum, null);
			s.next = t;
			s = t;
			p = p.next;
		}

		// if still have a carryover
		if (carry > 0){
			s.next = new SNode<Integer>(carry, null);
		}

		return header;
	}

	/**
	 * add two linked list
	 * @param a
	 * @param b
	 * @return
	 */
	public static SNode<Integer> add(SNode<Integer> a, SNode<Integer> b){

		if (a == null) return b;
	    if (b == null) return a;

	    // create a dummy node
	    SNode<Integer> header = new SNode<Integer>(null);
	    SNode<Integer> current = header;

	    int carry = 0;
	    while (a != null || b != null){

	        int sum = carry;
	        if (a != null){
	            sum += a.element;
	            a = a.next;
	        }
	        if (b != null){
	            sum += b.element;
	            b = b.next;
	        }

	        if (sum >= 10){
	            carry = 1;
	            sum -= 10;
	        }else{
	        	carry = 0;
	        }
	        current.next = new SNode<Integer>(sum);
	        current = current.next;
	    }

	    // add one more node
	    if (carry == 1){
	        current.next = new SNode<Integer>(carry);
	    }
	    return header.next;
	}


}
