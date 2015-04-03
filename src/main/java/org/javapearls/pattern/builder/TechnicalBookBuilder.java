package org.javapearls.pattern.builder;

public class TechnicalBookBuilder implements BookBuilder {

	private Book book;

	public TechnicalBookBuilder(){
		book = new Book();
	}

	public void buildTableOfContent() {
		book.setTableOfContent("Java 101");
	}

	public void buildPreface() {
		book.setPreface("Technical book Preface");
	}

	public void buildIntroduction() {
		book.setIntroduction("Technical book introduction");
	}

	public void buildChapters() {
		book.setChapters("Techincal book chapters");
	}

	public void buildGlossary() {
		book.setGlossary("Technical book Glossary");
	}

	public Book getBook() {
		return book;
	}

}
