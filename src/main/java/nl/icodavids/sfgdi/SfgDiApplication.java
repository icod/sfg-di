package nl.icodavids.sfgdi;

import nl.icodavids.sfgdi.controllers.ConstructorBasedController;
import nl.icodavids.sfgdi.controllers.MyController;
import nl.icodavids.sfgdi.controllers.PropertyInjectedController;
import nl.icodavids.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) context.getBean("myController");

		System.out.println("---------- Primary bean");
		System.out.println(myController.sayHello());

		System.out.println("---------- Property");

		PropertyInjectedController propertyInjectedController =
				(PropertyInjectedController) context.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("---------- Setter");

		SetterInjectedController setterInjectedController =
				(SetterInjectedController) context.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("---------- Constructor");
		ConstructorBasedController constructorBasedController =
				(ConstructorBasedController) context.getBean("constructorBasedController");
		System.out.println(constructorBasedController.getGreeting());


	}

}
