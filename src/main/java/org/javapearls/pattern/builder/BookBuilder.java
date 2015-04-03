package org.javapearls.pattern.builder;


/*
 * Builder Pattern:
 * "Separate the construction of a complex object from its representation
 * 	so that the same construction process can create different representations"
 *
 * Elements: Builder, ConcreteBuilder, Director, and Product
 *
 * Builder pattern emphasizes steps. Each step adds some thing  to the object
 *
 * Abstract Factory pattern is also used to build complex object
 *
 */
public interface BookBuilder {

	 public void buildTableOfContent();
     public void buildPreface();
     public void buildIntroduction();
     public void buildChapters();
     public void buildGlossary();
     public Book getBook();
     
}
