package org.javapearls.pattern.singleton;

import static org.junit.Assert.*;

import org.javapearls.pattern.singleton.DeviceFactory;
import org.junit.Test;

public class TestDeviceFactory {


	@Test
	public void testSingleton(){
		DeviceFactory factory = DeviceFactory.INSTANCE;
		DeviceFactory factory2 = DeviceFactory.INSTANCE;
		assertSame(factory, factory2);
		assertTrue(factory.compareTo(factory2) == 0);
	}

	@Test
	public void testCreateDevice() {
		DeviceFactory factory = DeviceFactory.INSTANCE;
		factory.createDevice("123");
	}

}
