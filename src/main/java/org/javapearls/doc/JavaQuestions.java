package org.javapearls.doc;

public class JavaQuestions {

	// 	1. why notify(), wait(), notifyAll() == define in the Object class, not in thread
	//		a. Due to locking requirements: Locks are made available on per Object basis
	//		b. Java is based on Hoare's monitors idea. In Java all object has a monitor.
	//			Threads waits on monitors so, to perform a wait, we need 2 parameters:
	//					- a Thread
	//					- a monitor (any object)
	//
	//	2. why multi-inheritence is not supported in Java: Diamond problem. It creates problems
	//		associated with casting, constuctor.
	//
	//	3. why String is immutable? thread safe, cache hash code
	//
	//	4. why char array is preferred than string to store password?
	//		a. security issue: memory dump
	//		b. print or log: print(char[]) will print memory address
	//
	//	5. wait(), notify(), notifyAll() must be called in a synchronized block or method?
	//
	//


}
