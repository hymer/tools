package org.hymer.test.jmx;

public class Hello implements HelloMBean {
	
	private String name;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void print() {
		System.out.println("hello." + this.name);
	}

	@Override
	public void print(String who) {
		System.out.println("hello, " + who + "!");
	}

}
