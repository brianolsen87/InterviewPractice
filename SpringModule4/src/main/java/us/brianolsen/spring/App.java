package us.brianolsen.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import us.brianolsen.spring.model.Logger;

public class App {
	public static void main(String[] args) {
		ApplicationContext classPathContext = new ClassPathXmlApplicationContext("us/brianolsen/spring/beans.xml");

		testAutoWiringWithAnnotation(classPathContext);
		
		System.out.println("-------------------CLOSE CONTEXTS-------------------");
		((ClassPathXmlApplicationContext) classPathContext).close();
	}

	public static void testAutoWiringWithAnnotation(ApplicationContext context) {
		beforeTest("testAutoWiring");
		Logger logger = (Logger) context.getBean("logger");

		logger.writeFile("Hello there");
		logger.writeConsole("Hello Again");
	}

	public static void beforeTest(String label) {
		System.out.print("---------------------");
		System.out.print(label);
		System.out.println("---------------------");
	}
}
