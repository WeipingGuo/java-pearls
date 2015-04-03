package org.javapearls.pattern.builder;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBookWriter {

	@Test
	public void testGetTechBook() {
		TechnicalBookBuilder builder = new TechnicalBookBuilder();
		BookWriter writer = new BookWriter(builder);
		writer.writeBook();
		Book book = writer.getBook();

		System.out.println(book);

		assertEquals("Java 101", book.getTableOfContent());

	}

	@Test
	public void testBuildFictionalBook() {

		FictionalBookBuilder builder = new FictionalBookBuilder();
		BookWriter writer = new BookWriter(builder);

		writer.writeBook();
		Book book = writer.getBook();

		System.out.println(book);

		assertEquals("Fictional book Chapters", book.getChapters());
	}

}
