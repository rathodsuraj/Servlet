package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext apc = new ClassPathXmlApplicationContext("web.xml");

		Monitor out = apc.getBean("monitor", Monitor.class);
		System.out.println(out.getName());
		System.out.println(out.getValue());
		System.out.println(out.getKeyboard().getValue());
		System.out.println(out.getKeyboard().getColour());
		System.out.println("====================");
		
		Monitor outt=apc.getBean("rrr",Monitor.class);
		System.out.println(outt);

	}

}
