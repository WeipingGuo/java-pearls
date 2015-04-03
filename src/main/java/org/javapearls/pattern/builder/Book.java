package org.javapearls.pattern.builder;

public class Book {

	private String introduction;
	private String tableOfContent;
	private String preface;
	private String chapters;
	private String glossary;

	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getTableOfContent() {
		return tableOfContent;
	}
	public void setTableOfContent(String tableOfContent) {
		this.tableOfContent = tableOfContent;
	}
	public String getPreface() {
		return preface;
	}
	public void setPreface(String preface) {
		this.preface = preface;
	}
	public String getChapters() {
		return chapters;
	}
	public void setChapters(String chapters) {
		this.chapters = chapters;
	}
	public String getGlossary() {
		return glossary;
	}
	public void setGlossary(String glossary) {
		this.glossary = glossary;
	}
	@Override
	public String toString() {
		return "Book [introduction=" + introduction + ", tableOfContent="
				+ tableOfContent + ", preface=" + preface + ", chapters="
				+ chapters + ", glossary=" + glossary + "]";
	}

}
