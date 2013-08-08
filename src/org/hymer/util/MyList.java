package org.hymer.util;


public class MyList {

	private Object[] objects = null;
	private int size = 0;
	private static final int STEP = 200;
	
	public MyList() {
		objects = new Object[STEP];
	}
	
	public int size() {
		return size;
	}
	
	public void add(Object object) {
		if (objects[size] != null) {
			Object[] tmp = objects;
			objects = new Object[size + STEP];
			System.arraycopy(tmp, 0, object, 0, size);
		}
		objects[size] = object;
		size ++;
	}
	
	public Object get(int index) {
		return objects[index];
	}
	
	public void remove(int index) {
		
	}

}
