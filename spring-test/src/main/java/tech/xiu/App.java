package tech.xiu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.xiu.config.AppConfig;
import tech.xiu.pojo.Person;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = context.getBean("person", Person.class);
		System.out.println("Person: " + person);
	}
}
