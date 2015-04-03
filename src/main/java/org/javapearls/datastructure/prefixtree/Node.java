package org.javapearls.datastructure.prefixtree;

import java.util.HashMap;
import java.util.Map;

public class Node {

	private final Character ch;
	private final String value;
	private boolean isValidWord;
	private Map<String, Node> children = new HashMap<String, Node>();


	public Node(Character ch, String value){
		this.ch  = ch;
		this.value = value;
	}

	public boolean addChild(Node child){

		if (children.containsKey(Character.toString(child.getChar()))){
			return false;
		}

		children.put(Character.toString(child.getChar()), child);
		return true;
	}

	public Character getChar(){
		return this.ch;
	}
	public String getValue(){
		return this.value;
	}
	public boolean isValidWord(){
		return this.isValidWord;
	}
	public void setIsValidWord(boolean validWord){
		this.isValidWord = validWord;
	}

	public Node getChild(char c) {
        return children.get(Character.toString(c));
}

}
