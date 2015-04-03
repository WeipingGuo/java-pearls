package org.javapearls.pattern.singleton;

/**
 * Singleton
 * @author wguo
 *
 */
public enum DeviceFactory {

	/*
	 * readResolve is handled automatically
	 */
	INSTANCE;

	public Device createDevice(String id){
		return new Device(id);
	}

}
