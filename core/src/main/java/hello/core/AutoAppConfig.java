package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;
@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)) // 기존 AppConfig 제외

public class AutoAppConfig {

}