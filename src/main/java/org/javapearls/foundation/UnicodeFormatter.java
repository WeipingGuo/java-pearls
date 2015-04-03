package org.javapearls.foundation;

public class UnicodeFormatter {

	public static String byte2Hex(byte b){
		char hexDigit[] = {
				'0', '1', '2', '3', '4', '5', '6', '7',
		        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		char[] array = {hexDigit[b >> 4 & 0x0f], hexDigit[b & 0x0f]};
		return new String(array);
	}

	public static String char2Hex(char c){
		byte hi = (byte)(c >>> 8);
		byte low = (byte)(c & 0xff);
		return byte2Hex(hi) + byte2Hex(low);
	}

}
