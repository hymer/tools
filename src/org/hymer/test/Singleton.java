package org.hymer.test;

//public class Singleton {
//	
//	public static Singleton instance = new Singleton();
//	public static int a;
//	public static int b = 10;
//	
//	private Singleton() {
//		super();
//		a++;
//		b++;
//	}
//	
//	public static Singleton getInstance() {
//		return instance;
//	} 
//	
//}

public class Singleton {

	/**
	 * 只有静态内部类才能从ClassLoader机制上避免多次实例化，当然前提是ClassLoader必须是单一的
	 * 
	 * @author hewang
	 *
	 */
	private static class Holder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static int a;
	public static int b = 10;
	private Singleton() {
		super();
		a++;
		b++;
	};

	public static Singleton getInstance() {
		return Holder.INSTANCE;
	}
}
