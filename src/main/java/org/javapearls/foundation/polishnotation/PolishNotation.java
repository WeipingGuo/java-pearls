package org.javapearls.foundation.polishnotation;

import java.util.Stack;

/**
 * polish notation: prefix notation,
 * it places operators to the left of their operands
 *
 * @author wguo
 *
 */
public class PolishNotation {

	private String notation;

	public PolishNotation(String s){
		if (s == null || s.length() < 3){
			throw new IllegalArgumentException("invalid polish notation: string is too short");
		}

		this.notation = s;
	}

	/**
	 * evaluate the polish notation and return the result
	 *
	 * @return
	 */
	public int evaluate(){
		char[] array = notation.toCharArray();
		return evaluate(array, 0, array.length - 1);
	}

	@SuppressWarnings("unused")
    private int evaluateUsingStack(){
		// back - to front, push element to stack. if it is operator, then pop two operands
		// apply the operation, push result back.
		Stack<Integer> stack = new Stack<Integer>();
		int i = notation.length() - 1;
		while (i >= 0){
			char c = notation.charAt(i);
			if (Operator.isOperator(c)){
				int a = stack.pop();
				int b = stack.pop();
				Operator o = Operator.getOperator(c);
				stack.push(o.apply(a, b));
			}else{
				stack.push(Integer.valueOf(Character.toString(c)));
			}
			i--;
		}

		return stack.pop();
	}

	/**
	 * Evaluate the notation for given char array, index: 'to' - 'from'
	 *
	 * start from the last, find the first operator, once found, do the
	 * operation and put the result back to array, and continue
	 *
	 * use 'space' to fill out empty
	 *
	 *
	 * @param array
	 * @param from
	 * @param to
	 * @return
	 */
	private int evaluate(char[] array, int from, int to){

		// get first operator, backward
		int j = to;
		char c = array[j];
		while (j >= from && !Operator.isOperator(c)){
			c = array[--j];
		}

		// get operands
		Operator op = Operator.getOperator(c);
		int opIndex = j;
		int a = Integer.valueOf(Character.toString(array[++j]));
		int b = Integer.valueOf(Character.toString(array[++j]));
		int result = op.apply(a, b);

		// most-left operator, done
		if (opIndex == 0){
			return result;
		}

		// push result back
		// BUG: lost result,change to String[]
		array[opIndex] = Integer.toString(result).charAt(0);

		//copy remaining over
		j++;
		while (j <= to){
			array[++opIndex]= array[j++];
		}

		return evaluate(array, from, opIndex);
	}

	public static int evaluate(String[] array, int from, int to){

		// get first operator, backward
		int j = to;
		String s = array[j];
		while (j >= from && !Operator.isOperator(s.charAt(0))){
			s = array[--j];
		}

		// get operands
		Operator op = Operator.getOperator(s.charAt(0));
		int opIndex = j;
		int a = Integer.valueOf(array[++j]);
		int b = Integer.valueOf(array[++j]);
		int result = op.apply(a, b);

		// most-left operator, done
		if (opIndex == 0){
			return result;
		}

		// push result back
		array[opIndex] = Integer.toString(result);

		//copy remaining over
		j++;
		while (j <= to){
			array[++opIndex]= array[j++];
		}

		return evaluate(array, from, opIndex);
	}

}
