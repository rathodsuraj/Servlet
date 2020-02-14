package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	public static void main(String[] args) {

		Resource rs = new ClassPathResource("bean.xml");
		BeanFactory bf = new XmlBeanFactory(rs);

		Car out = bf.getBean("stu", Car.class);

		System.out.println(out);

	}

}
