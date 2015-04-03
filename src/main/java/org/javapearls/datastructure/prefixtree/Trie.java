package org.javapearls.datastructure.prefixtree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

	private Map<String, Node> roots = new HashMap<String, Node>();

	public Trie(){

	}

	public Trie(List<String> words){
		for (String s : words){
			addWord(s);
		}
	}

	public void addWord(String word){
		addWord(word.toCharArray());
	}

	public void addWord(char[] word){

		String key = Character.toString(word[0]);
		if (!roots.containsKey(key)){
			roots.put(key, new Node(word[0], key));
		}

		Node current = roots.get(key);
		for (int i = 1; i < word.length; i++){
			if (current.getChild(word[i]) == null){
				current.addChild(new Node(word[i], current.getValue() + word[i]));
			}
			current = current.getChild(word[i]);
		}

		current.setIsValidWord(true);
	}

	public boolean containPrefix(String prefix){
		return contain(prefix.toCharArray(), false);
	}

	public boolean containWord(String word){
		return contain(word.toCharArray(), true);
	}

	public Node getPrefix(String prefix){
		return getNode(prefix.toCharArray());
	}

	public Node getWord(String word){
		Node node = getNode(word.toCharArray());
		return (node != null && node.isValidWord()) ? node : null;
	}

	public boolean contain(char[] array, boolean isWord){
		Node node = getNode(array);
		return (node != null && node.isValidWord() && isWord) || (!isWord && node != null);
	}

	private Node getNode(char[] array){

		Node current = roots.get(Character.toString(array[0]));
		if (current == null) {
			return null;
		}

		for (int i = 1; i < array.length; i++){
			current = current.getChild(array[i]);
			if (current == null){
				break;
			}
		}

		return current;
	}

	public String toString(){
		return roots.toString();
	}

}
