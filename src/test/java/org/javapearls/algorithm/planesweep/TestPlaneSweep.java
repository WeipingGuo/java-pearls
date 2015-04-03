package org.javapearls.algorithm.planesweep;

import org.junit.Test;

public class TestPlaneSweep {

	@Test
	public void testClosestPair(){
		Point p1 = new Point(1.0, 2.0);
		Point p2 = new Point(7.0, 10.0);
		Point p3 = new Point(5.0, 5.0);
		Point p4 = new Point(8.0, 20.0);

		Point[] points = new Point[4];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		points[3] = p4;

		Point[] res = Points.closedPairs(points);
		System.out.println(res[0].x + "," + res[0].y);
		System.out.println(res[1].x + "," + res[1].y);


	}

}
