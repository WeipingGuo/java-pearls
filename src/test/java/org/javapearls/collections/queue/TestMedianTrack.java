package org.javapearls.collections.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMedianTrack {

	@Test
	public void testMedian(){
		MedianTrack track = new MedianTrack();

		track.add(5);
		int median = track.getMedian();
		assertEquals(median, 5);

		track.add(10);
		assertEquals(track.getMedian(), 7);

		track.add(6);
		assertEquals(track.getMedian(), 6);

		track.add(8);
		assertEquals(track.getMedian(), 7);
	}

}
