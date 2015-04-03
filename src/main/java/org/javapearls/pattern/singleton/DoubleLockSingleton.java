package org.javapearls.pattern.singleton;

public class DoubleLockSingleton {

	private static volatile DoubleLockSingleton instance = null;

	/**
	 * Pay attention to the volatile modifier here. :) It is important	because without it,
	 * other threads are not guaranteed by the JMM (Java Memory Model) to see changes to
	 * its value. The synchronization does not take care of that-- it only serializes
	 * access to that block of code
	 * @return
	 */
	public static DoubleLockSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleLockSingleton.class) {
				if (instance == null)
					instance = new DoubleLockSingleton();
			}
		}
		return instance;
	}

}
