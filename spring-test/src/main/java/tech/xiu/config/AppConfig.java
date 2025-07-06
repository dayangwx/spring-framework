package tech.xiu.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import tech.xiu.pojo.Person;

@Import(MyImportBeanDefinitionRegistrar.class)
@Configuration
public class AppConfig {



}

class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinition beanDefinition = new RootBeanDefinition(Person.class);
		beanDefinition.getPropertyValues().add("name", "明明");
		beanDefinition.getPropertyValues().add("age", 18);
		registry.registerBeanDefinition("person", beanDefinition);
//
		BeanDefinition beanDefinition2 = new RootBeanDefinition(Person.class);
		beanDefinition2.getPropertyValues().add("name", "红红");
		beanDefinition2.getPropertyValues().add("age", 20);
		registry.registerBeanDefinition("person", beanDefinition2);

	}
}
