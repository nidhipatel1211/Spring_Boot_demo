package com.example.demo.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class buisnessclass {
	@Autowired
	dependency1 dep1;
	@Autowired
	dependency2 dep2;

	public String toString() {
		return "Using" + dep1 + "and" + dep2;
	}
}

@Component
class dependency1 {

}

@Component
class dependency2 {

}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(buisnessclass.class));
		}
	}
}
