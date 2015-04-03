package org.javapearls.foundation.threadlocal;

import java.util.UUID;

public class SessionId {

	private static final ThreadLocal<String> id = new ThreadLocal<String>(){
		protected String initialValue(){
			return UUID.randomUUID().toString();
		}
	};

	public static String get(){
		return id.get();
	}

	public static void remove(){
		id.remove();
	}
}
