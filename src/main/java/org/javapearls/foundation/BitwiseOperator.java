package org.javapearls.foundation;

import java.util.Arrays;


/**
 * http://vipan.com/htdocs/bitwisehelp.html
 * http://henkelmann.eu/2011/02/24/a_curse_on_java_bitwise_operators
 * http://graphics.stanford.edu/~seander/bithacks.html
 *
 * @author wguo
 *
 */
public class BitwiseOperator {

	// usually set mask as power of 2
	private static final int MASK = 4;

	/**
	 * set a flag
	 *
	 * @param flags
	 * @return
	 */
	public int set(int flags){
		// To set or turn on a flag bit(s)
		return flags | MASK;
	}

	/**
	 * Test whether flag is set or not
	 *
	 * @param flags
	 * @return
	 */
	public boolean isSet(int flags){
		if ((flags & MASK) == MASK){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Toggle a flag
	 * XOR: set bit to 1 only if there are different,
	 * 		set to 0 if they are the same
	 *
	 * @param flags
	 * @return
	 */
	public int toggle(int flags){
		return flags ^ MASK;
	}

	/**
	 * Turn off bit flag
	 *
	 * @param flags
	 * @return
	 */
	public int unset(int flags){
		return flags & ~MASK;
	}


	// Define masks for lowest level permissions as constants which
    // are powers of 2. This ensures that only one bit in an integer
    // is set to 1.  Make these private because combinations will be
    // used to publicly access valid permission sets.
    public static final int VIEW = 4;
    public static final int ADD = 16;
    public static final int EDIT = 32;
    public static final int DELETE = 256;

    // Obtain valid permission sets by Bitwise ORing lower level permissions
    public static final int NOTHING_ALLOWED = 0;
    public static final int VIEW_ALLOWED = VIEW;
    public static final int VIEW_ADD_ALLOWED = VIEW | ADD;
    public static final int VIEW_EDIT_ALLOWED = VIEW | EDIT;
    public static final int VIEW_ADD_EDIT_ALLOWED = VIEW | ADD | EDIT;
    public static final int ALL_ALLOWED = VIEW | ADD | EDIT | DELETE;
    // Or, alternately
    //public static final int ALL_ALLOWED = VIEW_ADD_EDIT_ALLOWED | DELETE;

    public static final int [] validPermissions = {
        NOTHING_ALLOWED,
        VIEW_ALLOWED,
        VIEW_ADD_ALLOWED,
        VIEW_EDIT_ALLOWED,
        VIEW_ADD_EDIT_ALLOWED,
        ALL_ALLOWED,
    };

    static {
    	Arrays.sort(validPermissions);
    }


	/**
	 * builds two nibbles from a byte
	 *
	 * @param b
	 *            the byte to divide into nibbles
	 * @return two bytes with the lower 4 bits as nibbles of the input, first hi
	 *         then lo nibble.
	 */
	public static byte[] getNibbles(byte b) {
		return new byte[] {
				// move the four high bits to the right,
				// fill up with zeros

				// Something really interesting here:
				// Java bitwise operation is always in ints
				// therefore, there is what happening:
				//	- turn b into an int
				//	- unsigned right shift 4 by filling up zeros
				//	- convert result back to byte by truncating first 24 bits
				//	HOWEVER, promoting byte to integer preserves the sign:
				//	0xF4 =>
				//	/*promote to int*/
				//	0xFFFFFFF4 =>
				//	/*unsigned shift*/
				//	0x0FFFFFFF =>
				//	/*downcast to byte*/
				//	0xFF
				// SOLUTION: (byte)((b & 0xFF) >>> 4)
				(byte) (b >>> 4),
				// zero out the four high bits and leave
				// the low bits untouched
				(byte) (b & 0x0F) };
	}


	public static int reverseBits(int x) {

		for (int i = 0; i < 16; i++) {
			x = swapBit(x, i, 31 - i);
		}

		return x;
	}

	public static int swapBit(int x, int i, int j) {
	  
	  int low = (x >> i) & 1;
	  int high = (x >> j) & 1;

	  // bits are different, swap them
	  if ((low ^ high) == 1) {
	    x ^= ((1 << i) | (1 << j));
	  }
	  return x;
	}

	public static String intInBinary(int x) {

//		return Integer.toBinaryString(x);

		StringBuffer sb = new StringBuffer();
		while (x != 0) {
			if ((x & 1) == 1) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			x >>>= 1;
		}
		return sb.reverse().toString();
	}

	public static String toBinary(int x) {
		char[] res = new char[32];
		int i = 32;
		while (x != 0) {
			if ((x & 1) == 1) {
				res[--i] = '1';
			} else {
				res[--i] = '0';
			}

			x >>>= 1;
		}
		return new String(res, i, 32 - i);
	}

}
