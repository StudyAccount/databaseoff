package ua.kiev.smartgroup.configuration;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.ConsoleAppender;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 23.11.2016.
 */
@Configuration
public class LogAspect {

    @Bean
    public static LoggerContext loggerContext() {
        return (LoggerContext) LoggerFactory.getILoggerFactory();
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public static PatternLayoutEncoder encoder (LoggerContext ctx) {
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(ctx);
        encoder.setPattern("%date %-5level [%thread] %logger{36} %m%n");
        return encoder;
    }

    @Bean (initMethod = "start", destroyMethod = "stop")
    public static ConsoleAppender consoleAppender (LoggerContext ctx, PatternLayoutEncoder encoder) {
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setContext(ctx);
        consoleAppender.setEncoder(encoder);
        return consoleAppender;
    }
//
//    @Bean (initMethod = "start", destroyMethod = "stop")
//    public static RollingFileAppender rollingFileAppender(LoggerContext ctx, PatternLayoutEncoder encoder) {
//        RollingFileAppender fileAppender = new RollingFileAppender();
//        fileAppender.setContext(ctx);
//        fileAppender.setEncoder(encoder);
//        fileAppender.setFile("build.log");
//        return fileAppender;
//    }
}
