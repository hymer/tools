package org.hymer.test;

import java.util.Random;

public class CharIntTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		int i = 97;
		i += random.nextInt(26);
		System.out.println("out:" + i);
		System.out.println("out(char):" + (char)i);
	}

}
