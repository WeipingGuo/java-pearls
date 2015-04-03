package org.javapearls.algorithm.planesweep;

import java.util.Comparator;

public class VerticalComparator implements Comparator<Point> {

	@Override
	public int compare(Point p1, Point p2) {

		if (p1.y < p2.y){
			return -1;
		}
		if (p1.y > p2.y){
			return 1;
		}
		if (p1.x < p2.x){
			return -1;
		}
		if (p1.x > p2.x){
			return 1;
		}
		return 0;
	}

}
