package org.javapearls.pattern.builder;

public class FictionalBookBuilder implements BookBuilder {

	private Book book;

	public FictionalBookBuilder(){
		book = new Book();
	}

	public void buildTableOfContent() {
		book.setTableOfContent("Fictional book table of contents");
	}

	public void buildPreface() {
		book.setPreface("Fictional book preface");
	}

	public void buildIntroduction() {
		book.setIntroduction("Fictional book introduction");
	}

	public void buildChapters() {
		book.setChapters("Fictional book Chapters");
	}

	public void buildGlossary() {
		book.setGlossary("Fictional book Glossy");
	}

	public Book getBook() {
		return book;
	}

}
