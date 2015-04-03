package org.javapearls.algorithm.oj;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestShortenUrl {

	@Test
	public void testShortUrl(){

		int id = 125;
		String encoded = ShortenUrl.encode(id);
		int decoded = ShortenUrl.decode(encoded);
		assertEquals(id, decoded);


		id = 19158;
		encoded = ShortenUrl.encode(id);
		assertEquals(encoded, "e9a");
		decoded = ShortenUrl.decode(encoded);
		assertEquals(id, decoded);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidUrl(){
		ShortenUrl.decode("http://www.exchange.com/");
	}

	@Test
	public void testShortenUrl(){
		int id = 125;
		String encoded = ShortenUrl.encode0(id);
		int decoded = ShortenUrl.decode0(encoded);
		assertEquals(id, decoded);


		id = 19158;
		encoded = ShortenUrl.encode0(id);
		decoded = ShortenUrl.decode0(encoded);
		assertEquals(id, decoded);
	}

}
