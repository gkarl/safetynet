package com.SafetyNet.alerts;

import com.SafetyNet.alerts.model.Database;
import com.SafetyNet.alerts.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class AlertsApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) throws IOException{

		// ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


		//Database database = new Database();
		//database.initDatabase();

		SpringApplication.run(AlertsApplication.class, args);
	}

/*	@SpringBootApplication
	public class AlertsApplication extends SpringBootServletInitializer {
		public static void main(String[] args) throws IOException {
			Database database = new Database();
			database.initDatabase();
			SpringApplication.run(com.SafetyNet.alerts.AlertsApplication.class, args);
		}*/

}
