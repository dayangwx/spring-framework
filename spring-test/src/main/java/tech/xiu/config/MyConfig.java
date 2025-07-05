package tech.xiu.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;
import tech.xiu.pojo.Cat;
import tech.xiu.pojo.Person;

//@Import({MyConfig.MyImportBeanDefinitionRegistrar.class})
@ComponentScan("tech.xiu")
@Configuration
public class MyConfig {

//	@Bean
//	public Person person() {
//		Person person = new Person();
//		person.setName("xiu");
//		person.setAge(18);
//		return person;
//	}

	static class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
		@Override
		public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

			BeanDefinition beanDefinition = new RootBeanDefinition(Cat.class);
			beanDefinition.getPropertyValues().add("name", "tomcatPo");
			beanDefinition.getPropertyValues().add("age", 3);
			registry.registerBeanDefinition("cat", beanDefinition);

			registry.registerBeanDefinition("person2",
					org.springframework.beans.factory.support.BeanDefinitionBuilder
					.genericBeanDefinition(Person.class)
					.addPropertyValue("name", "xiu")
					.addPropertyValue("age", 31)
					.getBeanDefinition());
			registry.registerBeanDefinition("person3",
					org.springframework.beans.factory.support.BeanDefinitionBuilder
					.genericBeanDefinition(Person.class)
					.addPropertyValue("name", "xiu2")
					.addPropertyValue("age", 32)
					.getBeanDefinition());
		}
	}
}
