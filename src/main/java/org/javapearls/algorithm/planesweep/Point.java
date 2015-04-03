package org.javapearls.algorithm.planesweep;

public class Point {

	public final double x;
	public final double y;

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double distance(Point p){
		double a = Math.pow(Math.abs(x - p.x), 2.0);
		double b = Math.pow(Math.abs(y - p.y), 2.0);
		return Math.sqrt(a + b);
	}

}
