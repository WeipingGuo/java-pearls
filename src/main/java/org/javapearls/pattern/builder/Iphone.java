package org.javapearls.pattern.builder;


/**
 * The object produced by the builder is immutable.
 *
 * @author wguo
 *
 */
public class Iphone {

	private String iosVersion;
	private int screenSize;
	private int memory;
	private boolean backCamera;
	private String cover;

	public static class Builder{
		private String iosVersion;
		private int screenSize;
		private int memory;
		private boolean backCamera;
		private String cover;

		public Builder(String iosVersion, int screenSize){
			this.iosVersion = iosVersion;
			this.screenSize = screenSize;
		}
		public Builder memory(int memory){
			this.memory = memory;
			return this;
		}
		public Builder backCamera(boolean backCamera){
			this.backCamera = backCamera;
			return this;
		}
		public Builder cover(String cover){
			this.cover = cover;
			return this;
		}
		public Iphone build(){
			return new Iphone(this);
		}

	}

	private Iphone(Builder builder){
		this.iosVersion = builder.iosVersion;
		this.screenSize = builder.screenSize;
		this.memory = builder.memory;
		this.backCamera = builder.backCamera;
		this.cover = builder.cover;
	}

	public String getIosVersion() {
		return iosVersion;
	}
	public int getScreenSize() {
		return screenSize;
	}
	public int getMemory() {
		return memory;
	}
	public boolean isBackCamera() {
		return backCamera;
	}
	public String getCover() {
		return cover;
	}

}
