package org.hymer.test.jmx;

public interface HelloMBean {

	String getName();
	
	void setName(String name);
	
	void print();
	
	void print(String who);

}
