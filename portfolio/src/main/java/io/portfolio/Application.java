package io.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;

/**
 * Created by gfoster on 9/26/15.
 */
@ImportResource("classpath:/integration/stock-simulation.xml")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(Application.class, args);
		c.getBean(WebSocketConfigurer.class);
		System.out.println("test");
	}
}
