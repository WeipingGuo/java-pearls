package org.javapearls.algorithm.planesweep;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class Points {

	public static Point[] closedPairs(Point[] points){

		// to store the result
		Point[] closest = new Point[2];

		// sort based on x
		Point[] sorted = Arrays.copyOf(points, points.length);
		Arrays.sort(sorted, new HorizonalComparator());

		// the left-most candidate
		int leftMostCandidateIndex = 0;

		// store the candidate
		SortedSet<Point> candidates = new TreeSet<Point>(new VerticalComparator());

		double minDistance = Double.POSITIVE_INFINITY;

		for (Point current : sorted){

			// remove from the candidate set
			if (current.x - sorted[leftMostCandidateIndex].x > minDistance){
				candidates.remove(sorted[leftMostCandidateIndex]);
				leftMostCandidateIndex++;
			}

			// compute the head and tail over y
			Point head = new Point(current.x, current.y - minDistance);
			Point tail = new Point(current.x, current.y + minDistance);
			for (Point point : candidates.subSet(head, tail)){
				double distance = current.distance(point);

				if (distance < minDistance){
					minDistance = distance;
					closest[0] = current;
					closest[1] = point;
				}
			}

			candidates.add(current);
		}

		return closest;
	}

}
