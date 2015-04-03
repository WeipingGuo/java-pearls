package org.javapearls.concurrency;

import sun.misc.*;

public class UnsafeDemo {

	public static void main(String[] args){

		final Unsafe unsafe = Unsafe.getUnsafe();

		try {
			Object obj = unsafe.allocateInstance(UnsafeDemo.class);

			if (obj instanceof UnsafeDemo){

			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

}
