package org.javapearls.concurrency;

import java.math.BigInteger;

public class ExpensiveFun implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		// expensive computing
		return new BigInteger(arg);
	}

}
