package org.javapearls.foundation.iterator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIterator {

	private BufferedReader reader;
	private String currentLine;

	public FileIterator(String fileName){
		if (fileName == null || fileName.length() < 1){
			throw new IllegalArgumentException("empty or null file name");
		}
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("invalid file");
		}
	}

	public boolean hasNext() {
		try {
			currentLine = reader.readLine();
		} catch (IOException e) {
			currentLine = null;
		}

		if (currentLine != null){
			return true;
		}else{
			return false;
		}
	}

	public String next() {
		return currentLine;
	}

}
