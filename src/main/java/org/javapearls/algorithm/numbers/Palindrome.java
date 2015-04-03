package org.javapearls.algorithm.numbers;

public class Palindrome {

	/**
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 */
	public static boolean isPalindrome(int number){

		if (number < 0 ){
			number = number * (-1);
		}
		if (number < 10){
			return true;
		}

		String strNumber = Integer.toString(number);
		return isPalindrome(strNumber);
	}

	/**
	 * Concern: when the number is reversed, it could be overflow
	 *
	 * @param number
	 * @return
	 */
	public static boolean isPalindromeByReverse(int number){
		if (number < 0){
			number = (-1) * number;
		}
		return number == reverse(number);
	}


	/**
	 * Reverse an integer
	 *
	 * @param number
	 * @return
	 */
	public static int reverse(int number){
		int rev = 0;
		while (number != 0){
			rev = rev * 10 + number % 10;
			number = number /10;
		}
		return rev;
	}

	public static boolean isPalindromeCompareDigits(int number){

		System.out.println("is " + number + " a Palindrome?");
		int div = 1;
		int temp = number;
		while ( (temp = temp/10) != 0){
			div = div * 10;
		}

		System.out.println("div = " + div);

		while (number > 0){
			int firstDigit = number / div;
			int lastDigit = number % 10;
			System.out.println("first=" + firstDigit +",last=" + lastDigit);
			if (firstDigit != lastDigit){
				return false;
			}
			//number = (number - lastDigit - firstDigit * div)/10;
			number = (number % div)/10;
			div = div/100;
			System.out.println("number becomes: " + number);
		}
		return true;
	}

	public static boolean isPalindrome(String s){
		if (s== null || s.length() < 1){
			return false;
		}

		int i = 0;
		int j = s.length() - 1;
		while (i <= j){
			if (s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
