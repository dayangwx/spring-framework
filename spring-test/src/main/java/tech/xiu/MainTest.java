package tech.xiu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.xiu.config.MyConfig;
import tech.xiu.pojo.Cat;
import tech.xiu.pojo.Person;

public class MainTest {

	public static void main(String[] args) {
//		test1ForBeanDefinitionRegister();

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//		Cat cat = context.getBean("cat", Cat.class);
//		Cat cat2 = context.getBean("cat", Cat.class);
//		System.out.println(cat==cat2);

		Person person1 = context.getBean("person", Person.class);
		Cat cat1 = person1.getCat();// 在有@Lookup注解的情况下，会去调用Spring容器利用cglib生成的子类当中的getCat()方法

		Person person2 = context.getBean("person", Person.class);
		Cat cat2 = person2.getCat();
		System.out.println(cat1 == cat2);
	}

	private static void test1ForBeanDefinitionRegister() {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		Cat cat = context.getBean(Cat.class);
		Person person2 = context.getBean("person2", Person.class);
		Person person3 = context.getBean("person3", Person.class);
		System.out.println(cat);
		System.out.println(person2);
		System.out.println(person3);
//		String[] beanDefinitionNames = context.getBeanDefinitionNames();
//		for (String beanName : beanDefinitionNames) {
//			System.out.println(beanName);
//		}
	}
}
