package org.javapearls.foundation;

import static org.junit.Assert.*;


import org.javapearls.foundation.HashCodeExample;
import org.junit.Test;


public class TestEqualAndHashCode {

	@Test
	public void testEquals(){
		HashCodeExample e1 = new HashCodeExample(true, (byte)12, 12345, 3.14);
		HashCodeExample e2 = new HashCodeExample(true, (byte)12, 12345, 3.14);

		assertTrue(e1.equals(e2));
		assertTrue(e1.hashCode() == e2.hashCode());
	}

}
