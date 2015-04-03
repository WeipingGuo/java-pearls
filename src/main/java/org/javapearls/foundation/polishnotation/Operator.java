package org.javapearls.foundation.polishnotation;

public enum Operator {
	Add('+'),
	Sub('-'),
	Mul('*'),
	Div('/'),
	Mod('%');

	private Character opChar;

	private Operator(Character c){
		this.opChar = c;
	}
	public Character getOpChar(){
		return this.opChar;
	}

	public int apply(int x, int y){
		switch(opChar){
		case '+': return x + y;
		case '-': return x - y;
		case '*': return x * y;
		case '/': return x / y;
		case '%': return x % y;
		default:
			throw new IllegalArgumentException("not supported operation.");
		}
	}

	public int apply(Character a, Character b){
		return apply(Integer.valueOf(Character.toString(a)),
				Integer.valueOf(Character.toString(b)));
	}

	public static boolean isOperator(Character c){
		for (Operator o : Operator.values()){
			if (c == o.getOpChar()){
				return true;
			}
		}
		return false;
	}

	public static Operator getOperator(Character c){
		for (Operator o : Operator.values()){
			if (c == o.getOpChar()){
				return o;
			}
		}
		return null;
	}

}
