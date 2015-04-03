package org.javapearls.pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class IphoneFactory implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2015452047004183888L;

	private static final IphoneFactory factory = new IphoneFactory();

	public static IphoneFactory instance() {
		return factory;
	}

	private IphoneFactory() {

	}

	private Object readResolve() throws ObjectStreamException {
		// instead of the object we're on,
		// return the class variable INSTANCE
		return factory;
	}

}
