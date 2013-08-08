package org.hymer.test;

public class ClassLoaderTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Singleton sing = Singleton.getInstance();
		System.out.println(sing.a);
		System.out.println(sing.b);
	}

}
