package org.javapearls.doc;

public class AllAboutJava {


//	ALL ABOUT JAVA
//
//	   //    http://www.leetcode.com/
//
//	1. GC:
//		Young, old (tenure) generation, and perm heap.
//		Young -- Eden space, Survivor 1 and Survivor 2
//		minor GC: eden -> survivor 1 -> survivor 2, when young generation fills up, minor GC is invoked.
//		major GC: young -> old
//		three types of GC:
//			1) Throughput Garbage Collector:  -XX:+UseParallelGC, multiple threads
//			2) Concurrent low pause Collector(Concurrent Mark Sweep Garbage collector): -XX:+UseConcMarkSweepGC:
//				it uses a separate gc thread to do parts of hte major collection concurrently with the app threads.
//			3) The Incremental (Sometimes called train) low pause collector: -XX:+UseTrainGC [not actively used]
//
//		A serial collector --> a single-threaded collector,
//		parallel collector --> multiple threads to collect garbage.
//
//		concurrent garbage collector --> (unable to finish before the tenured generation fill up)
//		===> full GC.
//
//	2. Heap space:
//		"java.lang.OutOfMemoryError: Java heap space" -- Java heap does not have sufficient space and cannot be expanded further
//		"java.lang.OutOfMemoryError: PermGen space" -- the permanent generation of Java Heap is full,
//			the application will fail to load a class or to allocate an interned string.
//
//
//	3. Why String is immutable?
//		once created, a String object cannot be changed
//		1). String can be shared between different threads;
//		2). Allow String to cache its hashcode, faster for HashMap
//		3).
//
//	4. String pool: it's a collection of references to String objects;
//		Objects are created on the heap and Strings are no exception.
//		So, Strings that are part of the "String Literal Pool" still live on the heap,
//		but they have references to them from the String Literal Pool.
//
//		String literals always have a reference to them from the String Literal Pool.
//		That means that they always have a reference to them and are, therefore, not eligible for garbage collection.
//
//	5. HashMap:
//
//		HashMap accepts null while HashTable does not.
//		HashMap is not synchronized while Hashtable is
//
//		HashMap is fast and so on along with basics like its stores key and value pairs etc
//		HashMap  stores both key and value object in bucket which is essential to understand the retrieving logic
//
//		Rehashing: by creating another new bucket array of size twice of previous size of HashMap ,
//		and then start putting every old element into that new bucket array and this process is called rehashing
//		because it also applies hash function to find new bucket location.
//		Race condition during rehashing.
//
//
//		How HashMap  works in Java:
//			HashMap  works on principle of hashing, we have put () and get () method for storing and retrieving object
//		form HashMap .When we pass an both key and value to put() method to store on HashMap , it uses key object hashcode()
//		method to calculate hashcode and they by applying hashing on that hashcode it identifies bucket location for storing
//		value object.	While retrieving it uses key object equals method to find out correct key value pair and return value
//		object associated with that key. HashMap  uses linked list in case of collision and object will be stored in next
//		node of linked list. Also HashMap  stores both key+value tuple in every node of linked list.
//
//		What will happen if two different HashMap  key objects have same hashcode?
//			They will be stored in same bucket but no next node of linked list. And keys equals () method will be used
//		to identify correct key value pair in HashMap .
//
//		Map m = Collections.synchronizeMap(hashMap);
//
//	6. equals()
//
//		default implementation of equals() class provided by Object class compares memory location and
//		only return true if two reference variable are pointing to same memory location i.e.
//		essentially they are same object.
//
//		1) If two objects are equal by equals() method then there hashcode must be same.
//		2) If two objects are unequal by equals() method then there hashcode could be same or different.
//
//	7. hashcode()
//
//		1) If two objects are equal by equals() method then there hashcode returned by hashCode() method must be same.
//		2) Whenever hashCode() mehtod is invoked on the same object more than once within single execution of application,
//		hashCode() must return same integer provided no information or fields used in equals and hashcode is modified.
//		This integer is not required to be same during multiple execution of application though.
//		3) If two objects are not equals by equals() method it is not require that there hashcode must be different.
//		Though it’s always good practice to return different hashCode for unequal object.
//		Different hashCode for distinct object can improve performance of hashmap or hashtable by reducing collision.
//
//		EqualsBuilder and HashCodeBuilder from Apache commons are much better way to override equals and hashcode methods
//
//	8. String: immutable, String is represented using UTF-16 format in Java.
//		If String are created using String literal they remain in String pool.
//		StringBuffer is String is immutable while StringBuffer is mutable.
//		1) String is immutable while StringBuffer and StringBuilder is mutable object.
//		2) StringBuffer is synchronized while StringBuilder is not which makes StringBuilder faster than StringBuffer.
//		3) Concatenation operator "+" is internal implemented using either StringBuffer or StringBuilder.
//		4) Use String if you require immutability, use Stringbuffer in java if you need mutable + threadsafety
//		and use StringBuilder in Java if you require mutable + without thread-safety.
//
//		StringBuffer toString() ==> new String object is allocated and returned
//	9. What is immutable object? how to make an object immutable?
//	10. How substring() works? String in UTF-16 format.
//		The Java 2 platform uses the UTF-16 representation in char arrays and in the String and StringBuffer classes.
//
//		The substring begins at the specified beginIndex and extends to the character at index endIndex - 1.
//
//		String.substring() method, its implementation calls the following String(...) constructor :
//
//		// Package private constructor which shares value array for speed.
//		String(int offset, int count, char value[]) {
//		this.value = value;
//		this.offset = offset;
//		this.count = count;
//		}
//		That means the new String() object returned by substring(...) shares the same backing array
//		(this.value) as the original string object.
//		Thus if your original string object is 1GB long, the substring object will always be 1GB long too!
//
//	11. UTF-16 vs. UTF-8.
//		UTF-8 encodes each of the 1,112,064[7] code points in the Unicode character set using one to four 8-bit
//		bytes (termed "octets" in the Unicode Standard).
//		The first 128 characters (US-ASCII) need one byte. The next 1,920 characters need two bytes to encode.
//
//		Since UTF-8 is interpreted as a sequence of bytes, there is no endian problem as
//		there is for encoding forms that use 16-bit or 32-bit code units.
//
//		UTF-16 (16-bit Unicode Transformation Format) is a character encoding for Unicode capable of
//		encoding 1,112,064[1] numbers (called code points) in the Unicode code space from 0 to 0x10FFFF.
//		It produces a variable-length result of either one or two 16-bit code units per code poin t.
//		2 or 4 bytes?
//		UTF-16 uses a single 16-bit code unit to encode the most common 63K characters,
//		and a pair of 16-bit code units, called surrogates, to encode the 1M less commonly used characters in Unicode.
//
//		Surrogates are code points from two special ranges of Unicode values,
//		reserved for use as the leading, and trailing values of paired code units in UTF-16.
//
//		Surrogates are code points from two special ranges of Unicode values, reserved for use as the leading,
//		and trailing values of paired code units in UTF-16. Leading, also called high, surrogates are from D80016 to DBFF16,
//		and trailing, or low, surrogates are from DC0016 to DFFF16. They are called surrogates,
//		since they do not represent characters directly, but only as a pair.
//
//	12. What is difference between Executor.submit() and Executer.execute() method ?
//		Former returns an object of Future which can be used to find result from worker thread
//	13. What is the difference between factory and abstract factory pattern?
//		Abstract Factory provides one more level of abstraction.
//		Consider different factories each extended from an Abstract Factory and responsible for
//		creation of different hierarchies of objects based on the type of factory.
//		E.g. AbstractFactory extended by AutomobileFactory, UserFactory, RoleFactory etc.
//		Each individual factory would be responsible for creation of objects in that genre.
//
//		One of the main advantages of Abstract Factory Pattern is that it isolates the
//		concrete classes that are generated. The names of actual implementing classes are not
//		needed to be known at the client side. Because of the isolation, you can change the
//		implementation from one factory to another.
//
//	14. Java collection
//		Note that Iterator.remove is the only safe way to modify a collection during iteration;
//		the behavior is unspecified if the underlying collection is modified in any other way
//		while the iteration is in progress.
//
//		static void filter(Collection<?> c) {
//	    for (Iterator<?> it = c.iterator(); it.hasNext(); )
//	        if (!cond(it.next()))
//	            it.remove();
//		}
//		Object[] a = c.toArray();
//
//		Collection<String> c;
//		String[] a = c.toArray(new String[0]);
//
//	15. Set:
//		HashSet:  backed by a hash table (actually a HashMap instance). It makes no guarantees as to
//			the iteration order of the set; This class offers constant time performance for the basic
//			operations (add, remove, contains and size),
//		TreeSet, which stores its elements in a red-black tree, orders its elements based on their values
//
//	16. AtomicInteger, AtomicReference
//
//		class Sequencer {
//			private AtomicLong sequenceNumber = new AtomicLong(0);
//			public long next() { return sequenceNumber.getAndIncrement(); }
//		}
//
//	17. Generate random string
//		http://commons.apache.org/lang/api-2.5/org/apache/commons/lang/RandomStringUtils.html

// 	18. Avoid creating unnecessary objects:
//		Reuse immutable object, for example: String s = "hello"; instead of String s = new String("hello");
//		Use factory method: Boolean.valueOf(String)

	public void avoidCreatingUnnecessaryObjects(){
		Integer.valueOf("123");

		// use static initilizer
	}

// 	19. Memory leak:
// 	whenever a class manages its own memory, the programmer
//	should be alert for memory leaks. Whenever an element is freed, any
//	object references contained in the element should be nulled out




}
