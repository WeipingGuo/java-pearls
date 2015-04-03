package org.javapearls.pattern.builder;

public class BookWriter {

	private BookBuilder builder;

	public BookWriter(BookBuilder builder){
		this.builder = builder;
	}

	public Book getBook(){
		return this.builder.getBook();
	}

	public void writeBook(){
		this.builder.buildTableOfContent();
		this.builder.buildPreface();
		this.builder.buildIntroduction();
		this.builder.buildChapters();
		this.builder.buildGlossary();
	}
}
