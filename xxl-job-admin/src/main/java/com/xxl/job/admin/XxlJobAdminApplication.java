package com.xxl.job.admin;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
public class XxlJobAdminApplication {


	/**
	 * 使用类路径命名空间，使得proguard混淆后，spring能区分实例
	 */
	public static class CustomGenerator implements BeanNameGenerator {
		@Override
		public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
			return definition.getBeanClassName();
		}
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(XxlJobAdminApplication.class)
				.beanNameGenerator(new CustomGenerator())
				.run(args);
	}


	/*public static void main(String[] args) {

		SpringApplication.run(XxlJobAdminApplication.class, args);
	}*/

}