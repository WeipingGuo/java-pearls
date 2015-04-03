package org.javapearls.algorithm.oj;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLevenshteinDistance {

	@Test
	public void testLevenshenteinDistance(){

		String x = "hello";
		String y = "hello";
		int distance = LevenshteinDistance.distance(x, y);
		assertEquals(distance, 0);

		x = "kitten";
		y = "sitting";
		distance = LevenshteinDistance.distance(x, y);
		assertEquals(distance, 3);


		x = "Saturday";
		y = "Sunday";
		distance = LevenshteinDistance.distance(x, y);
		assertEquals(distance, 3);
	}

}
