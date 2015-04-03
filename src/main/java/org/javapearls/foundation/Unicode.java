package org.javapearls.foundation;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;


public class Unicode {

	public static void main(String[] args){

		String a = "a";
		try {
			byte[] utf8array = a.getBytes("UTF-8");
			byte[] utf16array = a.getBytes("UTF-16");

			System.out.println("utf8 byte len: " + utf8array.length);
			System.out.println("utf16 byte len: " + utf16array.length);

			System.out.println("size of char:" + Character.SIZE);

			String original = new String("A" + "\u00ea" + "\u00f1" + "\u00fc" + "C");

			byte[] utf8Bytes = original.getBytes("UTF8");
		    byte[] defaultBytes = original.getBytes();
		    System.out.println("utf8bytes: " + utf8Bytes.length);
		    System.out.println("defaultBytes: " + defaultBytes.length);

			String roundTrip = new String(utf8Bytes, "UTF8");
			System.out.println("roundTrip = " + roundTrip);
			System.out.println();
			printBytes(utf8Bytes, "utf8Bytes");
			System.out.println();
			printBytes(defaultBytes, "defaultBytes");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void printBytes(byte[] array, String name) {
	    for (int k = 0; k < array.length; k++) {
	        System.out.println(name + "[" + k + "] = " + "0x" +
	            UnicodeFormatter.byte2Hex(array[k]));
	    }
	}

	public boolean isUtf8Encoded(byte[] data){
		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
		try{
			decoder.decode(ByteBuffer.wrap(data));
			return true;
		}catch (CharacterCodingException e){
			return false;
		}
	}


}
