package com.example.demo.a2;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

	@Component
	class buisnessclass {

		dependency1 dep1;

		dependency2 dep2;

		@Autowired
		public void setDep1(dependency1 dep1) {
			System.out.println("SetterInjection   Dependency-1");
			this.dep1 = dep1;
		}

		@Autowired
		public void setDep2(dependency2 dep2) {
			System.out.println("SetterInjection   Dependency-2");
			this.dep2 = dep2;
		}

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


