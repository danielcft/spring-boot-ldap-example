package dk.digitalidentity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dk.digitalidentity.app.ActiveDirectoryHelper;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		ActiveDirectoryHelper activeDirectoryHelper = ctx.getBean(ActiveDirectoryHelper.class);
		boolean result = activeDirectoryHelper.authenticate("baseDN","password");
		System.out.println( (result == true) ? "logged in" : "not logged in");
	}

}
