package org.javapearls.foundation.thread.sync;

public interface Container {

	public void put(String msg);
	public String take();
}
