package org.hymer.test.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent {
	
	public static void main(String[] args) {
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		try {
			ObjectName on = new ObjectName("hymer:name=HelloWorld");
			mBeanServer.registerMBean(new Hello(), on);
			ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
			HtmlAdaptorServer adapterServer = new HtmlAdaptorServer();
			mBeanServer.registerMBean(adapterServer, adapterName);
			adapterServer.start();
			System.out.println("Start...");
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InstanceAlreadyExistsException e) {
			e.printStackTrace();
		} catch (MBeanRegistrationException e) {
			e.printStackTrace();
		} catch (NotCompliantMBeanException e) {
			e.printStackTrace();
		}
	}
	
}
