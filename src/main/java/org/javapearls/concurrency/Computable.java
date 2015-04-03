package org.javapearls.concurrency;

public interface Computable <A, V> {
	V compute(A arg) throws InterruptedException;
}
