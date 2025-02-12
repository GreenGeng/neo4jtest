package org.test.config;

import org.neo4j.driver.Driver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.neo4j.driver.Session;


@Component
public class ExampleCommandLineRunner  implements CommandLineRunner {
    private final Driver driver;
    private final ConfigurableApplicationContext applicationContext;
    public final Session session;

    @Bean
    Session session(){
        return session;
    }
    @Override
    public void run(String... args) throws Exception {

    }

    public ExampleCommandLineRunner(Driver driver,ConfigurableApplicationContext applicationContext){
        this.driver = driver;
        this.applicationContext = applicationContext;
        this.session = driver.session();
    }
}
