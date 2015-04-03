package org.javapearls.pattern.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TestIphoneBuilder {

	@Test
	public void testBuilder(){
		Iphone iphone = new Iphone.Builder("6.0", 4).backCamera(true).memory(16).cover("plastic").build();

		assertEquals(iphone.getIosVersion(), "6.0");
		assertEquals(iphone.getScreenSize(), 4);
		assertTrue(iphone.isBackCamera());
		assertEquals(iphone.getMemory(),16);
		assertEquals(iphone.getCover(), "plastic");
	}

}
