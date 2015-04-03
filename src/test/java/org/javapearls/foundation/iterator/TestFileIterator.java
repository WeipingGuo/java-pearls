package org.javapearls.foundation.iterator;

import org.junit.Test;

public class TestFileIterator {

	@Test
	public void testFileIterator(){

		System.out.println("current dir: " + System.getProperty("user.dir"));
		FileIterator iterator = new FileIterator("test");
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}
