package ua.kiev.smartgroup.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 23.11.2016.
 */
@Configuration
public class AppConfig {

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }

//    @Bean
//    public Employee employee(){
//        return new Employee();
//    }
}
