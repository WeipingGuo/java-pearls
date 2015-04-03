package org.javapearls.foundation.thread;

public class ImmuntableRGB {

	private final int red;
	private final int green;
	private final int blue;
	private final String name;


	public ImmuntableRGB(int red, int green, int blue, String name){
		check(red, green, blue);
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.name = name;
	}

	public int getRed(){ return this.red; }
	public int getGreen() { return this.green; }
	public int getBlue() { return this.blue; }
	public String getName() { return this.name; }


	private void check(int red, int green, int blue){
		if (red < 0 || red > 255 ||
				green < 0 || green > 255 ||
				blue < 0  || blue > 255){
			throw new IllegalArgumentException("");
		}
	}
}
