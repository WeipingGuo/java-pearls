package org.javapearls.pattern.singleton;

import static org.junit.Assert.assertSame;

import org.junit.Test;


public class TestIphoneFactory {

	@Test
	public void testSingleton(){
		IphoneFactory factory = IphoneFactory.instance();
		IphoneFactory factory2 = IphoneFactory.instance();
		assertSame(factory, factory2);
	}

}
