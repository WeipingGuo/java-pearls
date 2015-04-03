package org.javapearls.cup.chapter5;


/* Given a (decimal - e.g. 3.72) number that is passed in as a string,
 * print the binary representation.
 *
 * If the number can not be represented accurately in binary, print ERROR
 *
 * @author wguo
 *
 */
public class Question52 {

	public static String toBinaryString(String d){

		int index = d.indexOf('.');
		String intStr = null;
		String doubleStr = null;

		if (index != -1){
			intStr = d.substring(0, index);
			doubleStr = d.substring(index); // include '.'
		}
		else {
			intStr = d;
		}

		try{
			int left = Integer.parseInt(intStr);
			intStr = "";
			while (left > 0){
				int r = left % 2;
				left >>>= 1;
				intStr = r + intStr;
			}
		}catch (NumberFormatException e){
			return "ERROR";
		}

		StringBuilder sb = new StringBuilder();
		try{
			double right = Double.parseDouble(doubleStr);

			while (right > 0){
				if (sb.length() > 32) {
					return "ERROR";
				}

				if (right == 1){
					sb.append("1");
					break;
				}

				double r = right * 2;
				if (r >= 1){
					sb.append(1);
					right = r - 1;
				}
				else {
					sb.append(0);
					right = r;
				}
			}
		}catch (NumberFormatException e){
			return "ERROR";
		}

		return intStr + "." + sb.toString();
	}

	public static String doubleToBinaryString(double d){
		long l = Double.doubleToLongBits(d);
		return Long.toBinaryString(l);
	}

	/**
	 * To binary string for given decimal
	 *
	 * @param d the d
	 * @return the string
	 */
	public static String toBinaryString(double d){

		String doubleStr = Double.toString(d);

		int index = doubleStr.indexOf('.');

		String intStr = null;
		String precisionStr = null;
		if (index == -1){
			intStr = doubleStr;
		} else {
			intStr = doubleStr.substring(0, index);
			precisionStr = doubleStr.substring(index+1);
		}

		try{
			intStr = toBinaryString(Integer.parseInt(intStr));
		} catch (NumberFormatException e){
			System.err.println("Failed to parse to integer:" + intStr);
			return null;
		}

		if (precisionStr == null){
			return intStr;
		}

		try{
			precisionStr = toBinaryString(Integer.parseInt(precisionStr));
		}catch (NumberFormatException e){
			System.err.println("faield to parse to integer: " + precisionStr);
			return null;
		}

		return intStr + "." + precisionStr;
	}

	/**
	 * Solution from the book: it failed for simple test case "10.05"?
	 *
	 * @param n
	 * @return
	 */
	public static String printBinary(String n) {
		int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
		double decPart =
			Double.parseDouble(n.substring(n.indexOf('.'), n.length()));

		String int_string = "";
		while (intPart > 0) {
			int r = intPart % 2;
			intPart >>= 1;
			int_string = r + int_string;
		}

		StringBuffer dec_string = new StringBuffer();
		while (decPart > 0) {
			if (dec_string.length() > 32)
				return "ERROR";
			if (decPart == 1) {
				dec_string.append((int) decPart);
				break;
			}
			double r = decPart * 2;
			if (r >= 1) {
				dec_string.append(1);
				decPart = r - 1;
			} else {
				dec_string.append(0);
				decPart = r;
			}
		}
		return int_string + "." + dec_string.toString();
	}

	/**
	 * To binary string for integer
	 *
	 * @param n the n
	 * @return the string
	 */
	public static String toBinaryString(int n){

		char[] sb = new char[32];
		int mask = (1 << 31 );

		for (int i = 0; i <= 31; i++){
			if ((n&mask) == 0){
				sb[i] = '0';
			}
			else {
				sb[i] = '1';
			}
			n <<= 1;
		}
		return new String(sb);
	}


	/**
	 * Implementation used in JDK Integer.toBinaryString
	 * It proceeds from right to left. Also a static table
	 * is used to look up corresponding char. The preceding
	 * '0' is omitted.
	 *
	 * @param n
	 * @return
	 */
	public static String toBinaryStringJDK(int n){

		// from the right to left
		char[] res = new char[32];
		int pos = 32;
		int mask = 1;

		do{
			if ((n&mask) == 0){
				res[--pos] = '0';
			}
			else{
				res[--pos] = '1';
			}
			n >>>= 1;
		}while (n != 0);

		return new String(res, pos, (32 - pos));
	}

}
